package com.pyrospiral.android.templateapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pyrospiral.android.templateapp.Animation.ExpensesFragment;

import java.util.ArrayList;
import java.util.List;


public class NavigationDrawerFragment extends Fragment {


    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    public static final String PREF_FILE = "testPref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private boolean mUserLearnedDrawer;
    private boolean mFromInstanceState;
    private View mContainerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        ListView list = (ListView) layout.findViewById(R.id.drawerListView);
        NavigationDrawerAdapter adapter = new NavigationDrawerAdapter(getActivity(), getData());
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                FragmentManager fragmentManager = getFragmentManager();


                switch (position) {
                    case 0:
                        fragmentManager.beginTransaction()
                                .replace(R.id.mainContainer, new Planner())
                                .commit();
                        break;
                    case 1:
                        fragmentManager.beginTransaction()
                                .replace(R.id.mainContainer, new CheckListFragment())
                                .commit();
                        break;
                    case 2:
                        Intent intent = new Intent(getActivity(),MapsActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        fragmentManager.beginTransaction()
                                .replace(R.id.mainContainer, new ExpensesFragment())
                                .commit();
                    break;
                    case  4 :
                        fragmentManager.beginTransaction()
                                .replace(R.id.mainContainer, new RecyclerFragment())
                                .commit();
                        break;

                }


                mDrawerLayout.closeDrawers();
            }
        });


        return layout;
    }


    //This class has the objects used in the navigation drawer
    public static class DrawerData {

        int iconId;
        String title;
    }


    //This adds data to the list that is to be populated using DrawerData class objects
    public static List<DrawerData> getData(){

        List<DrawerData> data = new ArrayList<>();
        int[] icons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher };
        String[] titles = {"Planner", "Check List", "Geo Caching", "Expenses","Story"};
        for(int i=0;i<titles.length && i<icons.length ;i++)
        {
            DrawerData current = new DrawerData();
            current.iconId = icons[i%icons.length];
            current.title = titles[i%titles.length];
            data.add(current);
        }

        return data;
    }



















    /*/////// Dont worry about all this ////////*/




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState != null) {
            mFromInstanceState = true;
        }

    }

    public void setup(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        mContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }


        };

        if (!mUserLearnedDrawer && !mFromInstanceState) {
            mDrawerLayout.openDrawer(mContainerView);
        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }



    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(preferenceName, preferenceValue);
        edit.apply();
    }


    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }






    /*/////// Dont worry about all this ////////*/






}

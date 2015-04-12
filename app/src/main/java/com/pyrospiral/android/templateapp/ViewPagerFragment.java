package com.pyrospiral.android.templateapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

/**
 * Created by adeshkala on 11/04/15.
 */
public class ViewPagerFragment extends Fragment {









        private ViewPager viewPager;
        private FragmentAdapter adapter;

        private Toolbar toolbar;

        int doing=0;

        public ViewPagerFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            doing=1;
            View rootView = inflater.inflate(R.layout.view_pager_fragment, container, false);

            viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);

            adapter = new FragmentAdapter(getChildFragmentManager());
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(1);

            // Bind the tabs to the ViewPager
         //   PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);

           // tabs.setViewPager(viewPager);

         //   ((ActionBarActivity) getActivity()).getSupportActionBar().setTitle("TimeTable");

            return rootView;
        }


    }







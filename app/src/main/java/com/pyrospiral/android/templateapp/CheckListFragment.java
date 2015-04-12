package com.pyrospiral.android.templateapp;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
//import com.getbase.floatingactionbutton.FloatingActionButton;

/**
 * Created by Rahul on 4/11/2015.
 */
public class CheckListFragment extends Fragment {

    private RecyclerView mrecyclerView;
    private Check_list_Adapter mAdapter;
    private List<String> data;
    String items[]=new String[100];

    public CheckListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        final DBAdapterE db=new DBAdapterE(getActivity());

        db.open();
        int k=0;

        Cursor c = db.getAllItems();

        if (c.moveToFirst()) {
            do {

                int index1=c.getColumnIndex(DBAdapterE.ITEMS);
                items[k]=c.getString(index1);
                k++;





            }while(c.moveToNext());
        }



        db.close();



        data = new ArrayList<>();

        for(int i=0;i<items.length;i++)
        {
            if((items[i]==null))
            continue;

            String current = items[i%items.length];
            data.add(current);
        }
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.check_list, container, false);

        //setting recycler view
        mrecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        mrecyclerView.setHasFixedSize(true);
        mAdapter = new Check_list_Adapter(getActivity(),data);
        mrecyclerView.setAdapter(mAdapter);

        //Set out layout Manager
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.supportsPredictiveItemAnimations();
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mrecyclerView.setLayoutManager(llm);


        // applyToRecycler();


        return rootView;
    }

}

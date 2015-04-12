package com.pyrospiral.android.templateapp;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pyrospiral.android.templateapp.Animation.Slider;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {


    private RecyclerView mrecyclerView;
    private RecyclerViewAdapter mAdapter;
    private List<RecyclerData> data;
  private Cursor cursor;
//    private int columnIndex;

    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        data = new ArrayList<>();

        //ENTER DATA INTO RECYCLER OBJECTS HERE

       /* // Set up an array of the Thumbnail Image ID column we want
        String[] projection = {MediaStore.Images.Thumbnails.IMAGE_ID};
        // Create the cursor pointing to the SDCard
        cursor = getActivity().getContentResolver().query( MediaStore.Images.Thumbnails.INTERNAL_CONTENT_URI,
                projection, // Which columns to return
                null,       // Return all rows
                null,
                null);
        // Get the column index of the Thumbnails Image ID
        int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails.IMAGE_ID );
        Log.e("sdfsdf", "" + columnIndex);
        int imageID = cursor.getInt(columnIndex);
        ImageDatabase dbbi=new ImageDatabase(getActivity());
        dbbi.open();
        dbbi.insertContact(imageID);
        dbbi.close();

*/
        for(int i = 0;i<5;i++){

            RecyclerData newData = new RecyclerData();

            newData.data1 = "DATA 1";
            data.add(newData);

        }


        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        //setting recycler view
        mrecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        mrecyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewAdapter(getActivity(),data);
        mrecyclerView.setAdapter(mAdapter);

        //Staggered Grid Layout Manager
        mrecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mrecyclerView.setItemAnimator(new DefaultItemAnimator());

       // applyToRecycler();


        Button story = (Button) rootView.findViewById(R.id.story);

        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Slider.class);
                startActivity(intent);
            }
        });

        return rootView;
    }




    //CLASS FOR RECYCLER OBJECTS
    public class RecyclerData {
        String data1;
    }
}

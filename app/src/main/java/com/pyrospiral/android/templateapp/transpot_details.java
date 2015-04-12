package com.pyrospiral.android.templateapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class transpot_details extends Fragment {


    public transpot_details() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_transpot_details, container, false);

        Button done = (Button) rootView.findViewById(R.id.done);
        Button skip = (Button) rootView.findViewById(R.id.skip);

        final FragmentManager fragmentManager = getFragmentManager();


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Your details saved successfully!!", Toast.LENGTH_SHORT).show();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Your details saved successfully!!" , Toast.LENGTH_SHORT).show();
            }
        });



        return rootView;
    }


}

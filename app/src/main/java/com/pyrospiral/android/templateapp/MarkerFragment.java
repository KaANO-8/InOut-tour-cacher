package com.pyrospiral.android.templateapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;


public class MarkerFragment extends Fragment {


    double lat;
    double lon;

    public MarkerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_marker, container, false);



        Button save = (Button) v.findViewById(R.id.save_ass);
        Button discard = (Button) v.findViewById(R.id.discard_ass);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView subject = (TextView) v.findViewById(R.id.subject_ass);
                TextView desc = (TextView)v.findViewById(R.id.description_ass);

                String sub = subject.getText().toString();
                String descrip = desc.getText().toString();


                LatLng latLng = new LatLng(lat, lon);

              //  getActivity().addMark(latLng,sub, descrip);

            }
        });

        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(getTargetFragment())
                        .commit();
            }
        });


        return v;
    }


}

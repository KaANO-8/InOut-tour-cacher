package com.pyrospiral.android.templateapp;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Planner extends Fragment {


    public Planner() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView;
        rootView = inflater.inflate(R.layout.fragment_planner, container, false);

        Bitmap large = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
        ImageBlur blur = new ImageBlur(large,25);
        Bitmap la = blur.fastblur();

        FrameLayout l = (FrameLayout) rootView.findViewById(R.id.layout);
        l.setBackground(new BitmapDrawable(getActivity().getResources(), la));


        ImageButton plan = (ImageButton) rootView.findViewById(R.id.button);

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),FormActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }


}

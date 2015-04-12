package com.pyrospiral.android.templateapp.Animation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pyrospiral.android.templateapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimationFragment extends Fragment {

    private static final String PACKAGE = "com.pyrospiral.android.templateapp";


    public AnimationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_animation, container, false);


        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.imageView2);
        imageView2.setOnClickListener(thumbnailClickListener);
        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.imageView3);
        imageView3.setOnClickListener(thumbnailClickListener);
        ImageView imageView4 = (ImageView) rootView.findViewById(R.id.imageView4);
        imageView4.setOnClickListener(thumbnailClickListener);


        return rootView;
    }



    private View.OnClickListener thumbnailClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // Interesting data to pass across are the thumbnail size/location, the
            // resourceId of the source bitmap, the picture description, and the
            // orientation (to avoid returning back to an obsolete configuration if
            // the device rotates again in the meantime)
            int[] screenLocation = new int[2];
            v.getLocationOnScreen(screenLocation);
            Intent intent = new Intent(getActivity(),AnimationSubActivity.class);
            int orientation = getResources().getConfiguration().orientation;
            intent.
                    putExtra(PACKAGE + ".orientation", orientation).
                    putExtra(PACKAGE + ".left", screenLocation[0]).
                    putExtra(PACKAGE + ".top", screenLocation[1]).
                    putExtra(PACKAGE + ".width", v.getWidth()).
                    putExtra(PACKAGE + ".height", v.getHeight());
            startActivity(intent);

            // Override transitions: we don't want the normal window animation in addition
            // to our custom one
            getActivity().overridePendingTransition(0, 0);
        }
    };




}

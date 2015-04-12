package com.pyrospiral.android.templateapp;

import android.view.View;

import com.daimajia.slider.library.Animations.BaseAnimationInterface;

/**
 * Created by kaano8 on 12/4/15.
 */
public class ChildAnimationExample implements BaseAnimationInterface {

    @Override
    public void onPrepareCurrentItemLeaveScreen(View view) {
        View descriptionLayout = view.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(descriptionLayout!=null){
            view.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onPrepareNextItemShowInScreen(View view) {

        View descriptionLayout = view.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(descriptionLayout!=null){
            view.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onCurrentItemDisappear(View view) {

    }

    @Override
    public void onNextItemAppear(View view) {

        View descriptionLayout = view.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(descriptionLayout!=null){
            view.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.VISIBLE);
//            ValueAnimator animator = ObjectAnimator.ofFloat(
//                    descriptionLayout, "y", -descriptionLayout.getHeight(),
//                    0).setDuration(500);
//            animator.start();
//            new BounceInAnimator().animate(descriptionLayout);

        }
    }
}

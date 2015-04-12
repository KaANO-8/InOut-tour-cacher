package com.pyrospiral.android.templateapp;


import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;
import com.pyrospiral.android.templateapp.DBAdapter;
import com.pyrospiral.android.templateapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpensesFragment extends Fragment {

    int value = 600;
    TextView percent;
    PieGraph pg;
    PieSlice foodSlice;
    PieSlice entertainSlice;
    PieSlice otherSlice;
    Spinner spinner;


    public ExpensesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_expenses, container, false);

        final DBAdapter db=new DBAdapter(getActivity());





        final Resources resources = getResources();
        percent = (TextView) v.findViewById(R.id.percentage);

        percent.setText(value + "%");


        spinner = (Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.budget_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        pg = (PieGraph) v.findViewById(R.id.piegraph);

        //Slice for total budget
        PieSlice completeSlice = new PieSlice();
        completeSlice.setColor(resources.getColor(R.color.primaryColorDark));
        completeSlice.setValue(100);
        completeSlice.setGoalValue(100);
        pg.addSlice(completeSlice);


        //Slice for food
        foodSlice = new PieSlice();
        foodSlice.setColor(resources.getColor(R.color.highAttendance));
        foodSlice.setValue((float) 0.00000001);
        foodSlice.setGoalValue(value);
        pg.addSlice(foodSlice);


        //Slice for food
        entertainSlice = new PieSlice();
        entertainSlice.setColor(resources.getColor(R.color.attendance20));
        entertainSlice.setValue((float) 0.00000001);
        entertainSlice.setGoalValue(20);
        pg.addSlice(entertainSlice);


        //Slice for food
        otherSlice = new PieSlice();
        otherSlice.setColor(resources.getColor(R.color.attendance70));
        otherSlice.setValue((float) 0.00000001);
        otherSlice.setGoalValue(10);
        pg.addSlice(entertainSlice);


        //For setting inner cicle radius
        pg.setInnerCircleRatio(210);


        //Handles animation
        pg.setDuration(1700);
        pg.setInterpolator(new BounceInterpolator());//default if unspecified is linear; constant speed
        pg.setAnimationListener(getAnimationListener());
        pg.animateToGoalValues();//animation will always overwrite. Pass true to call the onAnimationCancel Listener with onAnimationEnd


        Button amount1 = (Button) v.findViewById(R.id.amount1);
        Button amount2 = (Button) v.findViewById(R.id.amount2);
        Button amount3 = (Button) v.findViewById(R.id.amount3);
        Button amount4 = (Button) v.findViewById(R.id.amount4);





        //BUTTON ACTIONS START HERE





        amount1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valuess;
                value = value-50;//Handles animation
                if(value<0)
                {

                }
                db.open();
               if( spinner.getSelectedItemPosition() == 0)
               {
                  valuess="FOOD";
               }
                else
               if(spinner.getSelectedItemPosition() == 1)
               {
                   valuess="ENTERTAINMENT";
               }
               else
               if(spinner.getSelectedItemPosition() == 2)
               {
                   valuess="OTHERS";
               }
               else
               if(spinner.getSelectedItemPosition() == 3)
               {
                   valuess="MARS";
               }
               else
               if(spinner.getSelectedItemPosition() == 4)
               {
                   valuess="JUPITER";
               }
                else
               {
                   valuess="NOTHING YET";
               }
                db.insertContact(valuess,50);



                db.close();
                checker();
                Log.e("Budget button 1 ", " clicked");
                percent.setText(value + "%");
                pg.setDuration(1700);
                pg.setInterpolator(new BounceInterpolator());//default if unspecified is linear; constant speed
                pg.setAnimationListener(getAnimationListener());
                pg.animateToGoalValues();//animation will always overwrite. Pass true to call the onAnimationCancel Listener with onAnimationEnd
            }
        });

        amount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = value-100;//Handles animation
                String valuess;
               // value = value-50;//Handles animation
                db.open();
                if( spinner.getSelectedItemPosition() == 0)
                {
                    valuess="FOOD";
                }
                else
                if(spinner.getSelectedItemPosition() == 1)
                {
                    valuess="ENTERTAINMENT";
                }
                else
                if(spinner.getSelectedItemPosition() == 2)
                {
                    valuess="OTHERS";
                }
                else
                if(spinner.getSelectedItemPosition() == 3)
                {
                    valuess="MARS";
                }
                else
                if(spinner.getSelectedItemPosition() == 4)
                {
                    valuess="JUPITER";
                }
                else
                {
                    valuess="NOTHING YET";
                }
                db.insertContact(valuess,100);



                db.close();
                checker();
                Log.e("Budget button 1 ", " clicked");
                entertainSlice.setGoalValue(value);
                percent.setText(value + "%");
                pg.setDuration(1700);
                pg.setInterpolator(new BounceInterpolator());//default if unspecified is linear; constant speed
                pg.setAnimationListener(getAnimationListener());
                pg.animateToGoalValues();//animation will always overwrite. Pass true to call the onAnimationCancel Listener with onAnimationEnd
            }
        });
        amount3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = value-500;//Handles animation
                String valuess;
               // value = value-50;//Handles animation
                db.open();
                if( spinner.getSelectedItemPosition() == 0)
                {
                    valuess="FOOD";
                }
                else
                if(spinner.getSelectedItemPosition() == 1)
                {
                    valuess="ENTERTAINMENT";
                }
                else
                if(spinner.getSelectedItemPosition() == 2)
                {
                    valuess="OTHERS";
                }
                else
                if(spinner.getSelectedItemPosition() == 3)
                {
                    valuess="MARS";
                }
                else
                if(spinner.getSelectedItemPosition() == 4)
                {
                    valuess="JUPITER";
                }
                else
                {
                    valuess="NOTHING YET";
                }
                db.insertContact(valuess,500);



                db.close();
                checker();
                Log.e("Budget button 1 ", " clicked");
                otherSlice.setGoalValue(value);
                percent.setText(value + "%");
                pg.setDuration(1700);
                pg.setInterpolator(new BounceInterpolator());//default if unspecified is linear; constant speed
                pg.setAnimationListener(getAnimationListener());
                pg.animateToGoalValues();//animation will always overwrite. Pass true to call the onAnimationCancel Listener with onAnimationEnd
            }
        });
        amount4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = value-1000;//Handles animation
                String valuess;
                //value = value-50;//Handles animation
                db.open();
                if( spinner.getSelectedItemPosition() == 0)
                {
                    valuess="FOOD";
                }
                else
                if(spinner.getSelectedItemPosition() == 1)
                {
                    valuess="ENTERTAINMENT";
                }
                else
                if(spinner.getSelectedItemPosition() == 2)
                {
                    valuess="OTHERS";
                }
                else
                if(spinner.getSelectedItemPosition() == 3)
                {
                    valuess="MARS";
                }
                else
                if(spinner.getSelectedItemPosition() == 4)
                {
                    valuess="JUPITER";
                }
                else
                {
                    valuess="NOTHING YET";
                }
                db.insertContact(valuess,1000);



                db.close();
                Log.e("Budget button 1 ", " clicked");
                checker();
                foodSlice.setGoalValue(value);
                percent.setText(value + "%");
                pg.setDuration(1700);
                pg.setInterpolator(new BounceInterpolator());//default if unspecified is linear; constant speed
                pg.setAnimationListener(getAnimationListener());
                pg.animateToGoalValues();//animation will always overwrite. Pass true to call the onAnimationCancel Listener with onAnimationEnd
            }
        });


        //BUTTON ACTIONS END HERE








        return v;

    }



    public void checker()
    {
        if(spinner.getSelectedItemPosition() == 0)
        {
            foodSlice.setGoalValue(value);
        }
        else if(spinner.getSelectedItemPosition() == 1)
        {
            entertainSlice.setGoalValue(value);
        }
        else if(spinner.getSelectedItemPosition() == 2)
        {
            otherSlice.setGoalValue(value);
        }
        else if(spinner.getSelectedItemPosition() == 3)
        {
            Log.e("Expenses frag","Nothing here yet");
        }
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public Animator.AnimatorListener getAnimationListener() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1)
            return new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.e("piefrag", "anim end");
                }

                @Override
                public void onAnimationCancel(Animator animation) {//you might want to call slice.setvalue(slice.getGoalValue)
                    Log.e("piefrag", "anim cancel");
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    Log.e("piefrag", "anim restart");
                }
            };
        else return null;

    }

}

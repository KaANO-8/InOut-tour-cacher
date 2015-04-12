package com.pyrospiral.android.templateapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rahul on 4/11/2015.
 */
public class Check_list_Adapter extends RecyclerView.Adapter<Check_list_Adapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<String> data = Collections.emptyList();


    public Check_list_Adapter(Context context, List<String> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.check_list_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String current = data.get(position);
        holder.t.setText(current);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView t;
        CheckBox c1;

        public MyViewHolder(View itemView) {
            super(itemView);

            c1 =  (CheckBox) itemView.findViewById(R.id.checkbox);
            t = (TextView) itemView.findViewById(R.id.title);
        }
    }
}

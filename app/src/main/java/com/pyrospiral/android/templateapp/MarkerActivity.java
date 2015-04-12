package com.pyrospiral.android.templateapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MarkerActivity extends ActionBarActivity {


     double lat;
    double lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker);

        Intent intent = getIntent();
        intent.getDoubleExtra("lat",lat);
        intent.getDoubleExtra("lon",lon);



        Button save = (Button) findViewById(R.id.save_ass);
        Button discard = (Button) findViewById(R.id.discard_ass);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView subject = (TextView) findViewById(R.id.subject_ass);
                TextView desc = (TextView) findViewById(R.id.description_ass);

                String sub = subject.getText().toString();
                String descrip = desc.getText().toString();



                DBAdapterS db=new DBAdapterS(MarkerActivity.this);
                db.open();
                Log.d("","Yes"+lat);
                db.insertContact(sub,descrip,21.16+ Math.random()/1000,72.785+Math.random()/1000);
                db.close();

                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();

            }
        });

        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

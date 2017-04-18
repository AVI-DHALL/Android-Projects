package com.example.abbu.dateproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar c = Calendar.getInstance();
        TextView textview=(TextView)findViewById(R.id.tv);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        System.out.println("Current time => " + c.getTime());
        textview.setText(formattedDate);
        Button next=(Button)findViewById(R.id.next);
        Button previous=(Button)findViewById(R.id.prev);

        Button current=(Button)findViewById(R.id.current);

        current.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                TextView textview=(TextView)findViewById(R.id.tv);
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c.getTime());

                Log.v("PREVIOUS DATE : ", formattedDate);
                textview.setText(formattedDate);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                TextView textview=(TextView)findViewById(R.id.tv);
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                c.add(Calendar.DATE, -1);
                String formattedDate = df.format(c.getTime());

                Log.v("PREVIOUS DATE : ", formattedDate);
                textview.setText(formattedDate);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                TextView textview=(TextView)findViewById(R.id.tv);
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                c.add(Calendar.DATE, 1);
                String formattedDate = df.format(c.getTime());

                Log.v("NEXT DATE : ", formattedDate);
                textview.setText(formattedDate);
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

package com.example.abbu.spinner_image;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends ActionBarActivity {

    private String[] Objects;

    private TypedArray images;

    private ImageView itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Casting
        Objects = getResources().getStringArray(R.array.object_array);
        images = getResources().obtainTypedArray(R.array.object_image);
        TextView spinnerHeader = (TextView)findViewById(R.id.textView);
        itemImage = (ImageView)findViewById(R.id.imageView);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                getApplicationContext(),android.R.layout.simple_spinner_item, Objects);

        spinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
           {
                itemImage.setImageResource(images.getResourceId(
                        spinner.getSelectedItemPosition(), -1));
           }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


}
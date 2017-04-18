package com.example.abbu.button_color_horizontal;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.buttonPatina);
        btn2 = (Button) findViewById(R.id.buttonGamboge);
        btn3 = (Button) findViewById(R.id.buttonAmber);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
                rl.setBackgroundColor(Color.parseColor("#407A52"));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
                rl.setBackgroundColor(Color.parseColor("#FFB61E"));
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
                rl.setBackgroundColor(Color.parseColor("#CA6924"));
            }
        });


    }
}

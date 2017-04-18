package com.example.abbu.explicit_intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Abbu on 4/15/2017.
 */

public class ReceiverActivity extends MainActivity{
    TextView tv_receive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiver_activity);

        // Casting
        tv_receive = (TextView) findViewById (R.id.textViewreceive);

        Intent in = getIntent();
        String string = in.getStringExtra("message");
        tv_receive.setText(string);
    }
}

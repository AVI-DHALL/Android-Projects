package com.example.abbu.explicit_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextfield;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Casting
        editTextfield = (EditText) findViewById(R.id.editText_field);
        btnSend = (Button) findViewById(R.id.button_send);
        intent();
    }

    public void intent(){
        btnSend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String value = editTextfield.getText().toString();
                        Intent i = new Intent(MainActivity.this, ReceiverActivity.class);
                        i.putExtra("message", value);
                        startActivity(i);
                    }
                }
        );
    }

}

package com.example.abbu.login_logout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editTextUser);
        password = (EditText) findViewById(R.id.editTextPass);
        login = (Button) findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")){
                    Intent i = new Intent(MainActivity.this.getApplicationContext(),
                            Logout.class);
                    i.putExtra("message", value);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Details",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

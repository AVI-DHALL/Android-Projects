package com.example.abbu.truthdare;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class TDActivity extends ActionBarActivity{

    ImageView pen;
    Button b_go;
    Random r;
    int angle;

    boolean restart = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td);

        r = new Random();

        pen = (ImageView) findViewById(R.id.pen);

        b_go = (Button) findViewById(R.id.b_go);

        b_go.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(restart){

                            angle = angle%360;
                            RotateAnimation rotate = new RotateAnimation(angle,360,
                                    RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                            rotate.setFillAfter(true);
                            rotate.setDuration(1000);
                            rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                            pen.startAnimation(rotate);

                            b_go.setText("GO");
                            restart = false;


                        }
                        else{


                            angle = r.nextInt(3600)+360;
                            RotateAnimation rotate = new RotateAnimation(0,angle,
                                    RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                            rotate.setFillAfter(true); //boolean: true if the animation should apply its transformation after it ends
                            rotate.setDuration(3600);
                            //An interpolator defines the rate of change of an animation. This allows
                            // the basic animation effects (alpha, scale, translate, rotate) to be accelerated, decelerated, repeated, etc.
                            // AccelerateDecelerateInterpolator -> An interpolator where the rate of change starts and ends slowly but accelerates through the middle.
                            rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                            pen.startAnimation(rotate);


                            b_go.setText("RESET");


                            Context context = getApplicationContext();
                            int remainder=angle%360;
                            CharSequence text;
                            if (remainder>=0 && remainder<=90){
                                text="Player 1";
                            }
                            else if (remainder>90 && remainder<=180){
                                text="Player 2";
                            }
                            else if (remainder>180 && remainder<=270){
                                text="Player 3";
                            }
                            else {
                                text="Player 4";
                            }
                            //display in long period of time
                            int duration = Toast.LENGTH_SHORT;
                            final Toast toast = Toast.makeText(context, text, duration);
                            new Timer().schedule(new TimerTask(){
                                @Override
                                public void run(){
                                    toast.show();}
                            },3600);

                            restart = true;

                        }

                    }
                });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_td, menu);
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

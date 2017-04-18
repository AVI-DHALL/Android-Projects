package com.example.abbu.radio_power;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TypedArray images;
    private ImageView itemImage;
    RadioButton rch = null;
    RadioButton rco = null;
    RadioButton rcs = null;
    RadioButton rel = null;
    RadioGroup rg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = getResources().obtainTypedArray(R.array.radiobtn_image);
        itemImage = (ImageView) findViewById(R.id.imageView);
        rch = (RadioButton) findViewById(R.id.radioButtonCH);
        rco = (RadioButton) findViewById(R.id.radioButtonCO);
        rcs = (RadioButton) findViewById(R.id.radioButtonCS);
        rel = (RadioButton) findViewById(R.id.radioButtonEL);
        rg = (RadioGroup) findViewById(R.id.choices);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == rch.getId()) {
                    itemImage.setImageResource(R.drawable.pic2);
                    Toast.makeText(MainActivity.this, "Dr. Neelu Dhir",
                            Toast.LENGTH_SHORT).show();
                }else if (checkedId == rco.getId()) {
                    itemImage.setImageResource(R.drawable.pic4);
                    Toast.makeText(MainActivity.this, "Ms. Sangeeta Relan",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == rcs.getId()) {
                    itemImage.setImageResource(R.drawable.pic1);
                    Toast.makeText(MainActivity.this, "Dr. Vibha Gaur",
                            Toast.LENGTH_SHORT).show();
                } else {
                    itemImage.setImageResource(R.drawable.pic3);
                    Toast.makeText(MainActivity.this, "Dr. Ravneet Kaur",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
}


}

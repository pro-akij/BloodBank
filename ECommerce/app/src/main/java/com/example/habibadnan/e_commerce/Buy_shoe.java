package com.example.habibadnan.e_commerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Buy_shoe extends AppCompatActivity implements View.OnClickListener {
    private ImageView shoe1, shoe2, shoe3, shoe4, shoe5, shoe6;
    private int[] image={R.drawable.shoe1, R.drawable.shoe2, R.drawable.shoe3,
            R.drawable.shoe4, R.drawable.shoe5, R.drawable.shoe6};
    private ViewFlipper shoe_view_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_shoe);
        For_Find();
        for (int i=0;i<image.length;i++){
            Flipper(image[i]);
        }
        shoe1.setOnClickListener(this);
        shoe2.setOnClickListener(this);
        shoe3.setOnClickListener(this);
        shoe4.setOnClickListener(this);
        shoe5.setOnClickListener(this);
        shoe6.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    private void For_Find(){
        shoe1= findViewById(R.id.image_shoe1);
        shoe2= findViewById(R.id.image_shoe2);
        shoe3= findViewById(R.id.image_shoe3);
        shoe4= findViewById(R.id.image_shoe4);
        shoe5= findViewById(R.id.image_shoe5);
        shoe6= findViewById(R.id.image_shoe6);
        shoe_view_flipper= findViewById(R.id.shoe_view_flipper);
    }
    private void Flipper(int i){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(i);
        shoe_view_flipper.addView(imageView);
        shoe_view_flipper.setFlipInterval(4000);
        shoe_view_flipper.setAutoStart(true);
        shoe_view_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        shoe_view_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id== R.id.image_shoe1){

        } else if (id== R.id.image_shoe2){

        } else if (id== R.id.image_shoe3){

        } else if (id== R.id.image_shoe4){

        } else if (id== R.id.image_shoe5){

        } else {

        }
    }
}
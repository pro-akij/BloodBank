package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Foods extends AppCompatActivity implements View.OnClickListener {
    private ImageView potato, egg, oats, tea, orrange, berries;
    private ViewFlipper foods_view_flipper;
    private int[] image={R.drawable.potato, R.drawable.egg, R.drawable.oats,
            R.drawable.tea, R.drawable.orangs, R.drawable.berries};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        For_Find();
        for (int i=0;i<image.length;i++){
            Flipper(image[i]);
        }

        potato.setOnClickListener(this);
        egg.setOnClickListener(this);
        oats.setOnClickListener(this);
        tea.setOnClickListener(this);
        orrange.setOnClickListener(this);
        berries.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    private void For_Find (){
        potato= findViewById(R.id.image_potato);
        egg= findViewById(R.id.image_egg);
        oats= findViewById(R.id.image_oats);
        tea= findViewById(R.id.image_tea);
        orrange= findViewById(R.id.image_orangs);
        berries= findViewById(R.id.image_berries);
        foods_view_flipper= findViewById(R.id.foods_view_flipper);
    }

    private void Flipper(int i){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(i);
        foods_view_flipper.addView(imageView);
        foods_view_flipper.setFlipInterval(4000);
        foods_view_flipper.setAutoStart(true);
        foods_view_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        foods_view_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id== R.id.image_potato) {
            Intent intent= new Intent(this,Potato.class);
            startActivity(intent);
        } else if (id== R.id.image_egg){
            Intent intent= new Intent(this,Egg.class);
            startActivity(intent);
        } else if (id== R.id.image_oats){
            Intent intent= new Intent(this,Oats.class);
            startActivity(intent);
        } else if (id== R.id.image_tea){
            Intent intent= new Intent(this,Tea.class);
            startActivity(intent);
        } else if (id== R.id.image_orangs){
            Intent intent= new Intent(this,Orange.class);
            startActivity(intent);
        } else {
            Intent intent= new Intent(this,Berries.class);
            startActivity(intent);
        }
    }
}

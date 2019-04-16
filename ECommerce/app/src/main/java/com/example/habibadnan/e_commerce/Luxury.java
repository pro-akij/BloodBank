package com.example.habibadnan.e_commerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Luxury extends AppCompatActivity implements View.OnClickListener {
    private ImageView ring, ring2, necklace, necklace2, watch, foot_ornaments;
    private int[] image={R.drawable.ring2, R.drawable.necklace, R.drawable.foot_ornament,
            R.drawable.watch, R.drawable.ring, R.drawable.necklace2};
    private ViewFlipper ornaments_view_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luxury);
        For_Find();
        for (int i=0;i<image.length;i++){
            Flipper(image[i]);
        }
        ring2.setOnClickListener(this);
        necklace.setOnClickListener(this);
        foot_ornaments.setOnClickListener(this);
        watch.setOnClickListener(this);
        ring.setOnClickListener(this);
        necklace2.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    private void For_Find(){
        ring2= findViewById(R.id.image_ring2);
        necklace= findViewById(R.id.image_necklace);
        foot_ornaments= findViewById(R.id.image_foot_ornament);
        watch= findViewById(R.id.image_watch);
        ring= findViewById(R.id.image_ring);
        necklace2= findViewById(R.id.image_necklace2);
        ornaments_view_flipper= findViewById(R.id.ornaments_view_flipper);
    }
    private void Flipper(int i){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(i);
        ornaments_view_flipper.addView(imageView);
        ornaments_view_flipper.setFlipInterval(4000);
        ornaments_view_flipper.setAutoStart(true);
        ornaments_view_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        ornaments_view_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id== R.id.image_ring2){

        } else if (id== R.id.image_necklace){

        } else if (id== R.id.image_foot_ornament){

        } else if (id== R.id.image_watch){

        } else if (id== R.id.image_ring){

        } else {

        }
    }
}

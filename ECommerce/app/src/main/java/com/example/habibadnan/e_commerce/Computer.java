package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Computer extends AppCompatActivity implements View.OnClickListener {
    private ImageButton apple, microsoft, dell, hp, lenovo, acer;
    private ViewFlipper computer_viewFlipper;
    private int[] image= {R.drawable.apple,R.drawable.microsoft,R.drawable.dell,
            R.drawable.hp, R.drawable.lenovo, R.drawable.acer};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        For_Find();
        apple.setOnClickListener(this);
        microsoft.setOnClickListener(this);
        dell.setOnClickListener(this);
        hp.setOnClickListener(this);
        lenovo.setOnClickListener(this);
        acer.setOnClickListener(this);
        for (int i=0;i<image.length;i++){
            Flipper(image[i]);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public void For_Find(){
        apple= findViewById(R.id.image_apple);
        microsoft= findViewById(R.id.image_microsoft);
        dell= findViewById(R.id.image_dell);
        hp= findViewById(R.id.image_hp);
        lenovo= findViewById(R.id.image_lenovo);
        acer= findViewById(R.id.image_acer);
        computer_viewFlipper= findViewById(R.id.computer_view_flip);
    }

    private void Flipper(int i) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(i);
        computer_viewFlipper.addView(imageView);
        computer_viewFlipper.setFlipInterval(4000);
        computer_viewFlipper.setAutoStart(true);
        computer_viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        computer_viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id== R.id.image_apple){
            Intent intent= new Intent(this,Apple.class);
            startActivity(intent);
        } else if (id== R.id.image_microsoft){
            Intent intent= new Intent(this,Micrsft.class);
            startActivity(intent);
        } else if (id== R.id.image_dell){
            Intent intent= new Intent(this,Dell.class);
            startActivity(intent);
        } else if (id== R.id.image_hp){
            Intent intent= new Intent(this,HP.class);
            startActivity(intent);
        } else if (id== R.id.image_lenovo){
            Intent intent= new Intent(this,Lenovo.class);
            startActivity(intent);
        } else {
            Intent intent= new Intent(this,Acer.class);
            startActivity(intent);
        }
    }
}

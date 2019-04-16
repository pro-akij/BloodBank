package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Mobile extends AppCompatActivity implements View.OnClickListener {
    private ImageView iphone, samesung, nokia, oppo, xiaomi, huwai;
    private int[] image={R.drawable.iphone, R.drawable.samesung, R.drawable.nokia,
            R.drawable.oppo, R.drawable.xiaomi, R.drawable.huwai};
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);
        For_Find();

        for (int i=0;i<image.length;i++){
            Flipper(image[i]);
        }
        iphone.setOnClickListener(this);
        samesung.setOnClickListener(this);
        nokia.setOnClickListener(this);
        oppo.setOnClickListener(this);
        xiaomi.setOnClickListener(this);
        huwai.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    private void For_Find(){
        iphone= findViewById(R.id.image_iphone);
        samesung= findViewById(R.id.image_samesung);
        nokia= findViewById(R.id.image_nokia);
        oppo= findViewById(R.id.image_oppo);
        xiaomi= findViewById(R.id.image_xiaomi);
        huwai= findViewById(R.id.image_huwai);
        viewFlipper= findViewById(R.id.mobile_view_flipper);
    }

    private void Flipper(int i){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(i);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id== R.id.image_iphone){
            Intent intent= new Intent(this,Iphone.class);
            startActivity(intent);
        } else if (id== R.id.image_samesung){
            Intent intent= new Intent(this,Samesung.class);
            startActivity(intent);
        } else if (id== R.id.image_nokia){
            Intent intent= new Intent(this,Nokia.class);
            startActivity(intent);
        } else if (id== R.id.image_oppo){
            Intent intent= new Intent(this,Oppo.class);
            startActivity(intent);
        } else if (id== R.id.image_xiaomi){
            Intent intent= new Intent(this,Xiaomi.class);
            startActivity(intent);
        } else {
            Intent intent= new Intent(this,Huwai.class);
            startActivity(intent);
        }
    }
}

package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Cloth extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7;
    ViewFlipper cloth_viewFlipper;
    private int[] cloth_image= {R.drawable.tshirt1, R.drawable.tshirt2, R.drawable.tshirt3, R.drawable.tshirt4,
            R.drawable.tshirt5, R.drawable.tshirt6, R.drawable.tshirt8, R.drawable.tshirt9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth);
        cloth_viewFlipper= findViewById(R.id.cloth_view_flip);
        for (int i=0;i< cloth_image.length;i++){
            Flipper(cloth_image[i]);
        }
        for_Find();
        imageView.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    private void Flipper(int i){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(i);
        cloth_viewFlipper.addView(imageView);
        cloth_viewFlipper.setFlipInterval(4000);
        cloth_viewFlipper.setAutoStart(true);
        cloth_viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        cloth_viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void for_Find(){
        imageView= findViewById(R.id.image_View1);
        imageView1= findViewById(R.id.image_View2);
        imageView2= findViewById(R.id.image_View3);
        imageView3= findViewById(R.id.image_View4);
        imageView4= findViewById(R.id.image_View5);
        imageView5= findViewById(R.id.image_View6);
        imageView6= findViewById(R.id.image_View7);
        imageView7= findViewById(R.id.image_View8);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id==R.id.image_View1){
            Intent intent= new Intent(Cloth.this,Cloth_View_one.class);
            startActivity(intent);
            //Toast.makeText(Cloth.this,"i am gone product details in view one",Toast.LENGTH_LONG).show();
        }else if (id==R.id.image_View2){
            Intent intent= new Intent(Cloth.this,Cloth_View_two.class);
            startActivity(intent);
            //Toast.makeText(Cloth.this,"i am gone product details in view two",Toast.LENGTH_LONG).show();
        }else if (id==R.id.image_View3){
            Intent intent= new Intent(Cloth.this,Cloth_View_three.class);
            startActivity(intent);
            //Toast.makeText(Cloth.this,"i am gone product details in view three",Toast.LENGTH_LONG).show();
        }else if (id==R.id.image_View4){
            Intent intent= new Intent(Cloth.this,Cloth_View_four.class);
            startActivity(intent);
            //Toast.makeText(Cloth.this,"i am gone product details in view four",Toast.LENGTH_LONG).show();
        }else if (id==R.id.image_View5){
            Intent intent= new Intent(Cloth.this,Cloth_View_five.class);
            startActivity(intent);
            //Toast.makeText(Cloth.this,"i am gone product details in view five",Toast.LENGTH_LONG).show();
        }else if (id==R.id.image_View6){
            Intent intent= new Intent(Cloth.this,Cloth_View_six.class);
            startActivity(intent);
            //Toast.makeText(Cloth.this,"i am gone product details in view six",Toast.LENGTH_LONG).show();
        }else if (id==R.id.image_View7){
            Intent intent= new Intent(Cloth.this,Cloth_View_seven.class);
            startActivity(intent);
            //Toast.makeText(Cloth.this,"i am gone product details in view seven",Toast.LENGTH_LONG).show();
        }else if (id==R.id.image_View8){
            Intent intent= new Intent(Cloth.this,Cloth_View_eight.class);
            startActivity(intent);
            //Toast.makeText(Cloth.this,"i am gone product details in view eight",Toast.LENGTH_LONG).show();
        }
    }

    /*public void goto_one_view(View view) {
        Intent intent= new Intent(Cloth.this,View_One.class);
        startActivity(intent);
        Toast.makeText(this,"i am gone product details",Toast.LENGTH_LONG).show();
    }*/
}

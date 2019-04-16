package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView byu_Shoe, cloth, computer, electronics, food, homedecore, mobile, luxury;
    private ViewFlipper view_flip;
    int[] image={
            R.drawable.healthcare, R.drawable.food, R.drawable.cloth, R.drawable.homedecore,
            R.drawable.computer, R.drawable.mobile, R.drawable.electronics, R.drawable.luxury
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        computer= findViewById(R.id.computer);
        cloth= findViewById(R.id.cloth);
        byu_Shoe= findViewById(R.id.shoe);
        electronics= findViewById(R.id.electronics);
        food= findViewById(R.id.foods);
        homedecore= findViewById(R.id.homedecore);
        mobile= findViewById(R.id.mobile);
        luxury= findViewById(R.id.luxury);

        byu_Shoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Buy_shoe.class);
                startActivity(intent);
            }
        });
        cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Cloth.class);
                startActivity(intent);
            }
        });
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Computer.class);
                startActivity(intent);
            }
        });
        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Electronics.class);
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Foods.class);
                startActivity(intent);
            }
        });
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Mobile.class);
                startActivity(intent);
            }
        });
        luxury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Luxury.class);
                startActivity(intent);
            }
        });
        homedecore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Home_decore.class);
                startActivity(intent);
            }
        });
        view_flip= findViewById(R.id.view_flip);
        for (int i=0;i<image.length;i++){
            Flipper(image[i]);
        }
    }
    public void Flipper(int i){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(i);
        view_flip.addView(imageView);
        view_flip.setFlipInterval(4000);
        view_flip.setAutoStart(true);
        view_flip.setInAnimation(this, android.R.anim.slide_in_left);
        view_flip.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.cart){

        }
        if (id == R.id.menu_log_in) {
            Intent intent= new Intent(MainActivity.this,Log_in.class);
            startActivity(intent);
            Toast.makeText(this,"yeahh i am here",Toast.LENGTH_LONG).show();
        }else if (id==R.id.menu_register){
            Intent intent= new Intent(MainActivity.this,Register.class);
            startActivity(intent);
            Toast.makeText(this,"yeahh i am here too",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.my_accout) {
            Intent intent= new Intent(MainActivity.this,My_shopping.class);
            startActivity(intent);
            Toast.makeText(this,"yeahh i am in my shopping cart",Toast.LENGTH_LONG).show();
        } else if (id == R.id.my_order) {

        } else if (id == R.id.log_out) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

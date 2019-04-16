package com.example.habib.bloodbank;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.habib.bloodbank.EditActivity.Add_Feed;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button add_Doner;
    private Spinner spinner_Blood;
    private CardView cardView_Ambulance, cardView_Feed, cardView_Request, cardView_Organization;
    private TextView BL_News;
    private FirebaseAuth mAuth;
    //private String reg_Data_Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

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
        //Search_Select_Blood();
        For_CardView();
        For_News();
        add_Doner= findViewById(R.id.add_doner);
        add_Doner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Donear.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()== null){
            Toast.makeText(this,"please registration !",Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, Sign_up.class));
        }
    }

    public void For_CardView(){
        cardView_Ambulance= findViewById(R.id.cardView_Ambulance);
        cardView_Feed= findViewById(R.id.cardView_Feed);
        cardView_Request= findViewById(R.id.cardView_Request);
        cardView_Organization= findViewById(R.id.cardView_Organization);

        cardView_Ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Ambulance.class);
                startActivity(intent);
            }
        });

        cardView_Request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Request.class);
                startActivity(intent);
            }
        });
        cardView_Organization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Organization.class);
                startActivity(intent);
            }
        });
        cardView_Feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Add_Feed.class);
                startActivity(intent);
            }
        });
    }

    public void For_News(){
        BL_News= findViewById(R.id.news);
        BL_News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, News.class);
                startActivity(intent);
            }
        });
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
        //final String reg_Data_Pass= getIntent().getExtras().getString("chek_Register");
        //int regg= Integer.parseInt(getIntent().getExtras().getString("chek_Reg"));

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about_us) {
            Toast.makeText(this,"Comming soon ABOUT US",Toast.LENGTH_LONG).show();
        } else if (id == R.id.menu_share){
            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(intent.EXTRA_SUBJECT,"");
            intent.putExtra(intent.EXTRA_TEXT,"");
            startActivity(intent.createChooser(intent,"share whth"));
        } else if (id == R.id.menu_exit){
            finish();
        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_my_account) {
            Intent intent= new Intent(MainActivity.this,MyAccount.class);
            startActivity(intent);
        } else if (id == R.id.search_your_blood){
            Intent intent= new Intent(MainActivity.this,Donear.class);
            startActivity(intent);
        } else if (id == R.id.nav_add_amb){
            Intent intent= new Intent(this,Ambulance.class);
            startActivity(intent);
        } else if (id == R.id.nav_privacy) {
            Toast.makeText(this,"Comming soon",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_share) {
            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(intent.EXTRA_SUBJECT,"");
            intent.putExtra(intent.EXTRA_TEXT,"");
            startActivity(intent.createChooser(intent,"share whth"));
        } else if (id == R.id.nav_rate_us) {
            AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
            RatingBar ratingBar= new RatingBar(MainActivity.this);
            ratingBar.setMax(5);
            builder.setTitle("Rattingbar");
            builder.setMessage("successfully");
            builder.setView(ratingBar);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.create();
            builder.show();
        } else if (id == R.id.nav_about_me){
            Toast.makeText(this,"adding soon",Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

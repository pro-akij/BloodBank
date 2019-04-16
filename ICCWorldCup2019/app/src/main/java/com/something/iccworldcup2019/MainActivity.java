package com.something.iccworldcup2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView schedule, team, venues, point_table, squads_players, live_score;
    private AdView madView;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Find();
        schedule.setOnClickListener(this);
        team.setOnClickListener(this);
        venues.setOnClickListener(this);
        point_table.setOnClickListener(this);
        squads_players.setOnClickListener(this);
        live_score.setOnClickListener(this);
        madView= findViewById(R.id.adView);

        MobileAds.initialize(this,getString(R.string.APP_ID));
        Banner_Add();
        Interstitial_Add();
    }
    public void Find(){
        schedule= findViewById(R.id.schedule);
        team= findViewById(R.id.team);
        venues= findViewById(R.id.venues);
        point_table= findViewById(R.id.point_table);
        squads_players= findViewById(R.id.squads_players);
        live_score= findViewById(R.id.live_score);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id== R.id.schedule){
            Intent intent= new Intent(this,Schedule.class);
            startActivity(intent);
        } else if (id== R.id.team){
            Intent intent= new Intent(this,Team.class);
            startActivity(intent);
        } else if (id== R.id.venues){
            Intent intent= new Intent(this,Venues.class);
            startActivity(intent);
        } else if (id== R.id.point_table){
            Intent intent= new Intent(this,PointTable.class);
            startActivity(intent);
        } else if (id== R.id.squads_players){
            Intent intent= new Intent(this,Squads.class);
            startActivity(intent);
        } else {
            Intent intent= new Intent(this,LiveScore.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.icc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if (id== R.id.share){
            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(intent.EXTRA_SUBJECT,"");
            intent.putExtra(intent.EXTRA_TEXT,"");
            startActivity(intent.createChooser(intent,"share whth"));
        } else if (id== R.id.exit){
            finish();
        } else if (id== R.id.aboutme){
            final AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setMessage("Developer: AK Studio\ncsehabibadnan454@gmail.com");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.create();
            builder.show();
        }
        return true;
    }

    public void Banner_Add(){
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);
        //madView.setAdSize(AdSize.BANNER);
    }
    public void Interstitial_Add(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.INTERSTITIAL_ID));
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                displayinterstitial();
            }
        });
    }
    public void displayinterstitial(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
        }
    }
}

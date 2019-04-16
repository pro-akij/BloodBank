package com.something.iccworldcup2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.something.iccworldcup2019.Adapter.SquadsAdapter;
import com.something.iccworldcup2019.Team_Activety.Team_AFG;
import com.something.iccworldcup2019.Team_Activety.Team_AU;
import com.something.iccworldcup2019.Team_Activety.Team_BAN;
import com.something.iccworldcup2019.Team_Activety.Team_EN;
import com.something.iccworldcup2019.Team_Activety.Team_IN;
import com.something.iccworldcup2019.Team_Activety.Team_NZ;
import com.something.iccworldcup2019.Team_Activety.Team_PK;
import com.something.iccworldcup2019.Team_Activety.Team_RSA;
import com.something.iccworldcup2019.Team_Activety.Team_SR;
import com.something.iccworldcup2019.Team_Activety.Team_WIN;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Squads extends AppCompatActivity {
    private ListView squads_list;
    private SquadsAdapter squadsAdapter;
    private int frag[]= {R.drawable.en,R.drawable.in,R.drawable.nz,R.drawable.rsa,
            R.drawable.aus,R.drawable.pk,R.drawable.bd,R.drawable.sr,R.drawable.win,R.drawable.af};

    private InterstitialAd mInterstitialAd;
    private AdView adView_sqads;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squads);

        MobileAds.initialize(this,getString(R.string.APP_ID));
        adRequest= new AdRequest.Builder().build();
        adView_sqads= findViewById(R.id.adView_squads);

        squads_list= findViewById(R.id.sqads_recyler);
        final String[] Team=getResources().getStringArray(R.array.COUNTY2);
        squadsAdapter= new SquadsAdapter(this, frag, Team);
        squads_list.setAdapter(squadsAdapter);
        squads_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position== 0){
                    Intent intent= new Intent(Squads.this, Team_EN.class);
                    startActivity(intent);
                } else if (position== 1){
                    Intent intent= new Intent(Squads.this, Team_IN.class);
                    startActivity(intent);
                } else if (position == 2){
                    Intent intent= new Intent(Squads.this, Team_NZ.class);
                    startActivity(intent);
                } else if (position == 3){
                    Intent intent= new Intent(Squads.this, Team_RSA.class);
                    startActivity(intent);
                } else if (position == 4){
                    Intent intent= new Intent(Squads.this, Team_AU.class);
                    startActivity(intent);
                } else if (position == 5){
                    Intent intent= new Intent(Squads.this, Team_PK.class);
                    startActivity(intent);
                } else if (position == 6){
                    Intent intent= new Intent(Squads.this, Team_BAN.class);
                    startActivity(intent);
                } else if (position == 7){
                    Intent intent= new Intent(Squads.this, Team_SR.class);
                    startActivity(intent);
                } else if (position == 8){
                    Intent intent= new Intent(Squads.this, Team_WIN.class);
                    startActivity(intent);
                } else if(position == 9){
                    Intent intent= new Intent(Squads.this, Team_AFG.class);
                    startActivity(intent);
                }
            }
        });
        Banner_Add();
        Interstitial_Add();
    }

    @Override
    public void onBackPressed() {
    }


    public void Banner_Add(){
        adView_sqads.loadAd(adRequest);
        //madView_team.setAdSize(AdSize.BANNER);
    }
    public void Interstitial_Add(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.INTERSTITIAL_ID));
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                display_interstitial();
            }
        });
    }
    public void display_interstitial(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
        }
    }
}

package com.something.iccworldcup2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Venues extends AppCompatActivity {
    private AdView madView_venue;
    private AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venues);


        MobileAds.initialize(this,getString(R.string.APP_ID));
        adRequest= new AdRequest.Builder().build();
        madView_venue= findViewById(R.id.adView_venue);
        madView_venue.loadAd(adRequest);

    }
    @Override
    public void onBackPressed() {
    }
}

package com.something.iccworldcup2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Schedule extends AppCompatActivity {
    private AdView madView_schedule;
    private InterstitialAd mInterstitialAd;
    private AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        MobileAds.initialize(this,getString(R.string.APP_ID));
        adRequest= new AdRequest.Builder().build();
        madView_schedule= findViewById(R.id.adView_schedule);
        Banner_Add();
        Interstitial_Add();
    }
    @Override
    public void onBackPressed() {
    }

    public void Banner_Add(){
        madView_schedule.loadAd(adRequest);
        //madView_schedule.setAdSize(AdSize.BANNER);
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

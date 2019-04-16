package com.something.iccworldcup2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.SquadsAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Team extends AppCompatActivity {
    private ListView list_county_Name;
    private String[] county;
    private int frag[]= {R.drawable.en,R.drawable.in,R.drawable.nz,R.drawable.rsa,
            R.drawable.aus,R.drawable.pk,R.drawable.bd,R.drawable.sr,R.drawable.win,R.drawable.af};

    private AdView madView_team;
    private InterstitialAd mInterstitialAd;
    private AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        list_county_Name= findViewById(R.id.sqads_list);
        county= getResources().getStringArray(R.array.COUNTY);

        SquadsAdapter squadsadapter= new SquadsAdapter(this, frag, county);
        list_county_Name.setAdapter(squadsadapter);


        MobileAds.initialize(this,getString(R.string.APP_ID));
        adRequest= new AdRequest.Builder().build();
        madView_team= findViewById(R.id.adView_team);
        Banner_Add();
        Interstitial_Add();
    }
    @Override
    public void onBackPressed() {
    }

    public void Banner_Add(){
        madView_team.loadAd(adRequest);
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

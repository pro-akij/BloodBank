package com.something.iccworldcup2019.Team_Activety;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_AU extends AppCompatActivity {
    private PlayerAdapter playerAdapter;
    private ListView listView;
    private int[] aus_image= {R.drawable.smith,R.drawable.fince,R.drawable.warner,R.drawable.renshaw
            ,R.drawable.tabiz,R.drawable.khawaja,R.drawable.s_mursh,R.drawable.handscomb,R.drawable.m_mursh
            ,R.drawable.maxwel,R.drawable.dsort,R.drawable.stoin,R.drawable.cummins,R.drawable.nathan,R.drawable.holzewood
            ,R.drawable.richardson,R.drawable.strac,R.drawable.zampa};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__au);
        listView= findViewById(R.id.australia_team);
        String[] name= getResources().getStringArray(R.array.Australia);
        playerAdapter= new PlayerAdapter(this, aus_image, name);
        listView.setAdapter(playerAdapter);
    }

    @Override
    public void onBackPressed() {
    }
}

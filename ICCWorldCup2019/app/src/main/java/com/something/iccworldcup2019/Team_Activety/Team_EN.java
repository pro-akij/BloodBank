package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_EN extends AppCompatActivity {
    private ListView england_team;
    private PlayerAdapter playerAdapter;
    int[] england_image= {
            R.drawable.rot,R.drawable.roy,R.drawable.morgan,R.drawable.malan,R.drawable.helse,
            R.drawable.bristow,R.drawable.billing,R.drawable.butlar,R.drawable.moin,R.drawable.stock,
            R.drawable.wacas,R.drawable.willey,R.drawable.ball,R.drawable.curram,R.drawable.plunkett,
            R.drawable.wood,R.drawable.overton,R.drawable.rasid
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__en);
        england_team= findViewById(R.id.england_team);
        String[] england_name= getResources().getStringArray(R.array.England);
        playerAdapter= new PlayerAdapter(this,england_image, england_name);
        england_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

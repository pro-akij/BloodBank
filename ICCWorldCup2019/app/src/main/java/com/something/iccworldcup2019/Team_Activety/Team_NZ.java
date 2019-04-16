package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_NZ extends AppCompatActivity {
    private ListView newzeland_team;
    private PlayerAdapter playerAdapter;
    int[] newzeland_image= {
            R.drawable.gaptil,R.drawable.tailor,R.drawable.wiliamson,R.drawable.latam,R.drawable.blundell,
            R.drawable.nicholls,R.drawable.degrandhomme,R.drawable.monro,R.drawable.setner,R.drawable.neesham,
            R.drawable.bolt,R.drawable.ferguson,R.drawable.henry,R.drawable.sodhi,R.drawable.soudi
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__nz);
        newzeland_team= findViewById(R.id.new_zeland_team);
        String[] newzeland_name= getResources().getStringArray(R.array.New_Zeland);

        playerAdapter= new PlayerAdapter(this,newzeland_image, newzeland_name);
        newzeland_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

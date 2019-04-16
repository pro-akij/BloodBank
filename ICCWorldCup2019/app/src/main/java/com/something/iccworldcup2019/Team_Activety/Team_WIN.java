package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_WIN extends AppCompatActivity {
    private ListView windies_team;
    private PlayerAdapter playerAdapter;
    int[] windies_image= {
            R.drawable.luis,R.drawable.bravo,R.drawable.hetmyer,R.drawable.powell,R.drawable.hop,
            R.drawable.pooran,R.drawable.ramdin,R.drawable.samuels,R.drawable.brathwaite,R.drawable.holder,
            R.drawable.rasel,R.drawable.nurse,R.drawable.cottrell,R.drawable.thomas,R.drawable.gabril,
            R.drawable.allen,R.drawable.bishoo,R.drawable.paul
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__win);
        String[] windies_name= getResources().getStringArray(R.array.Windies);
        windies_team= findViewById(R.id.windies_team);
        playerAdapter= new PlayerAdapter(this,windies_image, windies_name);
        windies_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

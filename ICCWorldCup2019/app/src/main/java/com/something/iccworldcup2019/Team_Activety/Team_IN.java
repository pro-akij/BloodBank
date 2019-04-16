package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_IN extends AppCompatActivity {
    private ListView india_team;
    private PlayerAdapter playerAdapter;
    int[] india_image= {
            R.drawable.kohile,R.drawable.sorma,R.drawable.dawan,R.drawable.rido,R.drawable.rahol,
            R.drawable.asiwin,R.drawable.jadeja,R.drawable.pandiya,R.drawable.jadeb,R.drawable.doni,
            R.drawable.pant,R.drawable.kartik,R.drawable.bomrah,R.drawable.kumar,R.drawable.sami,
            R.drawable.umesh,R.drawable.chahal,R.drawable.koldep
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__in);
        india_team= findViewById(R.id.india_team);
        String[] india_name= getResources().getStringArray(R.array.India);

        playerAdapter= new PlayerAdapter(this,india_image, india_name);
        india_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

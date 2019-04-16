package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_PK extends AppCompatActivity {
    private ListView pakistan_team;
    private PlayerAdapter playerAdapter;
    int[] pakistan_image= {
            R.drawable.imam,R.drawable.zaman,R.drawable.msood,R.drawable.abid,R.drawable.azam,
            R.drawable.shafiq,R.drawable.rizwan,R.drawable.sarfraz,R.drawable.malek,R.drawable.hafiz,
            R.drawable.fahim,R.drawable.wasim,R.drawable.sadab,R.drawable.amir,R.drawable.hasan,
            R.drawable.abbas,R.drawable.shahin,R.drawable.shinwari
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__pk);
        pakistan_team= findViewById(R.id.pakistan_team);
        String[] pakistan_name= getResources().getStringArray(R.array.Pakistan);

        playerAdapter= new PlayerAdapter(this,pakistan_image, pakistan_name);
        pakistan_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

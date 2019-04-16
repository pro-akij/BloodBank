package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_RSA extends AppCompatActivity {
    private ListView southafrica_team;
    private PlayerAdapter playerAdapter;
    int[] southafrica_image= {
            R.drawable.duplesis,R.drawable.amla,R.drawable.mardram,R.drawable.millar,R.drawable.dussen,
            R.drawable.hendricks,R.drawable.bavuma,R.drawable.decock,R.drawable.klaasen,R.drawable.duminy,
            R.drawable.pretorius,R.drawable.phehlukwayo,R.drawable.styne,R.drawable.ngdi,R.drawable.rabada,
            R.drawable.norteji,R.drawable.tahir,R.drawable.shamsi
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__rs);
        southafrica_team= findViewById(R.id.south_africa_team);
        String[] southafrica_name= getResources().getStringArray(R.array.South_Africa);

        playerAdapter= new PlayerAdapter(this,southafrica_image, southafrica_name);
        southafrica_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

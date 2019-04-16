package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_BAN extends AppCompatActivity {
    private ListView bangladesh_team;
    private PlayerAdapter playerAdapter;
    int[] bangladesh_image= {
            R.drawable.tamim,R.drawable.sarkar,R.drawable.sabbir,R.drawable.imrol,R.drawable.muminul,
            R.drawable.musfiq,R.drawable.mithun,R.drawable.liton,R.drawable.capten,R.drawable.riad,
            R.drawable.meraz,R.drawable.saikut,R.drawable.saif,R.drawable.boss,R.drawable.rubel,
            R.drawable.taskin,R.drawable.mustafizur,R.drawable.shafiul
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__ban);
        bangladesh_team= findViewById(R.id.bangladesh_team);
        String[] bangladesh_name= getResources().getStringArray(R.array.Bangladesh);
        playerAdapter= new PlayerAdapter(this,bangladesh_image, bangladesh_name);
        bangladesh_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_SR extends AppCompatActivity {
    private ListView srilanka_team;
    private PlayerAdapter playerAdapter;
    int[] srilanka_image= {
            R.drawable.tharanga,R.drawable.dicwala,R.drawable.farnando,R.drawable.silva,R.drawable.metheus,
            R.drawable.perara,R.drawable.mendis,R.drawable.chandimal,R.drawable.tparara,R.drawable.udana,
            R.drawable.desilva,R.drawable.anperara,R.drawable.lakmal,R.drawable.lalinga,R.drawable.dananja,
            R.drawable.sandakan,R.drawable.kumara,R.drawable.rajitha
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__sr);
        srilanka_team= findViewById(R.id.srilanka_team);
        String[] srilanka_name= getResources().getStringArray(R.array.Srilanka);
        playerAdapter= new PlayerAdapter(this,srilanka_image, srilanka_name);
        srilanka_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

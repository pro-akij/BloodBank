package com.something.iccworldcup2019.Team_Activety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.something.iccworldcup2019.Adapter.PlayerAdapter;
import com.something.iccworldcup2019.R;

public class Team_AFG extends AppCompatActivity {
    private ListView afragnistan_team;
    private PlayerAdapter playerAdapter;
    private int[] afganistan_image={
            R.drawable.afgan,R.drawable.zazai,R.drawable.shahidi,R.drawable.zadran,R.drawable.ahmadi,
            R.drawable.noor,R.drawable.shahzad,R.drawable.afsarzazai,R.drawable.nabi,R.drawable.naib,
            R.drawable.shah,R.drawable.shenwari,R.drawable.aftab,R.drawable.janat,R.drawable.dawlatzadan,
            R.drawable.mojib,R.drawable.rashidkhan,R.drawable.zahirkhan};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__afg);
        String[] afganistan_name= getResources().getStringArray(R.array.Afganistan);
        afragnistan_team= findViewById(R.id.afganistan_team);
        playerAdapter= new PlayerAdapter(this,afganistan_image, afganistan_name);
        afragnistan_team.setAdapter(playerAdapter);
    }
    @Override
    public void onBackPressed() {
    }
}

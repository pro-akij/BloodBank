package com.example.habib.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class News extends AppCompatActivity {
    private ListView news_listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        news_listView= findViewById(R.id.news_list_view);
        String[] get_News= getResources().getStringArray(R.array.Blood_News);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, get_News);
        news_listView.setAdapter(arrayAdapter);

        news_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"clicked "+news_listView.getItemAtPosition(position),Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.example.habib.bloodbank;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.habib.bloodbank.Adapter.Item_adapterAM;
import com.example.habib.bloodbank.Database.Add_Amb_DBStore;
import com.example.habib.bloodbank.EditActivity.Add_amb;
import com.example.habib.bloodbank.Model.Item_viewAM;

import java.util.ArrayList;
import java.util.List;

public class Ambulance extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private Button Add_Amb;
    private Add_Amb_DBStore add_amb_dbStore;
    List<Item_viewAM> amlist;
    Item_adapterAM item_adapterAM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);
        recyclerView= findViewById(R.id.amb_list_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        amlist= new ArrayList<>();
        Add_Amb= findViewById(R.id.add_amb);
        add_amb_dbStore= new Add_Amb_DBStore(this);
        Add_Amb.setOnClickListener(this);

        Cursor res= add_amb_dbStore.Display_Data();
        if (res.getCount() == 0){
            Toast.makeText(this,"no data found",Toast.LENGTH_LONG).show();
        }else {
            //List<String> amb_List= new ArrayList<String>();
            while (res.moveToNext()){
                amlist.add( new Item_viewAM(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), R.drawable.ambulance, R.drawable.district, R.drawable.location, R.drawable.contact));
            }
            item_adapterAM= new Item_adapterAM(this, amlist);
            recyclerView.setAdapter(item_adapterAM);
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.add_amb){
            Intent intent= new Intent(Ambulance.this, Add_amb.class);
            startActivity(intent);
        }
    }
}







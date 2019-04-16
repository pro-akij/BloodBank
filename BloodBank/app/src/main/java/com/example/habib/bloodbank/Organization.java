package com.example.habib.bloodbank;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.habib.bloodbank.Adapter.Item_adapterCL;
import com.example.habib.bloodbank.Database.Add_org_DBStore;
import com.example.habib.bloodbank.EditActivity.Add_org;
import com.example.habib.bloodbank.Model.Item_viewCL;

import java.util.ArrayList;
import java.util.List;

public class Organization extends AppCompatActivity implements View.OnClickListener {
    private Button submit_Btn;
    private RecyclerView club_list_view;
    private Add_org_DBStore add_org_dbStore;
    private Item_adapterCL item_adapterCL;
    private List<Item_viewCL> item_viewCLList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);
        submit_Btn= findViewById(R.id.add_org);
        club_list_view= findViewById(R.id.club_list_view);
        club_list_view.setHasFixedSize(true);
        club_list_view.setLayoutManager(new LinearLayoutManager(this));
        item_viewCLList= new ArrayList<>();
        add_org_dbStore= new Add_org_DBStore(this);
        submit_Btn.setOnClickListener(this);
        Data_Disply();
    }

    public void Data_Disply(){
        Cursor result= add_org_dbStore.Display_Data();
        if (result.getCount()==0){
            return;
        }else {
            while (result.moveToNext()) {
                item_viewCLList.add(new Item_viewCL(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),R.drawable.name,R.drawable.location,R.drawable.district,R.drawable.contact));
            }
            item_adapterCL= new Item_adapterCL(this, item_viewCLList);
            club_list_view.setAdapter(item_adapterCL);
        }
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id==R.id.add_org){
            Intent intent= new Intent(Organization.this, Add_org.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {

    }

}

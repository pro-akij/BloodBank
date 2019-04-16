package com.example.habib.bloodbank.EditActivity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.habib.bloodbank.Adapter.Item_adapter;
import com.example.habib.bloodbank.Database.Add_Rqst_DBStore;
import com.example.habib.bloodbank.Model.Item_view;
import com.example.habib.bloodbank.R;

import java.util.ArrayList;
import java.util.List;

public class Add_Feed extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Add_Rqst_DBStore add_rqst_dbStore;
    List<Item_view> list;
    Item_adapter item_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__feed);
        recyclerView= findViewById(R.id.feed_list_data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add_rqst_dbStore= new Add_Rqst_DBStore(this);
        list= new ArrayList<>();
        show_Database();
    }
    public void show_Database(){
        Cursor res= add_rqst_dbStore.Display_Data();
        if (res.getCount()==0){
            Toast.makeText(this,"no data found",Toast.LENGTH_LONG).show();
            return;
        }else {
            //List<String> feed_List= new ArrayList<>();
            while (res.moveToNext()){
               list.add(new Item_view(res.getString(1),res.getString(2),
                       res.getString(3).toString(),res.getString(4),res.getString(5),
                       res.getString(6), res.getString(7), res.getString(8),
                       R.drawable.name,R.drawable.blood1,R.drawable.blamount,R.drawable.district,
                       R.drawable.contact,R.drawable.hospital,R.drawable.location,R.drawable.description));

             }
            item_adapter= new Item_adapter(this, list);
            recyclerView.setAdapter(item_adapter);
        }
    }

    @Override
    public void onBackPressed() {

    }
}

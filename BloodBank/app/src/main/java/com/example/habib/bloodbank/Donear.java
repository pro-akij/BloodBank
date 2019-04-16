package com.example.habib.bloodbank;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.habib.bloodbank.Adapter.Item_adapterDN;
import com.example.habib.bloodbank.Database.Add_Dnr_DBStore;
import com.example.habib.bloodbank.EditActivity.Add_Doner_Info;
import com.example.habib.bloodbank.Model.Item_viewDN;

import java.util.ArrayList;
import java.util.List;

public class Donear extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerViewDN;
    private Button list_Add_doner_btn;
    private Add_Dnr_DBStore dnr_dbStore;
    private Item_adapterDN item_adapterDN;
    private List<Item_viewDN> item_viewDNList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donear);
        recyclerViewDN= findViewById(R.id.doner_list_view);
        recyclerViewDN.setHasFixedSize(true);
        recyclerViewDN.setLayoutManager(new LinearLayoutManager(this));
        item_viewDNList= new ArrayList<>();
        dnr_dbStore= new Add_Dnr_DBStore(this);
        list_Add_doner_btn= findViewById(R.id.list_Add_doner_btn);
        list_Add_doner_btn.setOnClickListener(this);

        Data_Show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.list_Add_doner_btn){
            Intent intent= new Intent(Donear.this, Add_Doner_Info.class);
            startActivity(intent);
        }
    }

    public void Data_Show(){
        Cursor result= dnr_dbStore.Display_Data();
        if (result.getCount()== 0){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
            return;
        }else {
            while (result.moveToNext()){
               item_viewDNList.add( new Item_viewDN(result.getString(1), result.getString(2), result.getString(3),
                       result.getString(4),R.drawable.name,R.drawable.blamount,R.drawable.district,R.drawable.contact));
            }
            item_adapterDN= new Item_adapterDN(this, item_viewDNList);
            recyclerViewDN.setAdapter(item_adapterDN);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        final MenuItem itemsearch= menu.findItem(R.id.search_menu);
        searchView= (SearchView) itemsearch.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Item_viewDN> filtering= filter(item_viewDNList, newText);
                item_adapterDN.setFilter(filtering);
                return true;
            }
        });
        return true;
    }

    private List<Item_viewDN> filter(List<Item_viewDN> feloop, String query){
        query= query.toLowerCase();
        final List<Item_viewDN> filterlisted= new ArrayList<>();
        for (Item_viewDN model: feloop){
            final String text= model.getDoner_blood_type().toLowerCase();
            if (text.startsWith(query)){
                filterlisted.add(model);
            }
        }
        return filterlisted;
    }



    @Override
    public void onBackPressed() {

    }

}

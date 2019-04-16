package com.example.habib.bloodbank;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.habib.bloodbank.Adapter.Item_adapterMYACC;
import com.example.habib.bloodbank.Database.MyAccount_DB_Store;
import com.example.habib.bloodbank.Model.My_account_item;

import java.util.ArrayList;
import java.util.List;

public class MyAccount extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<My_account_item> myAccountItemList;
    Item_adapterMYACC item_adapterMYACC;
    private MyAccount_DB_Store myAccount_db_store;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        myAccount_db_store= new MyAccount_DB_Store(this);
        recyclerView= findViewById(R.id.my_accoutn_recyler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAccountItemList= new ArrayList<>();
        Show_Database();
    }
    public void Show_Database(){
        Cursor res= myAccount_db_store.Display_Data();
        if (res.getCount()==0){
            Toast.makeText(MyAccount.this,"no data found",Toast.LENGTH_LONG).show();
        }else {
            //StringBuffer buffer= new StringBuffer();
            while (res.moveToNext()){
                myAccountItemList.add(new My_account_item(res.getString(1),res.getString(2),res.getString(3),
                        res.getString(4),R.drawable.name,R.drawable.contact,R.drawable.blood1,R.drawable.district));
            }
            item_adapterMYACC= new Item_adapterMYACC(this,myAccountItemList);
            recyclerView.setAdapter(item_adapterMYACC);
        }
    }

    @Override
    public void onBackPressed() {
    }

    public void invalid(){
        /*
        *
        * <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:padding="10dp">

            <ImageView
                android:id="@+id/not_useable_icon"
                android:layout_width="30dp"
                android:layout_height="30dp"
                app:srcCompat="@drawable/ambulance" />

            <ImageView
                android:id="@+id/not_useable_icon1"
                android:layout_width="30dp"
                android:layout_height="30dp"
                android:layout_below="@+id/not_useable_icon"
                app:srcCompat="@drawable/district"
                android:layout_marginTop="5dp"/>

            <ImageView
                android:id="@+id/not_useable_icon2"
                android:layout_width="30dp"
                android:layout_height="30dp"
                android:layout_below="@+id/not_useable_icon1"
                app:srcCompat="@drawable/location"
                android:layout_marginTop="5dp"/>

            <ImageView
                android:id="@+id/not_useable_icon3"
                android:layout_width="30dp"
                android:layout_height="30dp"
                android:layout_below="@+id/not_useable_icon2"
                app:srcCompat="@drawable/contact"
                android:layout_marginTop="5dp"/>

            <TextView
                android:id="@+id/my_name"
                android:layout_width="match_parent"
                android:layout_height="30dp"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@id/not_useable_icon"
                android:text="this is app developer"
                android:textStyle="bold"
                android:layout_marginTop="5dp"/>
            <TextView
                android:id="@+id/my_contact"
                android:layout_width="match_parent"
                android:layout_height="30dp"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@id/not_useable_icon1"
                android:layout_below="@+id/my_name"
                android:text="this is app developer"
                android:textStyle="bold"
                android:layout_marginTop="5dp"/>
            <TextView
                android:id="@+id/my_blood"
                android:layout_width="match_parent"
                android:layout_height="30dp"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@id/not_useable_icon2"
                android:layout_below="@+id/my_contact"
                android:text="this is app developer"
                android:textStyle="bold"
                android:layout_marginTop="5dp"/>
            <TextView
                android:id="@+id/my_district"
                android:layout_width="match_parent"
                android:layout_height="30dp"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@id/not_useable_icon3"
                android:layout_below="@+id/my_blood"
                android:text="this is app developer"
                android:textStyle="bold"
                android:layout_marginTop="5dp"/>


        *
        * */
    }
}

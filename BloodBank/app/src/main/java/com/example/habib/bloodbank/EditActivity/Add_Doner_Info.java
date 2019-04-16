package com.example.habib.bloodbank.EditActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.habib.bloodbank.Database.Add_Dnr_DBStore;
import com.example.habib.bloodbank.Donear;
import com.example.habib.bloodbank.R;

public class Add_Doner_Info extends AppCompatActivity implements View.OnClickListener {
    private Button doner_Submit;
    private EditText doner_name, contact;
    private Spinner spin_doner_Bl_Type, spin_district;
    private Add_Dnr_DBStore dnr_dbStore;
    private String[] set_Spinner_Blood, set_Spinner_District;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__doner__info);
        set_Spinner_Blood= getResources().getStringArray(R.array.Blood_Name);
        set_Spinner_District= getResources().getStringArray(R.array.District_Name);
        For_Find();
        dnr_dbStore = new Add_Dnr_DBStore(this);
        doner_Submit.setOnClickListener(this);
    }

    public void For_Find() {
        doner_Submit = findViewById(R.id.doner_submit);
        doner_name = findViewById(R.id.doner_name);
        spin_district = findViewById(R.id.doner_district);
        contact = findViewById(R.id.doner_contact);
        spin_doner_Bl_Type = findViewById(R.id.doner_Bl_Type);

        ArrayAdapter my_district_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,set_Spinner_District);
        my_district_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_district.setAdapter(my_district_arrayAdapter);

        ArrayAdapter BL_type_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,set_Spinner_Blood);
        BL_type_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_doner_Bl_Type.setAdapter(BL_type_arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        String get_Item_blood= (String) spin_doner_Bl_Type.getSelectedItem();
        String get_Item_district= (String) spin_district.getSelectedItem();

        if (doner_name.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else if (contact.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else {
            long check= dnr_dbStore.Insert_Data(doner_name.getText().toString(),get_Item_blood, get_Item_district, contact.getText().toString());
            if (check>-1){
                Toast.makeText(this,"added !!!",Toast.LENGTH_LONG).show();
                doner_name.setText("");contact.setText("");
                Intent intent= new Intent(Add_Doner_Info.this, Donear.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}

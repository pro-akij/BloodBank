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

import com.example.habib.bloodbank.Database.Add_org_DBStore;
import com.example.habib.bloodbank.Organization;
import com.example.habib.bloodbank.R;

public class Add_org extends AppCompatActivity implements View.OnClickListener {
    private EditText org_Name, org_Address, org_Contact;
    private Spinner org_District;
    private Button org_Submit;
    private Add_org_DBStore add_org_dbStore;
    private String[] club_District;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_org);
        add_org_dbStore= new Add_org_DBStore(this);
        club_District= getResources().getStringArray(R.array.District_Name);
        For_Find();
        org_Submit.setOnClickListener(this);
    }

    private void For_Find(){
        org_Name= findViewById(R.id.org_name);
        org_Address= findViewById(R.id.org_address);
        org_District= findViewById(R.id.org_district);
        org_Contact= findViewById(R.id.org_contact);
        org_Submit= findViewById(R.id.org_submit);

        ArrayAdapter org_district_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, club_District);
        org_district_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        org_District.setAdapter(org_district_arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id==R.id.org_submit){
            String club_Dis= org_District.getSelectedItem().toString();
            if (org_Name.getText().toString().isEmpty() && org_Address.getText().toString().isEmpty() &&
                    org_Contact.getText().toString().isEmpty()){
                Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
            }else {
                long check= add_org_dbStore.Insert_Data(org_Name.getText().toString(), org_Address.getText().toString(), club_Dis, org_Contact.getText().toString());
                if (check> -1){
                    Toast.makeText(this,"Data added !!",Toast.LENGTH_LONG).show();
                    org_Name.setText(""); org_Address.setText(""); org_Contact.setText("");
                    Intent intent= new Intent(Add_org.this, Organization.class);
                    startActivity(intent);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}

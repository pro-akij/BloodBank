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

import com.example.habib.bloodbank.Ambulance;
import com.example.habib.bloodbank.Database.Add_Amb_DBStore;
import com.example.habib.bloodbank.R;

public class Add_amb extends AppCompatActivity {
    private EditText amb_Name, amb_Location, amb_Contact;
    private Spinner amb_District;
    private Button amb_Btn_Submit;
    private Add_Amb_DBStore add_amb_dbStore;
    String[] amb_District_set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amb);
        add_amb_dbStore= new Add_Amb_DBStore(this);
        amb_District_set= getResources().getStringArray(R.array.District_Name);
        For_Find();
        Database_Add();
    }

    public void For_Find(){
        amb_Name= findViewById(R.id.enter_Amb_Name);
        amb_Location= findViewById(R.id.enter_Amb_Location);
        amb_District= findViewById(R.id.enter_Amb_District);
        amb_Contact= findViewById(R.id.enter_Amb_Contact);
        amb_Btn_Submit= findViewById(R.id.Amb_Btn);

        ArrayAdapter amb_district_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, amb_District_set);
        amb_district_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amb_District.setAdapter(amb_district_arrayAdapter);
    }
    public void Database_Add(){
        amb_Btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amb_Dis= amb_District.getSelectedItem().toString();
                if (amb_Name.getText().toString().isEmpty()){
                    Toast.makeText(Add_amb.this,"please input data",Toast.LENGTH_LONG).show();
                } else if (amb_Location.getText().toString().isEmpty()){
                    Toast.makeText(Add_amb.this,"please input data",Toast.LENGTH_LONG).show();
                } else if (amb_Contact.getText().toString().isEmpty()) {
                    Toast.makeText(Add_amb.this, "please input data", Toast.LENGTH_LONG).show();
                } else {
                    add_amb_dbStore.Insert_Data(amb_Name.getText().toString(), amb_Location.getText().toString(), amb_Dis, amb_Contact.getText().toString());
                    Toast.makeText(Add_amb.this, "saved", Toast.LENGTH_LONG).show();
                    amb_Name.setText(""); amb_Location.setText(""); amb_Contact.setText("");
                    Intent intent= new Intent(Add_amb.this, Ambulance.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}

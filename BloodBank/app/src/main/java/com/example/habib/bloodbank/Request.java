package com.example.habib.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.habib.bloodbank.Database.Add_Rqst_DBStore;

public class Request extends AppCompatActivity implements View.OnClickListener {
    private EditText full_Name, contact_Phone, hospital_Name, hopital_Location, blood_Reason;
    private Spinner blood_Type, blood_Amount, your_District;
    private Add_Rqst_DBStore add_rqst_dbStore;
    private Button submit_Request;
    private String[] st_blood_Type, st_blood_Amount, st_your_District;
    private String blood_type, blood_amount, your_district;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        st_blood_Type= getResources().getStringArray(R.array.Blood_Name);
        st_blood_Amount= getResources().getStringArray(R.array.Blood_Amount);
        st_your_District= getResources().getStringArray(R.array.District_Name);

        add_rqst_dbStore= new Add_Rqst_DBStore(this);
        Find_View();
        set_Data();
        submit_Request.setOnClickListener(this);
    }
    public void Find_View(){
        full_Name= findViewById(R.id.Enter_Full_name);
        contact_Phone= findViewById(R.id.Enter_contact_phone);
        hospital_Name= findViewById(R.id.Enter_Hospital_Name);
        hopital_Location= findViewById(R.id.Enter_Hospital_Location);
        blood_Reason= findViewById(R.id.Enter_Blood_reason);
        blood_Type= findViewById(R.id.Enter_Blood_Type);
        blood_Amount= findViewById(R.id.Enter_Blood_Amount);
        your_District= findViewById(R.id.Enter_your_District);
        submit_Request= findViewById(R.id.submit_Request);
    }

    public void set_Data(){
        ArrayAdapter BL_type_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,st_blood_Type);
        BL_type_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blood_Type.setAdapter(BL_type_arrayAdapter);

        ArrayAdapter BL_amount_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,st_blood_Amount);
        BL_amount_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blood_Amount.setAdapter(BL_amount_arrayAdapter);

        ArrayAdapter yr_Dis_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,st_your_District);
        yr_Dis_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        your_District.setAdapter(yr_Dis_arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.submit_Request){

            /*blood_Type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });

            blood_Amount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }

            });

            your_District.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });*/
            blood_type= blood_Type.getSelectedItem().toString();
            blood_amount= blood_Amount.getSelectedItem().toString();
            your_district= your_District.getSelectedItem().toString();

            set_Database();
            full_Name.setText("");contact_Phone.setText("");hospital_Name.setText("");
            hopital_Location.setText("");blood_Reason.setText("");
        }
    }

    public void set_Database(){
        if (full_Name.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else if (contact_Phone.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else if (hospital_Name.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else if (hopital_Location.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else if (blood_Reason.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else { add_rqst_dbStore.Insert_Data(full_Name.getText().toString(),blood_type,blood_amount,your_district,contact_Phone.getText().toString(),
                hospital_Name.getText().toString(),hopital_Location.getText().toString(),blood_Reason.getText().toString());
            Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {

    }
}

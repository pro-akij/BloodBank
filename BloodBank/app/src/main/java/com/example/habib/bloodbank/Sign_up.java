package com.example.habib.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.habib.bloodbank.Database.MyAccount_DB_Store;
import com.example.habib.bloodbank.Model.Firebase_sign_data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up extends AppCompatActivity {
    private Button sign_up;
    private EditText user_email, password, reg_name, reg_contact;
    private Spinner reg_blood, reg_district;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private DatabaseReference databaseReference;
    private MyAccount_DB_Store myAccount_db_store;
    private String[] blood_Type, district;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sign_up= findViewById(R.id.sign_up);
        reg_name= findViewById(R.id.enter_reg_name);
        reg_contact= findViewById(R.id.enter_reg_contact);
        reg_blood= findViewById(R.id.enter_reg_blood_type);
        reg_district= findViewById(R.id.enter_reg_district);
        user_email= findViewById(R.id.user_email);
        password= findViewById(R.id.passward);
        progressBar= findViewById(R.id.login_progress);
        myAccount_db_store= new MyAccount_DB_Store(this);

        blood_Type= getResources().getStringArray(R.array.Blood_Name);
        district= getResources().getStringArray(R.array.District_Name);

        databaseReference= FirebaseDatabase.getInstance().getReference();
        mAuth= FirebaseAuth.getInstance();

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sign_in();
            }
        });
        Set_Spinner_Data();

    }
    public void Sign_in(){
        String email= user_email.getText().toString().trim();
        String pass= password.getText().toString().trim();

        if (email.isEmpty()){
            user_email.setError("Enter Email Address");
            user_email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            user_email.setError("Enter a valid Email Address");
            user_email.requestFocus();
            return;
        }
        if (pass.isEmpty() || pass.length()<6 ){
            password.setError("Enter passward and at leat 6 char long");
            password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Toast.makeText(getApplicationContext(), "sign up successfully",Toast.LENGTH_LONG).show();
                    Data_Insert();
                    startActivity(new Intent(Sign_up.this, MainActivity.class));
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "This Email already used",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error "+task.getException(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    public void Set_Spinner_Data(){
        ArrayAdapter BL_type_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,blood_Type);
        BL_type_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reg_blood.setAdapter(BL_type_arrayAdapter);

        ArrayAdapter district_arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,district);
        district_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reg_district.setAdapter(district_arrayAdapter);
    }

    public void Data_Insert(){
        String bl= reg_blood.getSelectedItem().toString();
        String dis= reg_district.getSelectedItem().toString();

        if (reg_name.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else if (reg_contact.getText().toString().isEmpty()){
            Toast.makeText(this,"input data",Toast.LENGTH_LONG).show();
        } else {
            long chek= myAccount_db_store.Insert_Data(reg_name.getText().toString(),
                    reg_contact.getText().toString(), bl, dis);
            if (chek> -1){
                Toast.makeText(getApplicationContext(),"data saved !!", Toast.LENGTH_LONG).show();
            }
            reg_name.setText("");reg_contact.setText("");
        }
    }
}

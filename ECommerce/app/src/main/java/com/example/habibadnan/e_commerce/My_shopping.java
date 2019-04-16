package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class My_shopping extends AppCompatActivity {
    private TextView email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shopping);
        email= findViewById(R.id.show_email);
        password= findViewById(R.id.show_password);
        Intent intent= new Intent();
        Bundle bundle= getIntent().getExtras();
        if (bundle!=null){
            String recieve_email= bundle.getString("email");
            email.setText(recieve_email);
            String receive_password= bundle.getString("password");
            password.setText(receive_password);
            String go_to_main_for_email=email.getText().toString();
            String go_to_main_for_password= password.getText().toString();
            intent.putExtra(go_to_main_for_email,"pass_main_email");
            intent.putExtra(go_to_main_for_password,"pass_main_password");
        }
        //password.setText(getIntent().getExtras().getString("password"));
    }
}

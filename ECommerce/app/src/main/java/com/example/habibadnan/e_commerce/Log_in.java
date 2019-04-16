package com.example.habibadnan.e_commerce;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Log_in extends AppCompatActivity {
    TextView go_to_register_by_text;
    private EditText email, password;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        email= findViewById(R.id.log_in_email);
        password= findViewById(R.id.log_in_password);
        submit= findViewById(R.id.log_in_submit);
        go_to_register_by_text= findViewById(R.id.go_to_register);

        go_to_register_by_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Log_in.this,Register.class);
                startActivity(intent);
                Toast.makeText(Log_in.this,"yeahh i am here in register",Toast.LENGTH_LONG).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().length()>15 && password.getText().toString().length()>4){
                    Intent intent= new Intent(Log_in.this,My_shopping.class);
                    Toast.makeText(Log_in.this,"yea i am loged in",Toast.LENGTH_LONG).show();
                    String pass_email= String.valueOf(email.getText().toString());
                    String pass_password= String.valueOf(password.getText().toString());
                    intent.putExtra("email",pass_email);
                    intent.putExtra("password",pass_password);
                    email.setText("");password.setText("");
                    startActivity(intent);
                }else {
                    Toast.makeText(Log_in.this,"no it has some problem",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

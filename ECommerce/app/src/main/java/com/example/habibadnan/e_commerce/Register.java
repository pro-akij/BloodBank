package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText email, password, repassword;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email= findViewById(R.id.register_email);
        password= findViewById(R.id.register_password);
        repassword= findViewById(R.id.register_repassword);
        submit= findViewById(R.id.register_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals(repassword.getText().toString()) &&
                        password.getText().toString().length() > 5 && email.getText().toString().length() > 15){
                    Intent intent = new Intent(Register.this, Log_in.class);
                    startActivity(intent);
                    Toast.makeText(Register.this, "yea i am registered", Toast.LENGTH_LONG).show();
                    email.setText("");
                    password.setText("");
                    repassword.setText("");
                }else {
                    Toast.makeText(Register.this,"please fill properly",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

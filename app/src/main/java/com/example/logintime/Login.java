package com.example.logintime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText name,pass2;
    Button login;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.editTextTextPersonName);
        pass2 = findViewById(R.id.editTextTextPassword);

        login = findViewById(R.id.button);

        db = new DBHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = name.getText().toString();
                String pass = pass2.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else{

                    Boolean checkuserpass = db.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this, "Sign in successful.", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(Login.this,MainActivity.class));
                    }
                }

            }
        });
    }
}
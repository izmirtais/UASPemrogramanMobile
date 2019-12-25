package com.example.uaspemrogramanmobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uaspemrogramanmobile.R;
import com.example.uaspemrogramanmobile.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.Security;

public class RegistrasiActivity extends AppCompatActivity {


    FirebaseAuth firebaseAuth;

    EditText edtEmail, edtUsername, edtPassword, edtNewPassword ;
    Button btnreg;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        firebaseAuth = FirebaseAuth.getInstance();

        edtEmail = findViewById(R.id.edt_email);
        edtUsername = findViewById(R.id.edt_reset_username);
        edtPassword = findViewById(R.id.edt_new_password);
        edtNewPassword = findViewById(R.id.edt_new_password2);

        btnreg = findViewById(R.id.btn_create);
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();


            }

            private void addUser() {
                final String email = edtEmail.getText().toString();
                final String username = edtUsername.getText().toString();
                final String password = edtPassword.getText().toString();
                final String newpassword = edtNewPassword.getText().toString();

                if (email.isEmpty() || username.isEmpty() || password.isEmpty() || newpassword.isEmpty()){
                    showMessage("Mohon isi semua kolom ");
                }else {
                    User user= new User(email,username,password,newpassword);
                    databaseReference.child(username).child("email").setValue(username.toString());
                    databaseReference.child(username).child("username").setValue(username.toString());
                    try {
                        databaseReference.child(username).child("password").setValue(Security.encrypt(password));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplication(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
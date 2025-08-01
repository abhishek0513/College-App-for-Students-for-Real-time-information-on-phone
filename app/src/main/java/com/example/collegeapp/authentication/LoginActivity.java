package com.example.collegeapp.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collegeapp.MainActivity;
import com.example.collegeapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextView openReg, forgotPassword;

    private EditText logEmail, logPassword;

    private Button loginBtn;

    private String email, password;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openReg = findViewById(R.id.openReg);
        loginBtn = findViewById(R.id.loginBtn);
        logEmail = findViewById(R.id.loginEmail);
        logPassword = findViewById(R.id.loginPassword);
        auth = FirebaseAuth.getInstance();

        forgotPassword = findViewById(R.id.forgot_password);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
                finish();
            }
        });

        openReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = logEmail.getText().toString().trim();
                String password = logPassword.getText().toString().trim();
                if(mail.isEmpty()||password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Login the user

//                    mprogressbarofmainactivity.setVisibility(View.VISIBLE);

                    auth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                checkVerification();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Account don't exist", Toast.LENGTH_SHORT).show();
//                                mprogressbarofmainactivity.setVisibility(View.INVISIBLE);
                            }
                        }
                    });



                }
            }
        });
    }

    private void checkVerification() {
        FirebaseUser firebaseUser = auth.getCurrentUser();

        if(firebaseUser.isEmailVerified() == true){
            Toast.makeText(getApplicationContext(), "Welcome, Logged in", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        else{
//            mprogressbarofmainactivity.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "Verify the mail first", Toast.LENGTH_SHORT).show();
            auth.signOut();
        }
    }

    private void openRegister() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }

}
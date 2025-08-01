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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText regName, regEmail, regNumber, regBranch, regPassword;
    private Button register;

    private String name, email, number , password, branch;

    private FirebaseAuth auth;


    private DatabaseReference reference;
    private DatabaseReference dbref;

    private TextView openLog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();



        regName = findViewById(R.id.regName);
        regNumber= findViewById(R.id.regNumber);
        regBranch = findViewById(R.id.regBranch);
        regEmail= findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        register = findViewById(R.id.register);

        openLog = findViewById(R.id.openLog);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });


        openLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    private void openLogin() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (auth.getCurrentUser() != null){
            openMain();
        }
    }

    private void openMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }



    private void validateData() {
            name = regName.getText().toString();
            password = regPassword.getText().toString();
            branch = regBranch.getText().toString();
            email = regEmail.getText().toString();
            number = regNumber.getText().toString();


            if (name.isEmpty()){
                regName.setError("Required");
                regName.requestFocus();
            }
            else if (number.length() < 10 || number.length() > 10 ){
                regNumber.setError("Incorrect");
                regNumber.requestFocus();
                if (number.isEmpty()){
                regNumber.setError("Required");
                regNumber.requestFocus();
                }
            }
            else if (branch.isEmpty()){
                regBranch.setError("Required");
                regBranch.requestFocus();
            }
            else if (email.isEmpty()){
                regEmail.setError("Required");
                regEmail.requestFocus();
            }
            else if (password.isEmpty()){
                regPassword.setError("Required");
                regPassword.requestFocus();
            }
            else {
                createUser();
            }
    }

    private void createUser() {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    uploadData(); 

                }else{
                    Toast.makeText(RegisterActivity.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, "Error : " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadData() {
        dbref  = reference.child("users");
        String key = dbref.push().getKey();

        HashMap<String, String> user = new HashMap<>();
        user.put("key", key);
        user.put("name", name);
        user.put("email", email);
        user.put("number", number);
        user.put("branch", branch);
        user.put("password", password);

        dbref.child(key).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User Created", Toast.LENGTH_SHORT).show();
//                            openMain();
                                sendEmailVerification();
                        }else{
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if(firebaseUser!= null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), "Verification Email Sent", Toast.LENGTH_SHORT).show();
                    auth.signOut();
                    finish();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(), "Verification Email Not Sent", Toast.LENGTH_SHORT).show();
        }
    }
}
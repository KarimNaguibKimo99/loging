package com.example.android.loging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {

    private Button mLogoutBtn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mLogoutBtn = findViewById(R.id.logout);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();

                updateUI();
            }
        });


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser ==null){
            updateUI();

        }
    }

    private void updateUI() {

        Toast.makeText(AccountActivity.this,"You're logged out ",Toast.LENGTH_LONG).show();
        Intent accountIntent = new Intent(AccountActivity.this , MainActivity.class);
        startActivity(accountIntent);
        finish();
    }
}

package com.example.android.loging;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileactivity);
    }


        private void updateUI() {

            Toast.makeText(ProfileActivity.this, "You're logged in ", Toast.LENGTH_LONG).show();
            Intent accountIntent = new Intent(ProfileActivity.this, AccountActivity.class);
            startActivity(accountIntent);
            finish();
        }
    }


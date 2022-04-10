package com.lambarkiyassine.iibdccm1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private TextView txtUsername;
    private TextView txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {// Handle the splash screen transition.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPassword = findViewById(R.id.password);
        txtUsername = findViewById(R.id.username);
        initComponent();
    }

    public void onLogout(View view) {
        clearStoringCredentials();
        onBackPressed();
    }

    private void initComponent() {
         final SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
        final String username = sharedPreferences.getString("username", null);
        final String password = sharedPreferences.getString("password", null);
        if (username == null || password == null) {
            onBackPressed();
        }
        txtUsername.setText(username);
        txtPassword.setText(password);
    }

    public void clearStoringCredentials() {
         final SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
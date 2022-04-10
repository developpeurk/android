package com.lambarkiyassine.iibdccm1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponent();

    }

    private void initComponent() {
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
    }

    public void onLogin(View view) {
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();
        final List<String> errors = validateInput();
        if (!errors.isEmpty()) {
            Toast.makeText(this, errors.toString(), Toast.LENGTH_LONG).show();

        } else {
            saveCredentials();
            final Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


    }

    private void saveCredentials() {
        final SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
        final SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("username", username);
        myEdit.putString("password", password);
        myEdit.apply();
    }


    private List<String> validateInput() {
        if (TextUtils.isEmpty(username)) {
            return Collections.singletonList(getString(R.string.username_is_mandatory));
        } else if (TextUtils.isEmpty(password)) {
            return Collections.singletonList(getString(R.string.password_is_mandatory));

        }
        return Collections.emptyList();
    }
}
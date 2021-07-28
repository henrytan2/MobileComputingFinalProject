package com.ucdenver.puppylove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ucdenver.puppylove.data.DataManager;
import com.ucdenver.puppylove.data.DataSingleton;
import com.ucdenver.puppylove.data.Interactor;

public class LoginActivity extends AppCompatActivity {
    private TextView loginErrorMessage;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button createAccountButton;
    private Button forgotPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DataManager dataManager = new DataManager(this);
        DataSingleton.SetInstance(dataManager);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.userNameEditText = findViewById(R.id.userNameEditText);
        this.passwordEditText = findViewById(R.id.passwordEditText);
        this.loginButton = findViewById(R.id.loginButton);
        this.createAccountButton = findViewById(R.id.createAccountButton);
        this.forgotPasswordButton = findViewById(R.id.forgotPasswordButton);
        this.loginErrorMessage = findViewById(R.id.loginErrorMessage);

        this.loginButton.setOnClickListener(
                v -> {
                    com.ucdenver.puppylove.data.models.User user = this.login();
                    if (user != null) {
                        LoggedInUser.setInstance(user);
                        this.moveToMainActivity();
                    }
                    else {
                        this.loginErrorMessage.setVisibility(TextView.VISIBLE);
                        this.loginErrorMessage.setText("Invalid username/password");
                        Toast.makeText(this, "Invalid username/password", Toast.LENGTH_LONG);
                    }
                }
        );

        this.createAccountButton.setOnClickListener(v -> {
            this.moveToCreateAccountActivity();
        });

        this.forgotPasswordButton.setOnClickListener(v -> {
            this.moveToForgotPasswordActivity();
        });
    }

    private com.ucdenver.puppylove.data.models.User login() {
        String username = this.userNameEditText.getText().toString();
        String password = this.passwordEditText.getText().toString();

        com.ucdenver.puppylove.data.models.User response = Interactor.getUserInstance().login(username, password);
        return response;
    }

    private void moveToMainActivity() {
        Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
        myIntent.putExtra("", "");
        LoginActivity.this.startActivity(myIntent);
    }

    private void moveToCreateAccountActivity() {
        Intent myIntent = new Intent(LoginActivity.this, CreateAccountActivity.class);
        myIntent.putExtra("", "");
        LoginActivity.this.startActivity(myIntent);
    }

    private void moveToForgotPasswordActivity() {
        Intent myIntent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        myIntent.putExtra("", "");
        LoginActivity.this.startActivity(myIntent);
    }
}
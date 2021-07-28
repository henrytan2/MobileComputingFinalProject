package com.ucdenver.puppylove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText emailEditText;
    private EditText passwordOne;
    private EditText passwordTwo;
    private Button resetPasswordButton;

    public ForgotPasswordActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        this.userNameEditText = findViewById(R.id.userNameEditTextForgot);
        this.emailEditText = findViewById(R.id.emailEditTextForgot);
        this.passwordOne = findViewById(R.id.passwordOneEditTextForgot);
        this.passwordTwo = findViewById(R.id.passwordTwoEditTextForgot);
        this.resetPasswordButton = findViewById(R.id.resetPasswordButton);

        this.resetPasswordButton.setOnClickListener(v -> {

        });
    }


}
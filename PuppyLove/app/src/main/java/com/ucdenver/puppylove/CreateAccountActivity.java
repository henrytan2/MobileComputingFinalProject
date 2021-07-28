package com.ucdenver.puppylove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ucdenver.puppylove.data.Interactor;
import com.ucdenver.puppylove.data.enums.WhyCreateAccountFailed;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText emailEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText phoneEditText;
    private EditText occupationEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        this.userNameEditText = findViewById(R.id.userNameEditTextCreate);
        this.emailEditText = findViewById(R.id.emailEditText);
        this.firstNameEditText = findViewById(R.id.firstNameEditText);
        this.lastNameEditText = findViewById(R.id.lastNameEditText);
        this.phoneEditText = findViewById(R.id.phoneEditText);
        this.occupationEditText = findViewById(R.id.occupationEditText);
        this.passwordEditText = findViewById(R.id.passwordEditTextCreate    );
        this.confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        this.createAccountButton = findViewById(R.id.createAccountButtonCreate);

        this.createAccountButton.setOnClickListener(v -> {
            this.createAccount();
        });
    }

    private void createAccount() {
        String username = this.userNameEditText.getText().toString();
        String email = this.emailEditText.getText().toString();
        String firstName = this.firstNameEditText.getText().toString();
        String lastName = this.lastNameEditText.getText().toString();
        String phone = this.phoneEditText.getText().toString();
        String occupation = this.occupationEditText.getText().toString();
        String password = this.passwordEditText.getText().toString();
        String passwordTwo = this.confirmPasswordEditText.getText().toString();

        if (username.isEmpty() || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() ||
                occupation.isEmpty() || password.isEmpty() || passwordTwo.isEmpty()) {
            Toast.makeText(this, "One or more fields need to be filled", Toast.LENGTH_SHORT).show();
            return;
        }

        if (false == password.equals(passwordTwo)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            com.ucdenver.puppylove.data.requests.User.CreateAccountResponse response = Interactor.getUserInstance().createAccount(
                    username,
                    password,
                    firstName,
                    lastName,
                    email,
                    phone,
                    occupation);
            if (response.getErrorCode() == WhyCreateAccountFailed.UsernameAlreadyExists) {
                Toast.makeText(this, "User name already exists", Toast.LENGTH_LONG);
            }
            this.moveToMainActivity();
        }
    }

    private void moveToMainActivity() {
        Intent myIntent = new Intent(CreateAccountActivity.this, MainActivity.class);
        myIntent.putExtra("", "");
        CreateAccountActivity.this.startActivity(myIntent);
    }
}
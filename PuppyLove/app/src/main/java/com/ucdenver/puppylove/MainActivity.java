package com.ucdenver.puppylove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ucdenver.puppylove.data.Interactor;

public class MainActivity extends AppCompatActivity {
    private ImageView dogImageView;
    private TextView dogNameTextView;
    private TextView dogAgeTextView;
    private TextView dogBreedTextView;
    private TextView dogDescriptionTextView;
    private Button adoptButton;
    private Button rejectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.mainActivityToolbar);
        setSupportActionBar(toolbar);

        this.dogImageView = findViewById(R.id.dogImageView);
        this.dogNameTextView = findViewById(R.id.dogNameTextView);
        this.dogAgeTextView = findViewById(R.id.dogAgeTextView);
        this.dogBreedTextView = findViewById(R.id.dogBreedTextView);
        this.dogDescriptionTextView = findViewById(R.id.dogDescription);
        this.adoptButton = findViewById(R.id.adoptButton);
        this.rejectButton = findViewById(R.id.rejectButton);

        MainActivity _this = this;
        this.adoptButton.setOnClickListener(v -> {
            boolean match = _this.calculateMatch();
            if (match) {
                MatchSuccessFragment matchSuccessFragment = new MatchSuccessFragment();
                matchSuccessFragment.show(getSupportFragmentManager(), "");
            }
            this.loadRandomDog();
        });

        this.rejectButton.setOnClickListener(v -> _this.loadRandomDog());

        this.loadRandomDog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_edit_profile) {
            EditProfileFragment editProfileFragment = new EditProfileFragment();
            editProfileFragment.show(getSupportFragmentManager(), "");
        }
        else if (id == R.id.action_logout) {
            LoggedInUser.clearInstance();
            this.moveToLoginActivity();
        }
        int a = 2;

        switch(a) {
            case 1:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void loadRandomDog() {
        com.ucdenver.puppylove.data.models.Dog dog = Interactor.getDogInstance().fetchRandom();
        this.dogNameTextView.setText(dog.getName());
        this.dogAgeTextView.setText(Integer.toString(dog.getAge()));
        this.dogBreedTextView.setText(dog.getBreed());
        this.dogDescriptionTextView.setText(dog.getDescription());
        int drawableID = getResources().getIdentifier(dog.getImageFilePath(), "drawable", this.getPackageName());
        Drawable dogImage = getResources().getDrawable(drawableID);
        this.dogImageView.setImageDrawable(dogImage);
    }

    private boolean calculateMatch() {
        boolean response = false;
        double randomNumber = Math.random();
        if (randomNumber < 0.5) {
            response = true;
        }
        return response;
    }

    private void moveToLoginActivity() {
        Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
        myIntent.putExtra("", "");
        MainActivity.this.startActivity(myIntent);
    }

    private void moveToForgotPasswordActivity() {
        Intent myIntent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
        myIntent.putExtra("", "");
        MainActivity.this.startActivity(myIntent);
    }
}
package com.ucdenver.puppylove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ucdenver.puppylove.data.DataManager;
import com.ucdenver.puppylove.data.DataSingleton;
import com.ucdenver.puppylove.data.Interactor;

public class MainActivity extends AppCompatActivity {
    private ImageView dogImageView;
    private TextView dogNameTextView;
    private TextView dogAgeTextView;
    private TextView dogBreedTextView;
    private TextView dogDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DataManager dataManager = new DataManager(this);
        DataSingleton.SetInstance(dataManager);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.mainActivityToolbar);
        setSupportActionBar(toolbar);

        this.dogImageView = findViewById(R.id.dogImageView);
        this.dogNameTextView = findViewById(R.id.dogNameTextView);
        this.dogAgeTextView = findViewById(R.id.dogAgeTextView);
        this.dogBreedTextView = findViewById(R.id.dogBreedTextView);
        this.dogDescriptionTextView = findViewById(R.id.dogDescription);

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
}
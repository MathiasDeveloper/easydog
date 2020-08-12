package fr.easydog.activities.dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import fr.easydog.R;
import fr.easydog.activities.HomeActivity;
import fr.easydog.activities.adapter.RaceAdapter;
import fr.easydog.activities.race.AddRaceActivity;
import fr.easydog.activities.utils.Alert;
import fr.easydog.bo.Dog;
import fr.easydog.bo.Race;
import fr.easydog.viewmodel.DogViewModel;
import fr.easydog.viewmodel.RaceViewModel;

public class AddDogActivity extends AppCompatActivity {

    private DogViewModel dogViewModel = null;
    private RaceViewModel raceViewModel = null;

    private EditText editName;
    private EditText editDescription;
    private Button addRace;
    //private EditText editDate;
    private Spinner spinnerRace;

    private Dog dog = null;

    List<String> raceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog);

        editName = findViewById(R.id.et_name);
        editDescription = findViewById(R.id.et_description);
        //editDate = findViewById(R.id.et_date);
        spinnerRace = (Spinner) findViewById(R.id.spinner_race);
        //validate = findViewById(R.id.bt_validate);

        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);
        raceViewModel = new ViewModelProvider(this).get(RaceViewModel.class);

        raceViewModel.getObserverLabel().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> races) {
                AddDogActivity.this.raceList = races;
                RaceAdapter raceAdapter = new RaceAdapter(
                        AddDogActivity.this,
                        android.R.layout.simple_spinner_item,
                        races
                );
                spinnerRace.setAdapter(raceAdapter);
                raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            }
        });

    }

    public void onClickValidate(View view) {
        dog = new Dog();
        dog.setName(editName.getText().toString());
        dog.setDescription(editDescription.getText().toString());
        //dog.setDate(editName.getText().toString());
        //dog.setName(editName.getText().toString());

        Log.i("ACOS", "INFO : " + dog.toString());

        dogViewModel.insert(dog);

        Toast.makeText(this, Alert.SUCCESS, Toast.LENGTH_SHORT).show();

        finish();
    }

    public void onClickAddRace(View view) {
        Intent intent = new Intent(this, AddRaceActivity.class);
        startActivity(intent);
    }
}
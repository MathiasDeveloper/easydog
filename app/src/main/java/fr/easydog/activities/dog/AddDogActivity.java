package fr.easydog.activities.dog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import fr.easydog.R;
import fr.easydog.activities.adapter.RaceAdapter;
import fr.easydog.activities.race.AddRaceActivity;
import fr.easydog.activities.utils.Alert;
import fr.easydog.bo.Dog;
import fr.easydog.viewmodel.DogViewModel;
import fr.easydog.viewmodel.RaceViewModel;

/**
 * AddDogActivity class
 * Controller for add dog
 */
public class AddDogActivity extends AppCompatActivity {

    /**
     * DogViewModel dogViewModel
     */
    private DogViewModel dogViewModel = null;

    /**
     * RaceViewModel raceViewModel
     */
    private RaceViewModel raceViewModel = null;

    /**
     * EditText editName
     */
    private EditText editName;

    /**
     * EditText editDescription
     */
    private EditText editDescription;

    /**
     * Button addRace
     */
    private Button addRace;

    //private EditText editDate;

    /**
     * Spinner spinnerRace
     */
    private Spinner spinnerRace;

    /**
     *  Dog dog
     */
    private Dog dog = null;

    /**
     *  List<String> raceList
     */
    List<String> raceList;

    /**
     * On create method
     * @param savedInstanceState
     * @return void
     */
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
            /**
             * On change on liste
             * @param races => object race list
             */
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

    /**
     * On click on button validate for event
     * @param view => view object
     */
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

    /**
     * On click button add race start new activity
     *
     * @param view => view object
     * @return void
     */
    public void onClickAddRace(View view) {
        Intent intent = new Intent(this, AddRaceActivity.class);
        startActivity(intent);
    }
}
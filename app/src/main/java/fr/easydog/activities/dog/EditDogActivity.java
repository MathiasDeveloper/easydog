package fr.easydog.activities.dog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import fr.easydog.R;
import fr.easydog.activities.adapter.RaceAdapter;
import fr.easydog.activities.utils.Action;
import fr.easydog.activities.utils.Alert;
import fr.easydog.bo.Dog;
import fr.easydog.bo.Race;
import fr.easydog.viewmodel.DogViewModel;
import fr.easydog.viewmodel.RaceViewModel;

/**
 * EditDogActivity class
 */
public class EditDogActivity extends AppCompatActivity {

    /**
     * DogViewModel dogViewModel
     */
    private DogViewModel dogViewModel = null;

    /**
     * DogViewModel dogViewModel
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
    //private EditText editDate;

    /**
     * Spinner spinnerRace
     */
    private Spinner spinnerRace;

    /**
     * Dog dog
     */
    private Dog dog = null;

    /**
     * Race race
     */
    private Race race = null;

    List<String> raceList;

    /**
     * On create activity
     * @param savedInstanceState
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dog);

        editName = findViewById(R.id.et_name);
        editDescription = findViewById(R.id.et_description);
        //editDate = findViewById(R.id.et_date);
        spinnerRace = findViewById(R.id.spinner_race);
        //validate = findViewById(R.id.bt_validate);

        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);

        dog = getIntent().getParcelableExtra(Action.EDIT);
        Log.i("Dog", dog.toString());
        editName.setText(dog.getName());
        editDescription.setText(dog.getDescription());


        raceViewModel = new ViewModelProvider(this).get(RaceViewModel.class);

        raceViewModel.getObserverLabel().observe(this, new Observer<List<String>>() {
            /**
             * On change on liste
             * @param races => object race list
             */
            @Override
            public void onChanged(List<String> races) {
                EditDogActivity.this.raceList = races;
                RaceAdapter raceAdapter = new RaceAdapter(
                        EditDogActivity.this,
                        android.R.layout.simple_spinner_item,
                        races
                );
                raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerRace.setAdapter(raceAdapter);
                if (dog.getRace() != null){
                    spinnerRace.setSelection(raceAdapter.getPosition(dog.getRace().getName()));
                }
            }
        });



    }

    /**
     * On click button update object dog
     * @param view
     */
    public void onClickUpdate(View view){

       String name = editName.getText().toString();
       String description = editDescription.getText().toString();

        if  (name.matches("")){
            Toast.makeText(this, Alert.ERROR, Toast.LENGTH_SHORT).show();
            return;
        }

        if (description.matches("")){
            Toast.makeText(this, Alert.ERROR, Toast.LENGTH_SHORT).show();
            return;
        }

        dog.setName(name);
        dog.setDescription(description);
        race = new Race(spinnerRace.getSelectedItem().toString());
        dog.setRace(race);

        Log.i("ACOS","INFO : " + dog.toString());

        dogViewModel.update(dog);

        Toast.makeText(this, Alert.UPDATE_SUCCESS, Toast.LENGTH_SHORT).show();
        finish();
    }
}
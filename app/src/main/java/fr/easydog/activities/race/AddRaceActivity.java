package fr.easydog.activities.race;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.easydog.R;
import fr.easydog.activities.utils.Alert;
import fr.easydog.bo.Race;
import fr.easydog.viewmodel.RaceViewModel;

/**
 * AddRaceActivity class
 * Controller for add race object
 */
public class AddRaceActivity extends AppCompatActivity {

    /**
     * EditText name
     */
    private EditText name = null;

    /**
     * RaceViewModel raceViewModel
     */
    private RaceViewModel raceViewModel = null;


    /**
     * On create method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_race);

        raceViewModel = new ViewModelProvider(this).get(RaceViewModel.class);
    }

    /**
     * On click validate add race
     * @param view => view object
     * @return void
     */
    public void onClickValidate(View view) {

        name = findViewById(R.id.et_race);

        Race race = new Race(name.getText().toString());
        raceViewModel.insert(race);

        Log.i("Info", race.toString());

        Toast.makeText(this, Alert.SUCCESS, Toast.LENGTH_SHORT).show();
        finish();
    }


}
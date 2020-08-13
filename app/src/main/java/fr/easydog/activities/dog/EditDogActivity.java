package fr.easydog.activities.dog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import fr.easydog.R;
import fr.easydog.activities.utils.Action;
import fr.easydog.activities.utils.Alert;
import fr.easydog.bo.Dog;
import fr.easydog.viewmodel.DogViewModel;

/**
 * EditDogActivity class
 */
public class EditDogActivity extends AppCompatActivity {

    /**
     * DogViewModel dogViewModel
     */
    private DogViewModel dogViewModel = null;

    /**
     * EditText editName
     */
    private EditText editName;

    /**
     * EditText editDescription
     */
    private EditText editDescription;
    //private EditText editDate;
    //private Spinner spinnerRace;

    /**
     * Dog dog
     */
    private Dog dog = null;

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
        //spinnerRace = findViewById(R.id.spinner_race);
        //validate = findViewById(R.id.bt_validate);

        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);

        dog = getIntent().getParcelableExtra(Action.EDIT);

        editName.setText(dog.getName());
        editDescription.setText(dog.getDescription());


    }

    /**
     * On click button update object dog
     * @param view
     */
    public void onClickUpdate(View view){
        dog.setName(editName.getText().toString());
        dog.setDescription(editDescription.getText().toString());

        Log.i("ACOS","INFO : " + dog.toString());

        dogViewModel.update(dog);

        Toast.makeText(this, Alert.UPDATE_SUCCESS, Toast.LENGTH_SHORT).show();
        finish();
    }
}
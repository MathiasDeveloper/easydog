package fr.easydog.activities.dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.easydog.R;
import fr.easydog.activities.utils.Action;
import fr.easydog.activities.utils.Alert;
import fr.easydog.bo.Dog;
import fr.easydog.viewmodel.DogViewModel;


public class EditDogActivity extends AppCompatActivity {

    private DogViewModel dogViewModel = null;
    private EditText editName;
    private EditText editDescription;
    //private EditText editDate;
    //private Spinner spinnerRace;

    private Dog dog = null;

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

    public void onClickUpdate(View view){
        dog.setName(editName.getText().toString());
        dog.setDescription(editDescription.getText().toString());

        Log.i("ACOS","INFO : " + dog.toString());

        dogViewModel.update(dog);

        Toast.makeText(this, Alert.UPDATE_SUCCESS, Toast.LENGTH_SHORT).show();
        finish();
    }
}
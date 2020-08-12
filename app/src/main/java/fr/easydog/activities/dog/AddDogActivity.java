package fr.easydog.activities.dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.easydog.R;
import fr.easydog.activities.utils.Alert;
import fr.easydog.bo.Dog;
import fr.easydog.viewmodel.DogViewModel;

public class AddDogActivity extends AppCompatActivity {

    private DogViewModel dogViewModel = null;

    private EditText editName;
    private EditText editDescription;
    //private EditText editDate;
    //private Spinner spinnerRace;

    private Dog dog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog);

        editName = findViewById(R.id.et_name);
        editDescription = findViewById(R.id.et_description);
        //editDate = findViewById(R.id.et_date);
        //spinnerRace = findViewById(R.id.spinner_race);
        //validate = findViewById(R.id.bt_validate);

        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);
    }

    public void onClickValidate(View view){
        dog = new Dog();
        dog.setName(editName.getText().toString());
        dog.setDescription(editDescription.getText().toString());
        //dog.setDate(editName.getText().toString());
        //dog.setName(editName.getText().toString());

        Log.i("ACOS","INFO : " + dog.toString());

        dogViewModel.insert(dog);

        Toast.makeText(this, Alert.SUCCESS, Toast.LENGTH_SHORT).show();

        finish();
    }
}
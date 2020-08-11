package fr.easydog.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fr.easydog.R;
import fr.easydog.activities.adapter.DogAdapter;
import fr.easydog.bo.Dog;
import fr.easydog.viewmodel.DogViewModel;

public class HomeActivity extends AppCompatActivity {

    private DogViewModel dogViewModel = null;

    private ListView listDog;

    private FloatingActionButton fb;

    List<Dog> dogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fb = findViewById(R.id.btn_add);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        listDog = findViewById(R.id.lv_my_dog);

        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);

        dogViewModel.getObserver().observe(this, new Observer<List<Dog>>() {
            @Override
            public void onChanged(List<Dog> dogs)
            {
                HomeActivity.this.dogs = dogs;
                listDog.setAdapter(new DogAdapter(HomeActivity.this,R.layout.dog_list_style, dogs));
            }
        });
    }
}
package fr.easydog.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.easydog.R;
import fr.easydog.bo.Dog;

public class DogAdapter extends ArrayAdapter<Dog> {

    public DogAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.dog_list_style, parent,false);
        }


        TextView textViewName = convertView.findViewById(R.id.tv_name);
        TextView textViewDescription = convertView.findViewById(R.id.tv_description);

        Dog dog = getItem(position);

        textViewName.setText(dog.getName());
        textViewDescription.setText(dog.getDescription());

        return convertView;
    }
}

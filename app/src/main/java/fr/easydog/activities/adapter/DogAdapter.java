package fr.easydog.activities.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.easydog.R;
import fr.easydog.activities.utils.Alert;
import fr.easydog.bo.Dog;

/**
 * DogAdapter class
 */
public class DogAdapter extends ArrayAdapter<Dog> {


    /**
     * Construc DogAdapter
     *
     * @param context  => context of app
     * @param resource => resource file
     * @param objects  => list of object
     */
    public DogAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    /**
     * Get view method from ArrayAdapter
     * @param position    => position
     * @param convertView => new view
     * @param parent      => parent view
     * @return View
     */
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
        final ImageView btLike = convertView.findViewById(R.id.bt_like);
        final ImageView btDislike = convertView.findViewById(R.id.bt_dislike);

        final Dog dog = getItem(position);

        textViewName.setText(dog.getName());
        textViewDescription.setText(dog.getDescription());

        btLike.setOnClickListener(new View.OnClickListener() {
            /**
             * Click on btn like
             * @param view => object view
             */
            @Override
            public void onClick(View view) {
                dog.setLiked(true);
                Log.i("INFO", "INFO : Dog is like");
                btLike.setVisibility(View.GONE);
                btDislike.setVisibility(View.GONE);
                btLike.setEnabled(false);
                btDislike.setEnabled(false);
                Toast.makeText(view.getContext(), Alert.LIKE, Toast.LENGTH_LONG).show();
            }
        });

        btDislike.setOnClickListener(new View.OnClickListener() {
            /**
             * click on dislike
             * @param view => view object
             */
            @Override
            public void onClick(View view) {
                dog.setLiked(false);
                Log.i("INFO", "Dog is like");
                btLike.setEnabled(false);
                btDislike.setEnabled(false);
                Toast.makeText(view.getContext(), Alert.DISLIKE, Toast.LENGTH_LONG).show();
            }
        });


        return convertView;
    }
}

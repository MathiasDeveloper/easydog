package fr.easydog.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.easydog.R;
import fr.easydog.bo.Race;

public class RaceAdapter extends ArrayAdapter<String> {


    public RaceAdapter(
            @NonNull Context context,
            int resource,
            @NonNull List<String> objects
    )
    {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.spinner_list_item, parent,false);
        }

        String race = getItem(position);

        TextView tvRace = convertView.findViewById(R.id.tv_spinner_race);

        tvRace.setText(race);

        return convertView;
    }
}

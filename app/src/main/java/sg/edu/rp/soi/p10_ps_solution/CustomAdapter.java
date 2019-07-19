package sg.edu.rp.soi.p10_ps_solution;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {


    Context parent_context;
    int layout_id;
    ArrayList<Movie> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tv1 = rowView.findViewById(R.id.textView);
        TextView tv2 = rowView.findViewById(R.id.textView2);
        ImageView iv1 = rowView.findViewById(R.id.imageView);

        // Obtain the Android Version information based on the position
        Movie currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tv1.setText(currentVersion.getTitle());
        tv2.setText(currentVersion.getYear() + "-" + currentVersion.getGenre());
        String check = currentVersion.getRated();
        if (check.equals("g")) {
            iv1.setImageResource(R.drawable.rating_g);
        }
        else if (check.equals("pg")) {
            iv1.setImageResource(R.drawable.rating_pg);
        }
        else if (check.equals("pg13")) {
            iv1.setImageResource(R.drawable.rating_pg13);
        }
        else if (check.equals("nc16")) {
            iv1.setImageResource(R.drawable.rating_nc16);
        }
        else if (check.equals("m18")) {
            iv1.setImageResource(R.drawable.rating_m18);
        }
        else if (check.equals("r21")) {
            iv1.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }



}

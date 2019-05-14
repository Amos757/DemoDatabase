package com.example.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter {

    // Create ArrayList of objects
    private ArrayList<Task> objects;
    // To hold the context object
    private Context context;
    // Create the UI objects to hold the UI elements in row layout
    private TextView tv1;

    public TaskAdapter(Context context, int resource,ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the ArrayList of objects passed to this adapter
        this.objects = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is called every time for every row
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,false);
        // Get the TextView object
        TextView tvid = rowView.findViewById(R.id.tvID);
        TextView tvdesc = rowView.findViewById(R.id.tvDesc);
        TextView tvdate = rowView.findViewById(R.id.tvDate);
        // Parameter "pos" is the index of the
        //  row ListView is requesting.
        //  We get back the object at the same index.
        Task object = objects.get(pos);

        // Set the TextView to show the object info
        tvid.setText(Integer.toString(object.getId()));
        tvdesc.setText(object.getDescription());
        tvdate.setText(object.getDate());

        // Return this row that is being populated.
        return rowView;
    }


}

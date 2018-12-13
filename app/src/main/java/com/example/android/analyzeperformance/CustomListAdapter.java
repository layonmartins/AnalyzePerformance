package com.example.android.analyzeperformance;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the
    private final List<Employee> employees;





    public CustomListAdapter(Activity context, List<Employee> employees, int layout){
        super(context, layout);

        this.context = context;
        this.employees = employees;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.linearlayout_row, null, true);

        //this code gets references to objects in the linearlayout_row.xml file
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewID);
        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView natlTextField = (TextView) rowView.findViewById(R.id.natlTextViewID);
        TextView ageTextField = (TextView) rowView.findViewById(R.id.ageTextViewID);
        TextView occTextField = (TextView) rowView.findViewById(R.id.occTextViewID);

        //this code sets the values of the objects to values from the arrays
        imageView.setImageResource(employees.get(position).getImage());
        nameTextField.setText(employees.get(position).getName());
        natlTextField.setText(employees.get(position).getNatl());
        ageTextField.setText(Integer.toString(employees.get(position).getAge()));
        occTextField.setText(employees.get(position).getOcc());

        return rowView;
    }
}

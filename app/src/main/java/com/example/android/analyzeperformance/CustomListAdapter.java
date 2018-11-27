package com.example.android.analyzeperformance;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the images
    private final Integer[] imageIDarray;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of nationality
    private final String[] natlArray;

    //to store the list of age
    private final Integer[] ageArray;

    //to store the list of occupation
    private final String[] occArray;

    public CustomListAdapter(Activity context, Integer[] imageIDarrayParam, String[] nameArrayParam,
                             String[] natlArrayParam,  Integer[] ageArrayParam, String[] occArrayParam){

        super(context, R.layout.linearlayout_row, nameArrayParam);

        this.context = context;
        this.imageIDarray = imageIDarrayParam;
        this.nameArray = nameArrayParam;
        this.natlArray = natlArrayParam;
        this.ageArray = ageArrayParam;
        this.occArray = occArrayParam;
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
        imageView.setImageResource(imageIDarray[position]);
        nameTextField.setText(nameArray[position]);
        natlTextField.setText(natlArray[position]);
        ageTextField.setText(Integer.toString(ageArray[position]));
        occTextField.setText(occArray[position]);

        return rowView;
    }
}

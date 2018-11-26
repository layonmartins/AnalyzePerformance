package com.example.android.analyzeperformance;

import android.app.Activity;
import android.widget.ArrayAdapter;

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

}

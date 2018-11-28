package com.example.android.analyzeperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class LinearLayout extends AppCompatActivity {

    Integer[] imageArray = {R.drawable.boy, R.drawable.women, R.drawable.girl};

    String[] nameArray = {"Employee one", "Employee two", "Employee three"};

    String[] natlArray = {"Brazilian", "American", "Chinese"};

    Integer[] ageArray = {22, 28, 35};

    String[] occArray = {"Analyst JR", "Analyst PL", "Analyst SR"};

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        CustomListAdapter myAdapter = new CustomListAdapter(this, imageArray, nameArray, natlArray, ageArray, occArray);

        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(myAdapter);
    }
}

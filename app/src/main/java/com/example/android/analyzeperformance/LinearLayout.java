package com.example.android.analyzeperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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

        List<Employee> employees = getEmployees();

        CustomListAdapter myAdapter = new CustomListAdapter(this, employees);

        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(myAdapter);
    }

    private List<Employee> getEmployees(){

        List<Employee> employees = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < 100000; i++) {
            if(j == 3){ j = 0; }
            Employee employee = new Employee();
            employee.setImage(imageArray[j]);
            employee.setName(nameArray[j]);
            employee.setNatl(natlArray[j]);
            employee.setAge(ageArray[j]);
            employee.setOcc(occArray[j]);
            employees.add(employee);
            j++;
        }

        return employees;
    }
}


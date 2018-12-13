package com.example.android.analyzeperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class LinearLayout extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Int layout
    //Linear = 0, Relative = 1, Constraint = 2
    int layout = 0;

    //Array info examples
    Integer[] imageArray = {R.drawable.boy, R.drawable.women, R.drawable.girl};
    String[] nameArray = {"Employee one", "Employee two", "Employee three"};
    String[] natlArray = {"Brazilian", "American", "Chinese"};
    Integer[] ageArray = {22, 28, 35};
    String[] occArray = {"Analyst JR", "Analyst PL", "Analyst SR"};
    ListView listView;

    //create a list of employees
    private List<Employee> getEmployees(int n){
        List<Employee> employees = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if(j > 2){ j = 0; }
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

    //Generate the list employees example, setAdapter and call the scrolldown method
    private void generateList(int layout){

        EditText editText = (EditText) findViewById(R.id.edtNumber);
        int n = Integer.parseInt(editText.getText().toString());
        List<Employee> employees = getEmployees(n);
        CustomListAdapter myAdapter = new CustomListAdapter(this, employees, getLayout(layout));
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(myAdapter);
        //call the scrolldown method
    }

    private int getLayout(int layout){
        int returnLayout = 0;
        switch (layout){
            case 0: returnLayout = R.layout.linearlayout_row;
            break;
            case 1: returnLayout = R.layout.linearlayout_row; //insert here the relativelayout_row
            break;
            case 2: returnLayout =  R.layout.linearlayout_row; //insert here the constraintlayout_row
            break;
        }
        return returnLayout;
    }

    //scrolldown the list until final
    private void scrolldown(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        //Config the spinner layout:
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.layouts_array, R.layout.my_spinner);
        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.my_spinner);
        //Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        final Button button = findViewById(R.id.btnScroll);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                generateList(layout);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        //An item was selected. You can retrieve the selected item using parent.getItemAtPosition(pos)
        layout = pos;

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){
        //Another interface callback
    }

}


package com.example.android.analyzeperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LinearLayout extends AppCompatActivity {

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
    private void generateList(){
        EditText editText = (EditText) findViewById(R.id.edtNumber);
        int n = Integer.parseInt(editText.getText().toString());
        List<Employee> employees = getEmployees(n);
        CustomListAdapter myAdapter = new CustomListAdapter(this, employees);
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(myAdapter);
        //call the scrolldown method

    }

    //scrolldown the list until final
    private void scrolldown(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        final Button button = findViewById(R.id.btnScroll);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                generateList();
            }
        });

    }

}


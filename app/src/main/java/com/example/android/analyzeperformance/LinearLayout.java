package com.example.android.analyzeperformance;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LinearLayout extends AppCompatActivity {

    //Int layout
    //Linear = 0, Relative = 1, Constraint = 2
    int layout_ID = 0;
    //number of employees in the list
    int n = 0;
    //EditText to the number of employees
    EditText editText;
    //adapter to generate list
    CustomListAdapter myAdapter;
    //start time
    long startTime = 0l;


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

    //Generate the list employees example, setAdapter
    private void generateList(int layout){

        editText = (EditText) findViewById(R.id.edtNumber);
        n = Integer.parseInt(editText.getText().toString());
        List<Employee> employees = getEmployees(n);
        myAdapter = new CustomListAdapter(this, employees, getLayout(layout));
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(myAdapter);
    }

    private int getLayout(int layout){
        int returnLayout = 0;
        switch (layout){
            case 0: returnLayout = R.layout.linearlayout_row;
            break;
            case 1: returnLayout = R.layout.relativelayout_row;
            break;
            case 2: returnLayout =  R.layout.linearlayout_row; //insert here the constraintlayout_row
            break;
        }
        return returnLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        //first called to generate a List
        generateList(layout_ID);

        //Config the spinner layout:
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.layouts_array, R.layout.my_spinner);
        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.my_spinner);
        //Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //When user selected the layout in spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //An item was selected. You can retrieve the selected item using parent.getItemAtPosition(pos)
                layout_ID = position;
                //generate list always user select the layout in spinner
                generateList(layout_ID);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        //generate list when user input the number of employees
        editText.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // Identifier of the action. This will be either the identifier you supplied,
                // or EditorInfo.IME_NULL if being called due to the enter key being pressed.
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    //generate list always user click in "done" in EditText number
                    generateList(layout_ID);
                    //return true; //if return true the event dies here and the keyboard does not close automatically
                }
                return false;
            }
        });

        //scroll down automatically
        final Button button = findViewById(R.id.btnScroll);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //save start time
                startTime = System.nanoTime();
                listView.smoothScrollToPosition(n);
            }
        });

        //Listening if the listView arrived at the last item:
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && (listView.getLastVisiblePosition() - listView.getHeaderViewsCount() -
                        listView.getFooterViewsCount()) >= (myAdapter.getCount() - 1)) {

                    // Now your listview has hit the bottom
                    //save end time
                    long endTime = System.nanoTime();
                    long totalTime = endTime - startTime;
                    double seconds = (double)totalTime / 1_000_000_000.00;
                    //show the totalTime
                    //create a toast msg
                    Context context = getApplicationContext();
                    CharSequence text = "Scroll finshed at: ";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text + Double.toString(seconds) + " s", duration);
                    toast.show();

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }


}


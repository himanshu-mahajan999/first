package com.it.himanshu.crudsqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.it.himanshu.crudsqllite.Adapter.EmployeeAdapter;
import com.it.himanshu.crudsqllite.DB.Dbhelper;
import com.it.himanshu.crudsqllite.Model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {
    List<Employee> employeeList;
    ListView listViewEmployees;
    EmployeeAdapter adapter;
    Dbhelper dbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        listViewEmployees = (ListView) findViewById(R.id.listViewEmployees);
        employeeList = new ArrayList<>();
        dbh = new Dbhelper(this);
        employeeList = dbh.getdata();
        showEmployeesFromDatabase();

    }

    public void refresh() {
        employeeList.clear();
        employeeList = dbh.getdata();
        adapter = new EmployeeAdapter(this, R.layout.list_layout_employee, employeeList);
        listViewEmployees.setAdapter(adapter);

    }

    private void showEmployeesFromDatabase() {

        adapter = new EmployeeAdapter(this, R.layout.list_layout_employee, employeeList);
        listViewEmployees.setAdapter(adapter);

    }

}




















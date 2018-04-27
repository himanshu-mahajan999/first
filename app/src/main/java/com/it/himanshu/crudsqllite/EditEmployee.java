package com.it.himanshu.crudsqllite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.it.himanshu.crudsqllite.DB.Dbhelper;

public class EditEmployee extends AppCompatActivity {

    EditText editTextName1,editTextSalary1;
    Button buttonUpdateEmployee;
    EmployeeActivity employeeActivity;
 //   String nameem="abc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        Intent intent=getIntent();
        final int id = intent.getIntExtra("Id",0);

        final String name=intent.getStringExtra("Name");

        Double salary=intent.getDoubleExtra("Salary",0.0d);

        editTextSalary1 =(EditText) findViewById(R.id.editTextSalary);
        editTextSalary1.setText(String.valueOf(salary));

        editTextName1 = (EditText) findViewById(R.id.editTextName);
        editTextName1.setText(name);


        buttonUpdateEmployee = (Button) findViewById(R.id.buttonUpdateEmployee);
        buttonUpdateEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String salaryem=editTextSalary1.getText().toString().trim();
                final String nameem=editTextName1.getText().toString().trim();
                Dbhelper dbhelper = new Dbhelper(EditEmployee.this);
                dbhelper.editDb( id,nameem ,salaryem);
                Toast.makeText(EditEmployee.this,id+" "+nameem+"  "+salaryem,Toast.LENGTH_SHORT).show();
                /*
                EmployeeActivity av = new EmployeeActivity();
                av.finish();*/
                Intent intent = new Intent(EditEmployee.this,EmployeeActivity.class);
                startActivity(intent);
            }
        });
    }
}

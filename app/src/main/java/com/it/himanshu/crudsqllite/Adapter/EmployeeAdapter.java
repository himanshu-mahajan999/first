package com.it.himanshu.crudsqllite.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.it.himanshu.crudsqllite.DB.Dbhelper;
import com.it.himanshu.crudsqllite.EditEmployee;
import com.it.himanshu.crudsqllite.Model.Employee;
import com.it.himanshu.crudsqllite.EmployeeActivity;
import com.it.himanshu.crudsqllite.R;

import java.util.List;

/**
 * Created by Himanshu on 16/01/2018.
 */

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    Context mCtx;
    int listLayoutRes;
    List<Employee> employeeList;
    Dbhelper dbh;

    public EmployeeAdapter(Context mCtx, int listLayoutRes, List<Employee> employeeList) {
        super(mCtx, listLayoutRes, employeeList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting employee of the specified position
        final Employee employee = employeeList.get(position);
        dbh = new Dbhelper(mCtx);


        //getting views
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewDept = view.findViewById(R.id.textViewDepartment);
        TextView textViewSalary = view.findViewById(R.id.textViewSalary);
        TextView textViewJoiningDate = view.findViewById(R.id.textViewJoiningDate);

        //adding data to views
        textViewName.setText(employee.getName());
        textViewDept.setText(employee.getDept());
        textViewSalary.setText(String.valueOf(employee.getSalary()));
        textViewJoiningDate.setText(employee.getJoiningDate());

        Log.e("dtals", employee.getName()+" "+employee.getDept()+" "+
                String.valueOf(employee.getSalary())+" "+employee.getJoiningDate());

        //we will use these buttons later for update and delete operation
        Button buttonDelete = view.findViewById(R.id.buttonDeleteEmployee);
        Button buttonEdit = view.findViewById(R.id.buttonEditEmployee);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(mCtx,"chhgh "+employee.getId() ,Toast.LENGTH_SHORT).show();
               dbh.delete(employee.getId());
                ((EmployeeActivity)mCtx).refresh();
               /* if(xz)
                {


                   EmployeeActivity employeeActivity=new EmployeeActivity();
                   employeeActivity.removeDb();

                }*/

            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Employee cc=employeeList.get(position);
                Intent intent =new Intent(mCtx,EditEmployee.class);
                intent.putExtra("Id",cc.getId());
                intent.putExtra("Name",cc.getName());
                Toast.makeText(mCtx,cc.getId()+"  ",Toast.LENGTH_SHORT).show();
                intent.putExtra("Salary",cc.getSalary());
                Toast.makeText(mCtx,String.valueOf(cc.getSalary()),Toast.LENGTH_SHORT).show();
                mCtx.startActivity(intent);
            }
        });
        return view;
    }


}


















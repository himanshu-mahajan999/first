package com.it.himanshu.crudsqllite.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.it.himanshu.crudsqllite.Model.Employee;
import com.it.himanshu.crudsqllite.R;

import java.util.List;

/**
 * Created by Himanshu on 19/01/2018.
 */

public class ListViewAdapter extends ArrayAdapter<Employee> {
    Context context;
    int resource;
    List<Employee> employeeList;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Employee> employeeList) {
        super(context, resource, employeeList);
        this.context = context;
        this.resource = resource;
        this.employeeList = employeeList;

    }


    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, null);


        final Employee employee = employeeList.get(position);

        LinearLayout linear=view.findViewById(R.id.linear);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewDept = view.findViewById(R.id.textViewDepartment);
        TextView textViewSalary = view.findViewById(R.id.textViewSalary);

        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        //adding data to views
        textViewName.setText(employee.getName());
        textViewDept.setText(employee.getDept());
        textViewSalary.setText(String.valueOf(employee.getSalary()));

        return view;
    }
}

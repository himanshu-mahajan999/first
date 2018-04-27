package com.it.himanshu.crudsqllite.Tab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.it.himanshu.crudsqllite.Adapter.ListViewAdapter;
import com.it.himanshu.crudsqllite.DB.Dbhelper;
import com.it.himanshu.crudsqllite.Model.Employee;
import com.it.himanshu.crudsqllite.R;


/**
 * Created by Himanshu on 24/01/2018.
 */

public class OneFragment extends Fragment {

    List<Employee> listItem;
    ListView listViewItem;
    ListViewAdapter adapter;
    Dbhelper dbh;

    public OneFragment() {

    }

    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        listViewItem = view.findViewById(R.id.listViewFrag);
        listItem= new  ArrayList<>();
        dbh = new Dbhelper(getActivity());
        listItem = dbh.getdata();

        adapter = new ListViewAdapter(getActivity(), R.layout.listview1, listItem);
        Toast.makeText(getActivity(),"hmansh",Toast.LENGTH_SHORT).show();

        listViewItem.setAdapter(adapter);

        return view;
    }

   /* @Override
    public void onStart() {
        super.onStart();

    }*/
}

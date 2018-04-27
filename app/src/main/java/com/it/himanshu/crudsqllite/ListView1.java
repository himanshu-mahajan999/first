package com.it.himanshu.crudsqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.it.himanshu.crudsqllite.Adapter.ListViewAdapter;
import com.it.himanshu.crudsqllite.DB.Dbhelper;
import com.it.himanshu.crudsqllite.Model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ListView1 extends AppCompatActivity {

    List<Employee> listItem;
    ListView listViewItem;
    ListViewAdapter adapter;
    Dbhelper dbh;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);



     /*   toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        // getSupportActionBar().setDisplayShowTitleEnabled(false);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //toolbar.setNavigationIcon(R.drawable.ic_launcher_foreground);
      /*  toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();

            }
        });*/


        listViewItem = (ListView) findViewById(R.id.listView1);
        listItem = new ArrayList<>();
        dbh = new Dbhelper(this);
        listItem = dbh.getdata();

        adapter = new ListViewAdapter(this, R.layout.listview1, listItem);
        listViewItem.setAdapter(adapter);
    }

}

package com.it.himanshu.crudsqllite;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.it.himanshu.crudsqllite.Tab.Tab;
import com.it.himanshu.crudsqllite.Volley.Volley;

public class Main2Activity extends AppCompatActivity  {

    Button listView,seekbar,chat,gcm,sensor,Map,FireBase1,message;
    Button sqlLite,navigation_view, recyclerView, listViewimage, volley,tabs,popUp,asy;
    Toolbar toolbar;
    TextView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       /* toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

  //   getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //toolbar.setNavigationIcon(R.drawable.ic_launcher_foreground);
       /* toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();

            }
        });*/

        message=(Button)findViewById(R.id.message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Message.class);
                startActivity(intent);
            }
        });


        FireBase1 = (Button)findViewById(R.id.FireBase1);
        FireBase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, FireBase1.class);
                startActivity(intent);
            }
        });


        Map=(Button)findViewById(R.id.Map);
        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        sensor=(Button)findViewById(R.id.sensor);
        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Sensor1.class);
                startActivity(intent);
            }
        });
        navigation_view = (Button)findViewById(R.id.navigation_view);
        navigation_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Navigation.class);
                startActivity(intent);
            }
        });

        gcm = (Button)findViewById(R.id.gcm);
        gcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Print.class);
                startActivity(intent);
            }
        });

        image=(TextView) findViewById(R.id.image);
        registerForContextMenu(image);

        chat=(Button)findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Chat.class);
                startActivity(intent);
            }
        });
        recyclerView = (Button) findViewById(R.id.recyclerView);
        sqlLite = (Button) findViewById(R.id.sqlLite);
        listView = (Button) findViewById(R.id.listView);
        listViewimage = (Button) findViewById(R.id.listViewimage);
        volley = (Button) findViewById(R.id.volley);
        tabs=(Button)findViewById(R.id.tab);
        popUp=(Button)findViewById(R.id.popUp);
        asy=(Button)findViewById(R.id.asy);
        seekbar=(Button)findViewById(R.id.seekbar);
        seekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, SeekBar.class);
                startActivity(intent);
            }
        });

        asy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Asyn.class);
                startActivity(intent);
            }
        });
        popUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(Main2Activity.this);
                dialog.setContentView(R.layout.dialog_layout);
                Button cancel =(Button)dialog.findViewById(R.id.cancel);
                Button ok =(Button)dialog.findViewById(R.id.ok);
       ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Main2Activity.this, Rating.class);
                        startActivity(intent);
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }

        });
        tabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Tab.class);
                startActivity(intent);
            }
        });
        volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Volley.class);
                startActivity(intent);
            }
        });
        sqlLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ListView1.class);
                startActivity(intent);
            }
        });
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, RecyclerView1.class);
                startActivity(intent);
            }
        });
        listViewimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ListViewImage.class);
                startActivity(intent);
            }
        });
    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tabs: {
                Intent intent = new Intent(Main2Activity.this, Tab.class);
                startActivity(intent);
                return true;
            }
            case R.id.sql:
            {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                return true;
            }

            case R.id.listView:
            {
                Intent intent = new Intent(Main2Activity.this, ListView1.class);
                startActivity(intent);
                return true;
            }

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
*/

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tab, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.tabs:
                // implement your code
                Toast.makeText(getApplicationContext(),"Setting clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.sql:
                // implement your code
                Toast.makeText(getApplicationContext(),"change background",Toast.LENGTH_LONG).show();
                return true;
            case R.id.listView:
                // implement your code
                Toast.makeText(getApplicationContext(),"Setting clicked",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

}

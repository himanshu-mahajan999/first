package com.it.himanshu.crudsqllite.Volley;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.it.himanshu.crudsqllite.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Volley extends AppCompatActivity {
    ProgressDialog loading;
    TextView mTextViewResult;
    private String UPLOAD_URL ="http://34.209.207.75/api/getaccepted_frnd_list.php?user_mob=5050505050";
    ListView listView;
    List<VollyModel> vollyModelList;
    VolleyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        mTextViewResult = findViewById(R.id.text_view_result);

        Button buttonParse = findViewById(R.id.button_parse);

        listView=(ListView)findViewById(R.id.ListView);


        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private void getData(){

        loading = ProgressDialog.show(this,"...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        parse(s);

                       Toast.makeText(Volley.this, s , Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        loading.dismiss();

                        Toast.makeText(Volley.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }
    public void parse(String json){


        try{

            JSONObject response = new JSONObject(json);

            JSONArray jsonArray = response.getJSONArray("friend_list");

            vollyModelList= new  ArrayList<>();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject employee = jsonArray.getJSONObject(i);
                        //VollyModel = (List<com.example.himanshu.crudsqllite.Volley.VollyModel>) employee;
                        String user_phone = employee.getString("user_phone");
                        String user_email = employee.getString("user_email");
                        String user_name = employee.getString("user_name");

                        VollyModel vollyModel = new VollyModel(user_phone,user_email,user_name);

                       vollyModelList.add(vollyModel);
                    }
            adapter = new VolleyAdapter(this, R.layout.volley_row, vollyModelList);
            listView.setAdapter((ListAdapter) adapter);
            //VollyModel.add(employee);
            loading.dismiss();
                }
                catch (JSONException e)
                {
            Toast.makeText(Volley.this, "error", Toast.LENGTH_LONG).show();
            loading.dismiss();
        }
    }
}
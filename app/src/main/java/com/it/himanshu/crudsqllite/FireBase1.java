package com.it.himanshu.crudsqllite;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FireBase1 extends AppCompatActivity  {

    EditText email,pass ;
    Button buttonAdd;
    ProgressDialog progressDialog;
    private String email1,pass1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base1);

       // FirebaseApp.initializeApp(this);
        progressDialog = new ProgressDialog(this);
       firebaseAuth = FirebaseAuth.getInstance();
      //  FirebaseInstanceId.getInstance();

       // FireBaseD


        pass=(EditText)findViewById(R.id.pass);
        email = (EditText)findViewById(R.id.email);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);


        Log.v("nam1",email1+pass1);



        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Toast.makeText(FireBase1.this,"nam"+email1+pass1,Toast.LENGTH_SHORT).show();
                Log.v("nam",email1+pass1);
               method();


            }
        });

    }

    private void method()
    {
        Log.v("nam2",email1+pass1);

        email1 = email.getText().toString().trim();
        pass1 = pass.getText().toString().trim();
        if (TextUtils.isEmpty(email1)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pass1)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass1.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }


        progressDialog.setMessage("Process....");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email1,pass1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(FireBase1.this,"Successful",Toast.LENGTH_SHORT).show();
                          //  progressDialog.setVisibility(View.GONE);;
                            progressDialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(FireBase1.this,"not Successful",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });
    }
}

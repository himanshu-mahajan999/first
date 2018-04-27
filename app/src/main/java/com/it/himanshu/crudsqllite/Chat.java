package com.it.himanshu.crudsqllite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.it.himanshu.crudsqllite.DB.Dbhelper;

public class Chat extends AppCompatActivity {
    EditText editText1, editText2;
    Button button1, button2;

    Dbhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //addChat();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chat.this, Chat2.class);
                startActivity(intent);
            }
        });
    }

   /* private void addChat() {
        String one = editText1.getText().toString();
        String two = editText2.getText().toString();

        boolean b = inputsAreCorrect(one, two);

        if (b) {
            dbhelper = new Dbhelper(this);


            boolean b1 = dbhelper.chat(one, two);

            Toast.makeText(this, "" + b1, Toast.LENGTH_SHORT).show();


            Toast.makeText(this, "chat Added Successfully", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean inputsAreCorrect(String one, String two) {
        if (one.isEmpty()) {
            editText1.setError("Please enter a text");
            editText1.requestFocus();
            return false;
        }

        if (two.isEmpty()) {
            editText2.setError("Please enter a text");
            editText2.requestFocus();
            return false;
        }
        return true;
    }
*/
}
















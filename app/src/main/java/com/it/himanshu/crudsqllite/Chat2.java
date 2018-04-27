package com.it.himanshu.crudsqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.it.himanshu.crudsqllite.Adapter.ChatAdapter;
import com.it.himanshu.crudsqllite.DB.Dbhelper;
import com.it.himanshu.crudsqllite.Model.ChatM;

import java.util.ArrayList;
import java.util.List;

public class Chat2 extends AppCompatActivity {

    List<ChatM> chatList;
    ListView listViewChat;
    ChatAdapter adapter;
    Dbhelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);

        listViewChat = (ListView)findViewById(R.id.listViewChat);
        chatList = new ArrayList<>();
       // dbh = new Dbhelper(this);
        //chatList = dbh.getChat();
        // Toast.makeText(this,String.valueOf(chatList.size()) ,Toast.LENGTH_LONG).show();
       chatList.add(new ChatM(1,"hkkkkk",1));
        chatList.add(new ChatM(2,"hkkkkk",0));
        chatList.add(new ChatM(3,"dcsdvsdv",1));
        chatList.add(new ChatM(4,"dcsdvsdv",0));
        chatList.add(new ChatM(5,"dcsdvsdv",1));
        chatList.add(new ChatM(6,"dcsdvsdv",0));

        adapter = new ChatAdapter(this, R.layout.chat1,R.layout.chat2, chatList);
        listViewChat.setAdapter(adapter);

    }



}

package com.it.himanshu.crudsqllite.Adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.it.himanshu.crudsqllite.DB.Dbhelper;
import com.it.himanshu.crudsqllite.Model.ChatM;
import com.it.himanshu.crudsqllite.R;

import java.util.List;

/**
 * Created by Himanshu on 02/02/2018.
 */
public class ChatAdapter extends ArrayAdapter<ChatM> {
    Context mCtx;
    int chat1;
    int chat21;
    List<ChatM> chatList;
    Dbhelper dbh;
    public ChatAdapter(Context mCtx, int chat1, int chat21, List<ChatM> chatList) {
        super(mCtx,chat1,chat21,chatList);
        this.mCtx = mCtx;
        this.chat1 = chat1;
        this.chat21 = chat21;
        this.chatList = chatList;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        final ChatM chatM =chatList.get(position);
        //dbh = new Dbhelper(mCtx);
        View view = null;
        chatM.getFlag1();
        if(chatM.getFlag1()==0)
        {
            view = inflater.inflate(chat1, null);
          //  boolean b=dbh.CheckDatabase(getContext());
           // Toast.makeText(getContext(), "CheckDatabase"+b, Toast.LENGTH_SHORT).show();
            TextView chat1 = view.findViewById(R.id.chat1);
            chat1.setText(chatM.getChat1());

            return view;
        }
        else
        {
            view = inflater.inflate(chat21, null);
            TextView chat2 = view.findViewById(R.id.chat2);
           chat2.setText(chatM.getChat1());

            return view;
        }
    }
}



















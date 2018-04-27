package com.it.himanshu.crudsqllite.Volley;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.it.himanshu.crudsqllite.R;

import java.util.List;

/**
 * Created by Himanshu on 23/01/2018.
 */

public class VolleyAdapter extends ArrayAdapter<VollyModel>
{
    Context context;
    int volley_row;
    List<VollyModel> listItem;

    public VolleyAdapter(Context context, int volley_row, List<VollyModel> listItem)
    {
        super(context,volley_row, listItem);
        this.context = context;
        this.volley_row = volley_row;
        this.listItem = listItem;
    }

    public View getView(final int position,  View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(volley_row, null);

        VollyModel vollyModel = listItem.get(position);

        TextView user_name=view.findViewById(R.id.user_name);
        TextView user_no=view.findViewById(R.id.user_no);
        TextView user_email=view.findViewById(R.id.user_email);

        user_name.setText(vollyModel.getUser_name());

        user_no.setText(vollyModel.getUser_phone());
        user_email.setText(vollyModel.getUser_email());
        return view;
    }
}

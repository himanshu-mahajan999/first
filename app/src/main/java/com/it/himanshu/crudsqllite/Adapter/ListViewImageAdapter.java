package com.it.himanshu.crudsqllite.Adapter;
import com.it.himanshu.crudsqllite.R;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.himanshu.crudsqllite.Model.Product;

import java.util.List;

/**
 * Created by Himanshu on 23/01/2018.
 */

public class ListViewImageAdapter extends ArrayAdapter<Product>
{
    Context context;
    int resource;
    List<Product> ProductList;

    public ListViewImageAdapter(Context context, int resource, List<Product> ProductList) {
        super(context, resource,ProductList);
        this.context = context;
        this.resource = resource;
        this.ProductList = ProductList;
    }

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, null);

        Product product = ProductList.get(position);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView textViewShortDesc = view.findViewById(R.id.textViewShortDesc);
        TextView textViewRating = view.findViewById(R.id.textViewRating);
        TextView textViewPrice = view.findViewById(R.id.textViewPrice);


        textViewTitle.setText(product.getTitle());
        textViewShortDesc.setText(product.getShortdesc());
        textViewRating.setText(String.valueOf(product.getRating()));
        textViewPrice.setText(String.valueOf(product.getPrice()));
        imageView.setImageDrawable(context.getResources().getDrawable(product.getImage()));

        return view;
    }
}














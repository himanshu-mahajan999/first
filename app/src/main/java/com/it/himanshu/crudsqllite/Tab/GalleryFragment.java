package com.it.himanshu.crudsqllite.Tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.it.himanshu.crudsqllite.R;


public class GalleryFragment extends android.support.v4.app.Fragment {
    public GalleryFragment() {
        // Required empty public constructor
    }

    public static GalleryFragment newInstance() {
       GalleryFragment fragment = new GalleryFragment();

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }
}

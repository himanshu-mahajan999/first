package com.it.himanshu.crudsqllite.Tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.himanshu.crudsqllite.R;

/**
 * Created by Himanshu on 24/01/2018.
 */

public class ThreeFragment extends android.support.v4.app.Fragment {


    public ThreeFragment() {
        // Required empty public constructor
    }

    public static ThreeFragment newInstance() {
        ThreeFragment fragment = new ThreeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

}


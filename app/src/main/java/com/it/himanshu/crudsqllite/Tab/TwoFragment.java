package com.it.himanshu.crudsqllite.Tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.himanshu.crudsqllite.R;

/**
 * Created by Himanshu on 24/01/2018.
 */

public class TwoFragment extends android.support.v4.app.Fragment {



    public TwoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TwoFragment newInstance() {
        TwoFragment fragment = new TwoFragment();

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
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

}
package com.example.ideabytes.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewMain extends AppCompatActivity {
RecyclerView mrecycler;
RecyclerSample mAdapter;
ArrayList mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);

        mrecycler= findViewById(R.id.recycler);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
         RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        mrecycler.setLayoutManager(mLayoutManager);
    setData();

        mAdapter= new RecyclerSample(this,mlist);
        mrecycler.setAdapter(mAdapter);

    }

    private void setData() {
        mlist = new ArrayList();
        for(int i =1;i<20;i++) {

            mlist.add( i + ": Anand " );

        }

    }
}

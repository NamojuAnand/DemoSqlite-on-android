package com.example.ideabytes.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerSample  extends RecyclerView.Adapter<RecyclerSample.checkHolder> {
ArrayList mdata=null;
    Context mContext=null;

    public RecyclerSample(Context mContext, ArrayList mdata) {
        this.mdata = mdata;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public checkHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_list_row, viewGroup, false);

        return new checkHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull checkHolder checkHolder, int i) {

        checkHolder.mtext.setText(mdata.get(i).toString());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class checkHolder extends RecyclerView.ViewHolder{
        TextView mtext=null;
    public checkHolder(@NonNull View itemView) {
        super(itemView);
        mtext= itemView.findViewById(R.id.showtext);
    }
}


}

package com.cherry_burst.anbayasiroulette;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by maeshunsuke on 2015/08/30.
 */
public class AnbayasiViewHolder extends RecyclerView.ViewHolder {

    View base;
    TextView textViewNumber;
    TextView textViewComment;

    public AnbayasiViewHolder(View itemView) {
        super(itemView);
        this.base = itemView;
        this.textViewNumber = (TextView)itemView.findViewById(R.id.number);
        this.textViewComment = (TextView)itemView.findViewById(R.id.comment);
    }
}

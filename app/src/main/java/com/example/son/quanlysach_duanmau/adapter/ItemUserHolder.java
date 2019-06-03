package com.example.son.quanlysach_duanmau.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.son.quanlysach_duanmau.R;

class ItemUserHolder extends RecyclerView.ViewHolder {
    ImageView ivIcon;
    TextView tvName;
    TextView tvPhone;
    ImageView ivDelete;

    public ItemUserHolder(@NonNull View itemView) {
        super(itemView);
        ivIcon=itemView.findViewById(R.id.ivIcon);
        tvName=itemView.findViewById(R.id.tvName);
        tvPhone=itemView.findViewById(R.id.tvPhone);
        ivDelete=itemView.findViewById(R.id.ivDelete);

    }
}

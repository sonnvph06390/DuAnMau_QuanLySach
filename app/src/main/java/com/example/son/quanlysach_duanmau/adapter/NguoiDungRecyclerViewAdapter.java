package com.example.son.quanlysach_duanmau.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.son.quanlysach_duanmau.ListNguoiDungActivity;
import com.example.son.quanlysach_duanmau.NguoiDungActivity;
import com.example.son.quanlysach_duanmau.R;
import com.example.son.quanlysach_duanmau.dao.NguoiDungDao;
import com.example.son.quanlysach_duanmau.model.NguoiDung;

import java.util.List;

public class NguoiDungRecyclerViewAdapter extends RecyclerView.Adapter<ItemUserHolder> {
    private Context context;
    private List<NguoiDung> nguoiDungList;
    NguoiDungDao nguoiDungDao;

    public NguoiDungRecyclerViewAdapter(Context context, List<NguoiDung> nguoiDungList) {
        this.context = context;
        this.nguoiDungList = nguoiDungList;
        nguoiDungDao=new NguoiDungDao(context);
    }

    @NonNull
    @Override
    public ItemUserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nguoi_dung, viewGroup, false);
        return new ItemUserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemUserHolder itemUserHolder, final int i) {
        NguoiDung nguoiDung = nguoiDungList.get(i);
        itemUserHolder.tvName.setText(nguoiDung.getUserName());
        itemUserHolder.tvPhone.setText(nguoiDung.getPhone());
        itemUserHolder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDung nguoiDung=nguoiDungList.get(i);
                nguoiDungList.remove(nguoiDung);
                nguoiDungDao.deleteNguoiDung(nguoiDung.getUserName());
                notifyDataSetChanged();
            }
        });
        itemUserHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDung nguoiDung1 = nguoiDungList.get(i);
                Intent intent = new Intent(context, NguoiDungActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("username",nguoiDung1.getUserName());
                bundle.putString("password",nguoiDung1.getPassWord());
                bundle.putString("phone",nguoiDung1.getPhone());
                bundle.putString("hoten",nguoiDung1.getFullName());
                intent.putExtra("bun", bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nguoiDungList.size();
    }
}

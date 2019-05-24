package com.example.son.quanlysach_duanmau.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.son.quanlysach_duanmau.R;
import com.example.son.quanlysach_duanmau.dao.NguoiDungDao;
import com.example.son.quanlysach_duanmau.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    public Activity context;
    public List<NguoiDung> arrNguoiDung;
    public LayoutInflater inflater;
    NguoiDungDao nguoiDungDao;

    public NguoiDungAdapter(Activity context, List<NguoiDung> arrNguoiDung) {
        super();
        this.context = context;
        this.arrNguoiDung = arrNguoiDung;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDao = new NguoiDungDao(context);

    }

    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int i) {
        return arrNguoiDung.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_nguoi_dung, null);
            holder.img = view.findViewById(R.id.ivIcon);
            holder.txtName = view.findViewById(R.id.tvName);
            holder.txtPhone = view.findViewById(R.id.tvPhone);
            holder.imgDelete = view.findViewById(R.id.ivDelete);

            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        NguoiDung _entry = arrNguoiDung.get(i);
        if (i % 3 == 0) {
            holder.img.setImageResource(R.drawable.emone);
        } else if (i % 3 == 1) {
            holder.img.setImageResource(R.drawable.emtwo);
        } else {
            holder.img.setImageResource(R.drawable.emthree);
        }
        holder.txtName.setText(_entry.getUserName());
        holder.txtPhone.setText(_entry.getPhone());
        notifyDataSetChanged();
        return view;
    }

    public static class ViewHolder {
        public ImageView img;
        public TextView txtName;
        public TextView txtPhone;
        public ImageView imgDelete;
    }
}

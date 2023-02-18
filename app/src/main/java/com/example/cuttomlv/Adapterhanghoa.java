package com.example.cuttomlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapterhanghoa extends BaseAdapter {
    Context context;
    int layout;
    List<Hanghoa> Listhanghoa;

    public Adapterhanghoa(Context context, int layout, List<Hanghoa> nuocList) {
        this.context = context;
        this.layout = layout;
        this.Listhanghoa = nuocList;
    }

    @Override
    public int getCount() {
        return Listhanghoa.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout,null);
//        anh xa
        TextView tenhang= convertView.findViewById(R.id.tenhang);
        TextView dongia= convertView.findViewById(R.id.dongia);
        TextView soluong=convertView.findViewById(R.id.soluong);
        ImageView imageAnh= convertView.findViewById(R.id.imgAnh);
//gan gia tri
        tenhang.setText(Listhanghoa.get(position).Tenhanghoa);
        dongia.setText(Listhanghoa.get(position).dongia);
        soluong.setText(Listhanghoa.get(position).soluong);
        imageAnh.setImageResource(Listhanghoa.get(position).imgnuoc);
        return convertView;
    }
}

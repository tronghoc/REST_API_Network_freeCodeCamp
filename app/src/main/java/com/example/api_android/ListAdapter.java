package com.example.api_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends ArrayAdapter<SanPham>{
    public ListAdapter (Context context, int textViewResourceId){
        super(context,textViewResourceId);
    }
    public ListAdapter(Context context, int resource, List<SanPham> items){
        super(context,resource,items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View v = convertView;
       if(v ==null){
           LayoutInflater vi;
           vi = LayoutInflater.from(getContext());
           v = vi.inflate(R.layout.dong_san_pham, null);

       }
       SanPham p = getItem(position);
       if(p !=null){
           TextView tt1 = (TextView) v.findViewById(R.id.textHoTen);
           tt1.setText(p.HoTen);
           TextView tt2 = (TextView) v.findViewById(R.id.textGia);
           tt2.setText(String.valueOf(p.Gia));
           ImageView imgv = (ImageView) v.findViewById(R.id.imageView);
           Picasso.with(getContext()).load(p.Hinh).resize(50, 50).
                   centerCrop().into(imgv);
       }
        return v;
    }

}

package com.example.test.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.test.R;

import java.util.ArrayList;

/**
 * Created by 邹洪学 on 2017/5/29.
 */

public class CarsAdapter extends BaseAdapter {
    private ArrayList<Cars> arrayList;
    private Context context;

    public CarsAdapter(ArrayList<Cars> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public CarsAdapter() {
    }

    @Override

    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cars c = arrayList.get(position);
        View grid = LayoutInflater.from(context).inflate(R.layout.grid_item,null);
        ImageView imageView = (ImageView) grid.findViewById(R.id.image);
        TextView textView = (TextView) grid.findViewById(R.id.text);
        textView.setText(c.getName());
        Glide.with(context).load(c.getLogo())
                .error(R.drawable.img6)
                .crossFade()
                .into(imageView);
        return grid;
    }
}

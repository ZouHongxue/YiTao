package com.example.test.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.test.FourthFragment;
import com.example.test.R;

import java.util.ArrayList;

/**
 * Created by 邹洪学 on 2017/5/22.
 */

public class NewsAdapter extends BaseAdapter{

    private ArrayList<news> arrayList;
    private Context context;

    public NewsAdapter(ArrayList<news> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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
        news n = arrayList.get(position);
        View item = LayoutInflater.from(context).inflate(R.layout.list_item_luntan,null);
        ImageView img = (ImageView) item.findViewById(R.id.news_pic);
        TextView title = (TextView) item.findViewById(R.id.news_title);
        TextView time = (TextView) item.findViewById(R.id.news_time);
        title.setText(n.getTitle());
        time.setText(n.getCtime());

        //所有图片都换
        //img.setImageResource(R.mipmap.xr);
        Glide.with(context).load(n.getPicUrl())//图片下载地址
                .error(R.drawable.img5)//默认
                .crossFade()//动态效果
                .into(img);//加载到img
        return item;
    }
}

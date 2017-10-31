package com.example.test;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 邹洪学 on 2017/5/17.
 */

public class ThirdFragment extends Fragment{

    private GridView gridView;
    private List<Map<String,Object>> data_list;
    private SimpleAdapter simAadapter;

    private int icon[] ={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};
    private String iconName[]={"图片一","图片一","图片一","图片一","图片一","图片一","图片一","图片一","图片一"};
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.fg3,container,false);

        gridView = (GridView) view.findViewById(R.id.gridview3);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        simAadapter = new SimpleAdapter(this.getContext(), data_list, R.layout.grid_item, from, to);
        //配置适配器
        gridView.setAdapter(simAadapter);

        return view;
    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", "图片"+String.valueOf(i));
            data_list.add(map);
        }

        return data_list;
    }
}

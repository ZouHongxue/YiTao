package com.example.test;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 邹洪学 on 2017/5/17.
 */

public class SecondFragment extends Fragment{

    private ListView listView;
    private SimpleAdapter simAdapter;
    private ArrayList <Map<String,Object>> arr_data;
    private int icon[] ={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.fg2,container,false);
        listView = (ListView) view.findViewById(R.id.list);
        arr_data = new ArrayList<Map<String, Object>>();
        for (int i =0; i <9 ;i++){
            Map map = new HashMap<String,Object>();
            map.put("pic",icon[i]);
            map.put("text","数据"+i);
            arr_data.add(map);
        }
        String[] from = { "pic", "text" };
        int[] to = { R.id.pic, R.id.text };
        simAdapter = new SimpleAdapter(this.getContext(), arr_data, R.layout.list_item,from,to);
        listView.setAdapter(simAdapter);

        return listView;
    }




}

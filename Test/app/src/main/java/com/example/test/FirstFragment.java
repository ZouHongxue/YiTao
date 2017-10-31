package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.data.Cars;
import com.example.test.data.CarsAdapter;
import com.example.test.details.CarsDetail;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 邹洪学 on 2017/5/17.
 */

public class FirstFragment extends Fragment implements AdapterView.OnItemClickListener{

    private GridView gridView;
    private CarsAdapter carsAdapter;
    private ArrayList<Cars> data;

//    private int icon[] ={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};
//    private String iconName[]={"图片一","图片一","图片一","图片一","图片一","图片一","图片一","图片一","图片一"};
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.fg1,container,false);

        gridView = (GridView) view.findViewById(R.id.gridview1);
//        //新建List
//        data_list = new ArrayList<Map<String, Object>>();
//        //获取数据
//        getData();
//        //新建适配器
//        String [] from ={"image","text"};
//        int [] to = {R.id.image,R.id.text};
//        simAadapter = new SimpleAdapter(this.getContext(), data_list, R.layout.grid_item, from, to);
//        //配置适配器
//        gridView.setAdapter(simAadapter);

        data = new ArrayList<>();
        loadCarsData();
        carsAdapter = new CarsAdapter(data,this.getContext());
        gridView.setAdapter(carsAdapter);
        gridView.setOnItemClickListener(this);
        return view;
    }

    private void loadCarsData() {
        //极速数据
        final Gson gson = new Gson();
          final String APPKEY = "4d5743c04b87acae";// 你的appkey
          final String URL = "http://api.jisuapi.com/car/brand";
        final String url = URL +"?appkey="+APPKEY;
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {//获取成功
                Log.d("tag", s);
                JsonParser j = new JsonParser();//json转换类
                JsonObject jsonObject = j.parse(s).getAsJsonObject();//将json数据转换为json对象
                String msg = jsonObject.get("msg").getAsString();//获取信息
                if(msg.equals("ok")){
                    JsonArray jsonArray = jsonObject.get("result").getAsJsonArray();
                    //将Json数据转为Json集合
                    ArrayList<Cars> arrayList = gson.fromJson(jsonArray,new
                            TypeToken<ArrayList<Cars>>() {}.getType());
                    data.clear();
                    data.addAll(arrayList);
                    carsAdapter.notifyDataSetChanged();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {//获取失败

            }
        });
        requestQueue.add(stringRequest);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cars c = (Cars) parent.getAdapter().getItem(position);
        String s = c.getId();
        Intent intent = new Intent();
        intent.setClass(getActivity(), CarsDetail.class);
        intent.putExtra("id",s);
        startActivity(intent);
    }

//    public List<Map<String, Object>> getData(){
//        //cion和iconName的长度是相同的，这里任选其一都可以
//        for(int i=0;i<icon.length;i++){
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("image", icon[i]);
//            map.put("text", "图片"+String.valueOf(i));
//            data_list.add(map);
//        }
//
//        return data_list;
//    }


}

package com.example.test;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.data.NewsAdapter;
import com.example.test.data.news;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by 邹洪学 on 2017/5/17.
 */

public class FourthFragment extends Fragment implements AdapterView.OnItemClickListener ,
        PullToRefreshBase.OnRefreshListener {

    private PullToRefreshListView listView;
    private int icon[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};
    private news news1;
    private NewsAdapter newsAdapter;
    private ArrayList<news> data;
    private Gson gson;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg4, container, false);
        listView = (PullToRefreshListView) view.findViewById(R.id.list4);
        loadNewsData();
        data = new ArrayList<>();
        newsAdapter = new NewsAdapter(data, this.getContext());
        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(this);
        return listView;
    }


    public void loadNewsData() {
        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        gson = new Gson();
        String url = "https://api.tianapi.com/social/?key=f9d83cf391a6634cc2fd46ddf0541904&num=10";

        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Log.d("tag",s);
                        JsonParser jsonParser = new JsonParser();
                        JsonObject jsonObject = jsonParser.parse(s).getAsJsonObject();
                        int code = jsonObject.get("code").getAsInt();
                        if (code == 200) {
                           // System.out.println("成功取出信息");
                            JsonArray jsonArray = jsonObject.get("newslist").getAsJsonArray();
                            //将Json数据转换成news集合
                            ArrayList<news> aNews = gson.fromJson(jsonArray, new TypeToken<ArrayList<news>>() {
                            }.getType());
                            data.clear();
                            data.addAll(aNews);

                            newsAdapter.notifyDataSetChanged();
                        }
                        listView.onRefreshComplete();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("tag", volleyError.getMessage());
                listView.onRefreshComplete();
            }
        });

        queue.add(request);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        news n = (news) parent.getAdapter().getItem(position);
        Intent intent;
        intent = new Intent(getActivity(), NewsDetail.class);
        intent.putExtra("url", n.getUrl());
        startActivity(intent);
    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {
        loadNewsData();
    }
}
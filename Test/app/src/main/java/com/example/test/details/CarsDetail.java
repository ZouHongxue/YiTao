package com.example.test.details;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.test.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class CarsDetail extends Activity {
    private TextView name ;
    private TextView price;
    private TextView sizeType;
    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_detail);
        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price);
        sizeType = (TextView) findViewById(R.id.sizeType);
        logo = (ImageView) findViewById(R.id.car_img);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        //System.out.println("IDIDIDIDID"+id);
        loadCarsDetail(id);


    }

    private void loadCarsDetail(String id) {
        final Gson gson = new Gson();
        String appkey = "4d5743c04b87acae";
        String url = "http://api.jisuapi.com/car/detail?appkey="+appkey+"&carid="+id;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d("tag:",s);
                JsonParser jp = new JsonParser();
                JsonObject jsonObject = jp.parse(s).getAsJsonObject();
                String msg = jsonObject.get("msg").getAsString();
                if(msg.equals("ok")){
                    JsonObject jsonObj = jsonObject.get("result").getAsJsonObject();
                    name.setText(jsonObj.get("name").getAsString());
                    price.setText(jsonObj.get("price").getAsString());
                    sizeType.setText(jsonObj.get("sizetype").getAsString());
                    Glide.with(getBaseContext()).load(jsonObj.get("logo").getAsString())
                            .error(R.drawable.img2)
                            .crossFade()
                            .into(logo);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(sr);
    }
}

package com.example.urja.tollproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Urja on 06-01-2018.
 */

public class History extends AppCompatActivity
{

    String KEY_REG_ID="regId";
    ListView listView;
    private static HistoryCustomAdapter adapter;
    ArrayList<HistoryDataModel> dataModels;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_layout);
        listView=(ListView)findViewById(R.id.listview);
        Intent i = getIntent();
        dataModels=new ArrayList<>();
        final String regId = i.getStringExtra("RegId");
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<HistoryDetails> details=db.getAllHistory();
        for(HistoryDetails hd:details)
            dataModels.add(new HistoryDataModel(hd.get_date(),hd.get_TOLL_ID(),""+hd.get_rate()));
        adapter= new HistoryCustomAdapter(dataModels,getApplicationContext());
        listView.setAdapter(adapter);

    }

    }





package com.example.urja.tollproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Urja on 05-01-2018.
 */

public class TollActivity extends AppCompatActivity
{

    String URL = "https://tollcollectionsystem.000webhostapp.com/toll1/history.php";
    String KEY_REG_ID="regId";
    String KEY_DATE="date";
    Button pay,history;
    TextView tv;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toll_layout);
        Intent i=getIntent();
        final String regId = i.getStringExtra("RegId");
        pay=(Button)findViewById(R.id.payButton);
        CustomRequest jsObjRequest = new CustomRequest(Request.Method.POST, URL, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                String resultResponse = new String(response.data);
                try {
                    JSONArray jsonArray = new JSONArray(resultResponse);
                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                    Log.i("tag",""+jsonArray.length());
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        db.addHistory(new HistoryDetails(i + 1, jsonObject.getString("tollid"), Double.parseDouble(jsonObject.getString("rate")), "N", jsonObject.getString("date")));
                        if(i == jsonArray.length()-1)
                        {
                            SharedPreferences sp=getApplicationContext().getSharedPreferences("history",0);
                            SharedPreferences.Editor editor=sp.edit();
                            editor.putString("date",jsonObject.getString("date"));
                            editor.commit();

                        }
                    }
                    List<HistoryDetails> details=db.getAllBills();
                    double bill=0;
                    for(HistoryDetails hd:details)
                    {
                       bill+=hd.get_rate();
                    }
                    Log.d("tag",""+bill);
                    tv=(TextView)findViewById(R.id.bill);
                    tv.setText(""+bill);

                }
                catch (JSONException e) {
                        e.printStackTrace();
                    }
                catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }

            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put(KEY_REG_ID, regId);
                    SharedPreferences sp=getApplicationContext().getSharedPreferences("history",MODE_PRIVATE);
                    String date=sp.getString("date","2000-01-04 00:00:00");
                    Log.d("Date",date);
                    params.put(KEY_DATE,date);
                    return  params;
                }
            };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
        history=(Button)findViewById(R.id.historyButton);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i1 = new Intent(TollActivity.this, History.class);
                startActivity(i1);
            }});
        pay=(Button)findViewById(R.id.payButton);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                tv.setText("0");
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.updateHistory();


            }
        });

    }
}

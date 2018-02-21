package com.example.urja.tollproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String URL = "https://tollcollectionsystem.000webhostapp.com/toll1/login.php";
    EditText et1,et2;
    String uname,pwd;
    String KEY_USER_NAME="uname";
    String KEY_PASSWORD="password";
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag1","Hello World");
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                et1=(EditText)findViewById(R.id.editText);
                et2=(EditText)findViewById(R.id.editText2);
                uname=et1.getText().toString();
                pwd=et2.getText().toString();
                CustomRequest jsObjRequest = new CustomRequest(Request.Method.POST, URL, new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response)
                    {
                        String resultResponse = new String(response.data);
                        try
                        {
                            JSONObject result=new JSONObject(resultResponse);
                           // JSONObject data=result.getJSONObject("item");
                           String status=result.getString("status");
                            Log.d("tag",status);
                            if(status.equals("1"))
                            {
                                Intent i=new Intent(MainActivity.this,TollActivity.class);
                                i.putExtra("RegId",uname);
                                startActivity(i);
                            }
                        }
                        catch (JSONException e)
                        {
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
                        params.put(KEY_USER_NAME, uname);
                        params.put(KEY_PASSWORD, pwd);
                        return  params;
                    }
                };
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
            }
        });


    }
}
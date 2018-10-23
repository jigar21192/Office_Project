package com.example.sparks.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Joke extends AppCompatActivity {
    String joke_url="https://ahmedabaddeed.co.in/app/jokes.php";
    TextView joketxt;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        joketxt=(TextView)findViewById(R.id.joke);
        pd=new ProgressDialog(this);
        pd.setMessage("Loading");
        pd.show();
        StringRequest request=new StringRequest(Request.Method.GET, joke_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array =new JSONArray(response);
                    for (int i=0;i<array.length();i++){
                        JSONObject object=array.getJSONObject(i);

                        String tips=object.getString("name");
                        if (pd.isShowing())
                        {
                            pd.dismiss();
                            joketxt.setText(tips);
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Joke.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue= Volley.newRequestQueue(Joke.this);
        queue.add(request);



    }
}

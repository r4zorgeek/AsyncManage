package com.r4zor.asyncmanage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_history);
        RequestQueue MyRequestQueue = Volley.newRequestQueue(UserHistory.this);

        try {
            // Simulate network access.
            // Thread.sleep(2000);

            String url = "https://4909fc94.ngrok.io/api/admin/log/";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    Log.d("Login Successful", response.toString());
                    try {

                    }
                    catch (Exception e) {

                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error
                    Log.d("Login UnSuccessful", error.toString());

                }
            }) {
                protected Map<String, String> getParams() {
                    Map<String, String> par = new HashMap<String, String>();
                    SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                    String auth_token = sharedPref.getString("user_token", "0000");
                    par.put("Authorization:", "Token " + auth_token);
                    return par;
                }
            };

            MyRequestQueue.add(jsonObjectRequest);
        }

        catch (Exception e) {

        }

    }


}

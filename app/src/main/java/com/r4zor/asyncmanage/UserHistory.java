package com.r4zor.asyncmanage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserHistory extends AppCompatActivity {
    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, UserHistory.class);
        return i;
    }

    List<AdminLog> mList;
    RecyclerView mRecyclerView;
    HistoryAdapter mHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_history);

        mList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.userHistory);

        mHistoryAdapter = new HistoryAdapter(mList);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mRecyclerView.setAdapter(mHistoryAdapter);

        getData();
    }


    private void getData() {
        try {
            // Simulate network access.
            // Thread.sleep(2000);

            String url = "https://8800d1ed.ngrok.io/api/admin/log/";
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {
                    Log.d("History Succ", response.toString());
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            AdminLog ob = new AdminLog();
                            ob.setUsername(response.getJSONObject(i).getString("user"));
                            ob.setAction(response.getJSONObject(i).getString("action"));
                            ob.setTimeStamp(response.getJSONObject(i).getString("timestamp"));
                            ob.setMsg(response.getJSONObject(i).getString("msg"));

                            mList.add(ob);
                        }
                    }
                    catch (Exception e) {

                    }
                    mHistoryAdapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error
                    Log.d("History UnSuccessful", error.toString());

                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
//                    SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
//                    String auth_token = sharedPref.getString("user_token", "0000");
                    params.put("Authorization","Token 1dd4acd905acdd29a5c12ccf92280f4d4abde928");
                    return params;
                }
            };

            RequestQueue MyRequestQueue = Volley.newRequestQueue(UserHistory.this);
            MyRequestQueue.add(jsonArrayRequest);
        }
        catch (Exception e) {
        }
    }

}

package com.r4zor.asyncmanage;

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
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeRequestPasswd extends AppCompatActivity {
    public UsersAdapter mUsersAdapter;

    List<Users> mList;
    RecyclerView recList;

    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, ChangeRequestPasswd.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_request_passwd);

        mList = new ArrayList<>();


        recList = (RecyclerView) findViewById(R.id.change_pass_list);

        mUsersAdapter = new UsersAdapter(mList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        recList.setAdapter(mUsersAdapter);

        getData();
    }

    private void getData() {
        try {
            // Simulate network access.
            // Thread.sleep(2000);

            String url = "https://8800d1ed.ngrok.io/api/admin/viewusers/developer/";
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {
                    Log.d("ViewU Succ", response.toString());
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            mList.add(new Users(Integer.parseInt(response.getJSONObject(i).getString("id")),
                                    response.getJSONObject(i).getString("username")));
                        }
                    }
                    catch (Exception e) {

                    }
                    mUsersAdapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error
                    Log.d("ViewU UnSuccessful", error.toString());

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

            RequestQueue MyRequestQueue = Volley.newRequestQueue(ChangeRequestPasswd.this);
            MyRequestQueue.add(jsonArrayRequest);
        }
        catch (Exception e) {
        }
    }
}

package com.r4zor.asyncmanage;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginService {
    private String authToken;
    private String username;
    private String passwd;

    LoginService(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    // get token
    String getAuthToken(Context context) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://8800d1ed.ngrok.io/api/auth-token";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
//                        textView.setText("Response is: "+ response.substring(0,500));
                        authToken = response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!");
                Log.d("LoginServiceApiRequest", "Error");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        return authToken;
    }

}

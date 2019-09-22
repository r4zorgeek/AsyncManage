package com.r4zor.asyncmanage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DeleteUser extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, DeleteUser.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        final RequestQueue MyRequestQueue = Volley.newRequestQueue(DeleteUser.this);
        final EditText user_id = findViewById(R.id.delete_userid);
        final EditText message = findViewById(R.id.delete_message);
        Button delete_submit = findViewById(R.id.delete_submit);
        delete_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    // Simulate network access.
                    // Thread.sleep(2000);
                    String user_id_st = user_id.getText().toString();
                    String message_st = message.getText().toString();
                    String url = "https://8800d1ed.ngrok.io/api/admin/delete/" + user_id_st + "/" + message_st;
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("User Disabled", response.toString());
                            try {

                            }
                            catch (Exception e) {

                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error
                            Log.d("Disables Unsuccessful", error.toString());

                        }
                    }) {
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                            String auth_token = sharedPref.getString("user_token", "0000");
                            Log.d("DeleteUser", auth_token);
                            params.put("Authorization","Token a383af1f92b4baa53574cd6baaae40be1b167123");
                            return params;
                        }
                    };

                    MyRequestQueue.add(jsonObjectRequest);
                }
                catch (Exception e) {

                }
                Toast msg = Toast.makeText(getBaseContext(),"User Deleted", Toast.LENGTH_LONG);
                msg.show();
            }
        });

    }
}

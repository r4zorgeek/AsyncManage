package com.r4zor.asyncmanage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewUsers extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, ViewUsers.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
    }
}

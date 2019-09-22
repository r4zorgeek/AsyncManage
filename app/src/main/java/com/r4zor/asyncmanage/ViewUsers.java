package com.r4zor.asyncmanage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewUsers extends AppCompatActivity {
    public UsersAdapter mUsersAdapter;

    List<Users> mList;

    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, ViewUsers.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        mList = new ArrayList<>();

        mList.add(new Users(2130, "asd", "asd"));
        mList.add(new Users(2130, "asd", "asd"));
        mList.add(new Users(2130, "asd", "asd"));
        mList.add(new Users(2130, "asd", "asd"));

        RecyclerView recList = (RecyclerView) findViewById(R.id.usersList);

        mUsersAdapter = new UsersAdapter(mList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        recList.setAdapter(mUsersAdapter);

    }
}

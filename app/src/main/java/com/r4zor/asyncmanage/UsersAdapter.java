package com.r4zor.asyncmanage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {
    private List<Users> mUserList;

    class UsersViewHolder extends RecyclerView.ViewHolder {

        private UsersViewHolder(View itemView) {
            super(itemView);

        }
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


}

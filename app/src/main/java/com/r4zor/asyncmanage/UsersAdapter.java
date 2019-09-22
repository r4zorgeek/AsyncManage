package com.r4zor.asyncmanage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {
    private List<Users> mUserList;


    public UsersAdapter(List<Users> list) {
        this.mUserList = list;
    }


    class UsersViewHolder extends RecyclerView.ViewHolder {
        protected TextView vusername;
        protected TextView vid;
        protected TextView vemail;


        private UsersViewHolder(View itemView) {
            super(itemView);
            vusername = (TextView) itemView.findViewById(R.id.username);
            vid = (TextView) itemView.findViewById(R.id.user_id);
            vemail = (TextView) itemView.findViewById(R.id.email);
        }
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_user_layout, parent, false);

        return new UsersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        Users u = mUserList.get(position);
        holder.vemail.setText(u.getEmail().toString());
        holder.vusername.setText(u.getName().toString());
        holder.vid.setText(String.valueOf(u.getId()));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


}

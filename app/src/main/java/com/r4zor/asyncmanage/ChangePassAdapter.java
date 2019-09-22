package com.r4zor.asyncmanage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ChangePassAdapter extends RecyclerView.Adapter<ChangePassAdapter.ChangePassViewHolder> {
    private List<Users> mUserList;


    public ChangePassAdapter(List<Users> list) {
        this.mUserList = list;
    }


    class ChangePassViewHolder extends RecyclerView.ViewHolder {
        protected TextView vusername;
        protected TextView vid;
        // protected TextView vemail;


        private ChangePassViewHolder(View itemView) {
            super(itemView);
            vusername = (TextView) itemView.findViewById(R.id.username);
            vid = (TextView) itemView.findViewById(R.id.user_id);
//            vemail = (TextView) itemView.findViewById(R.id.email);
        }
    }

    @NonNull
    @Override
    public ChangePassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.change_pass_card_view, parent, false);

        return new ChangePassViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChangePassViewHolder holder, int position) {
        Users u = mUserList.get(position);
//        holder.vemail.setText(u.getEmail().toString());
        holder.vusername.setText(u.getName().toString());
        holder.vid.setText(String.valueOf(u.getId()));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


}

package com.r4zor.asyncmanage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private List<AdminLog> mAdminLogList;

    public HistoryAdapter(List<AdminLog> list) {
        this.mAdminLogList = list;
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        protected TextView vUsername;
        protected TextView vAction;
        protected TextView vTimestamp;
        protected TextView vMsg;

        private HistoryViewHolder(View view) {
            super(view);
            vUsername = (TextView)view.findViewById(R.id.h_username);
            vAction = (TextView)view.findViewById(R.id.h_action);
            vTimestamp = (TextView) view.findViewById(R.id.h_timestamp);
            vMsg = (TextView) view.findViewById(R.id.h_msg);
        }
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_history, parent, false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        AdminLog UserHistory = mAdminLogList.get(position);
        holder.vUsername.setText(UserHistory.getUsername());
        holder.vAction.setText(UserHistory.getAction());
        holder.vTimestamp.setText(UserHistory.getTimeStamp());
        holder.vMsg.setText(UserHistory.getMsg());
    }

    @Override
    public int getItemCount() {
        return mAdminLogList.size();
    }
}
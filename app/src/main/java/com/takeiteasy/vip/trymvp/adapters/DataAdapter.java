package com.takeiteasy.vip.trymvp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.takeiteasy.vip.trymvp.R;
import com.takeiteasy.vip.trymvp.model.FirebaseDataItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VLogachev on 08.07.2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<FirebaseDataItem> data;

    public DataAdapter() {
        data = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FirebaseDataItem item = data.get(position);
        holder.uid.setText(item.getUid());
        holder.name.setText(item.getUser_name());
        holder.sex.setText(item.getSex());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setNewData(List<FirebaseDataItem> data) {
        this.data.clear();
        this.data.addAll(data);

        notifyDataSetChanged();
    }

    public void clean() {
        this.data.clear();

        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView uid;
        public TextView name;
        public TextView sex;

        public ViewHolder(View itemView) {
            super(itemView);

            uid = (TextView) itemView.findViewById(R.id.tv_uid);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            sex = (TextView) itemView.findViewById(R.id.tv_sex);
        }
    }
}

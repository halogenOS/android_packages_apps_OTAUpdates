package com.ota.updates.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ota.updates.R;
import com.ota.updates.types.CreditsItem;

import java.util.ArrayList;


public class CreditsAdapter extends BaseAdapter {
    private ArrayList<CreditsItem> listData;
    private LayoutInflater layoutInflater;

    public CreditsAdapter(final Context mContext, ArrayList<CreditsItem> listData){
        this.listData = listData;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.card_credits, null);
            holder = new ViewHolder();
            holder.devName = (TextView) convertView.findViewById(R.id.about_tv_credits_title);
            holder.devCredit = (TextView) convertView.findViewById(R.id.about_tv_credits_summary);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.devName.setText(listData.get(position).getDevName());
        holder.devCredit.setText(listData.get(position).getDevCredit());
        return convertView;
    }

    static class ViewHolder {
        TextView devName;
        TextView devCredit;
    }
}

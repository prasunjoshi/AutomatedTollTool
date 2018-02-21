package com.example.urja.tollproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Urja on 06-01-2018.
 */

public class HistoryCustomAdapter extends ArrayAdapter<HistoryDataModel>
{
    private ArrayList<HistoryDataModel> dataSet;
    Context mContext;
    public HistoryCustomAdapter(ArrayList<HistoryDataModel> data, Context context) {
        super(context, R.layout.row_item_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }
    private static class ViewHolder {
        TextView date;
        TextView tollid;
        TextView payment;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        HistoryDataModel dataModel = getItem(position);
        final View result;
        ViewHolder viewHolder;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_layout, parent, false);
            viewHolder.date= (TextView) convertView.findViewById(R.id.date);
            viewHolder.tollid = (TextView) convertView.findViewById(R.id.tollid);
            viewHolder.payment = (TextView) convertView.findViewById(R.id.payment);
            result=convertView;
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        viewHolder.date.setText(dataModel.getDate());
        viewHolder.tollid.setText(dataModel.getTollId());
        viewHolder.payment.setText(dataModel.getPayment());
        return convertView;
    }
}

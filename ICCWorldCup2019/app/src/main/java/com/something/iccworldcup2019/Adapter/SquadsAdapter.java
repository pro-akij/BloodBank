package com.something.iccworldcup2019.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.something.iccworldcup2019.R;

public class SquadsAdapter extends BaseAdapter {
    Context context; int[] Flag; String[] Country;
    private LayoutInflater layoutInflater;
    public SquadsAdapter(Context context, int[] flag, String[] country) {
        this.context = context;
        Flag = flag;
        Country = country;
    }

    @Override
    public int getCount() {
        return Country.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView== null){
            layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= layoutInflater.inflate(R.layout.sqads_sm, parent,false);
        }
        ImageView imageView= convertView.findViewById(R.id.sam_flag);
        TextView textView= convertView.findViewById(R.id.sam_counry);

        imageView.setImageResource(Flag[position]);
        textView.setText(Country[position]);
        return convertView;
    }
}

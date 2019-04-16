package com.something.iccworldcup2019.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.something.iccworldcup2019.R;

public class PlayerAdapter extends BaseAdapter {
    Context context; int[] Image; String[] player;
    private LayoutInflater layoutInflater;

    public PlayerAdapter(Context context, int[] image, String[] player) {
        this.context = context;
        Image = image;
        this.player = player;
    }

    @Override
    public int getCount() {
        return player.length;
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
            convertView= layoutInflater.inflate(R.layout.player_sm, parent,false);
        }
        ImageView imageView= convertView.findViewById(R.id.player_image);
        TextView textView= convertView.findViewById(R.id.player_name);

        imageView.setImageResource(Image[position]);
        textView.setText(player[position]);
        return convertView;
    }
}

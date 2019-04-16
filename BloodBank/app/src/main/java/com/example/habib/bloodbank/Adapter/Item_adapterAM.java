package com.example.habib.bloodbank.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.habib.bloodbank.Model.Item_viewAM;
import com.example.habib.bloodbank.R;

import java.util.List;

public class Item_adapterAM extends RecyclerView.Adapter<Item_adapterAM.AMViewHolder> {

    Context contex;
    List<Item_viewAM> amlist_model;

    public Item_adapterAM(Context contex, List<Item_viewAM> amlist_model) {
        this.contex = contex;
        this.amlist_model = amlist_model;
    }

    @NonNull
    @Override
    public AMViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(contex);
        View view= layoutInflater.inflate(R.layout.sample_viewam, null);
        return new AMViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AMViewHolder amViewHolder, int i) {
        Item_viewAM item_viewAM= amlist_model.get(i);
        amViewHolder.amtextView.setText(item_viewAM.getAmbulance_Name());
        amViewHolder.amtextView1.setText(item_viewAM.getAmbulance_District());
        amViewHolder.amtextView2.setText(item_viewAM.getAmbulance_Location());
        amViewHolder.amtextView3.setText(item_viewAM.getAmbulance_Contact());

        amViewHolder.amimageView.setImageDrawable(contex.getResources().getDrawable(item_viewAM.getImage()));
        amViewHolder.amimageView1.setImageDrawable(contex.getResources().getDrawable(item_viewAM.getImage1()));
        amViewHolder.amimageView2.setImageDrawable(contex.getResources().getDrawable(item_viewAM.getImage2()));
        amViewHolder.amimageView3.setImageDrawable(contex.getResources().getDrawable(item_viewAM.getImage3()));
    }

    @Override
    public int getItemCount() {
        return amlist_model.size();
    }

    class AMViewHolder extends RecyclerView.ViewHolder {
        TextView amtextView, amtextView1, amtextView2, amtextView3;
        ImageView amimageView, amimageView1, amimageView2, amimageView3;
        public AMViewHolder(@NonNull View itemView) {
            super(itemView);
            amtextView= itemView.findViewById(R.id.am_model_name);
            amtextView1= itemView.findViewById(R.id.am_model_district);
            amtextView2= itemView.findViewById(R.id.am_model_location);
            amtextView3= itemView.findViewById(R.id.am_model_contact);

            amimageView= itemView.findViewById(R.id.am_icon_model1);
            amimageView1= itemView.findViewById(R.id.am_icon_model2);
            amimageView2= itemView.findViewById(R.id.am_icon_model3);
            amimageView3= itemView.findViewById(R.id.am_icon_model4);
        }
    }
}

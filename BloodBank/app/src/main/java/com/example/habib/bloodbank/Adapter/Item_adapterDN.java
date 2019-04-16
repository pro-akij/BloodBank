package com.example.habib.bloodbank.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.habib.bloodbank.Model.Item_viewDN;
import com.example.habib.bloodbank.R;

import java.util.ArrayList;
import java.util.List;

public class Item_adapterDN extends RecyclerView.Adapter<Item_adapterDN.DNViewHolder> {

    Context contex;
    List<Item_viewDN> dnlist_model;

    public Item_adapterDN(Context contex, List<Item_viewDN> dnlist_model) {
        this.contex = contex;
        this.dnlist_model = dnlist_model;
    }

    @NonNull
    @Override
    public DNViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(contex);
        View view= layoutInflater.inflate(R.layout.sample_viewdn, null);
        return new DNViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DNViewHolder dnViewHolder, int i) {
        Item_viewDN item_viewDN= dnlist_model.get(i);
        dnViewHolder.dntextView.setText(item_viewDN.getDoner_Name());
        dnViewHolder.dntextView1.setText(item_viewDN.getDoner_blood_type());
        dnViewHolder.dntextView2.setText(item_viewDN.getDoner_district());
        dnViewHolder.dntextView3.setText(item_viewDN.getDoner_Contact());

        dnViewHolder.dnimageView.setImageDrawable(contex.getResources().getDrawable(item_viewDN.getImage()));
        dnViewHolder.dnimageView1.setImageDrawable(contex.getResources().getDrawable(item_viewDN.getImage1()));
        dnViewHolder.dnimageView2.setImageDrawable(contex.getResources().getDrawable(item_viewDN.getImage2()));
        dnViewHolder.dnimageView3.setImageDrawable(contex.getResources().getDrawable(item_viewDN.getImage3()));

    }

    @Override
    public int getItemCount() {
        return dnlist_model.size();
    }

    public void setFilter(List<Item_viewDN> filter_dn){
        dnlist_model= new ArrayList<>();
        dnlist_model.addAll(filter_dn);
        notifyDataSetChanged();
    }

    class DNViewHolder extends RecyclerView.ViewHolder{

        TextView dntextView, dntextView1, dntextView2, dntextView3;
        ImageView dnimageView, dnimageView1, dnimageView2, dnimageView3;

        public DNViewHolder(@NonNull View itemView) {
            super(itemView);

            dntextView= itemView.findViewById(R.id.dn_model_name);
            dntextView1= itemView.findViewById(R.id.dn_model_bl_type);
            dntextView2= itemView.findViewById(R.id.dn_model_district);
            dntextView3= itemView.findViewById(R.id.dn_model_contact);

            dnimageView= itemView.findViewById(R.id.dn_icon_model1);
            dnimageView1= itemView.findViewById(R.id.dn_icon_model2);
            dnimageView2= itemView.findViewById(R.id.dn_icon_model3);
            dnimageView3= itemView.findViewById(R.id.dn_icon_model4);
        }
    }
}

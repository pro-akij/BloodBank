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
import com.example.habib.bloodbank.Model.My_account_item;
import com.example.habib.bloodbank.R;

import java.util.List;

public class Item_adapterMYACC extends RecyclerView.Adapter<Item_adapterMYACC.MyAccount_ViewHolder>  {

    Context contex;
    List<My_account_item> my_account_itemList;

    public Item_adapterMYACC(Context contex, List<My_account_item> my_account_itemList) {
        this.contex = contex;
        this.my_account_itemList = my_account_itemList;
    }

    @NonNull
    @Override
    public MyAccount_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(contex);
        View view= layoutInflater.inflate(R.layout.sample_viewdn, null);
        return new MyAccount_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAccount_ViewHolder myAccount_viewHolder, int i) {
        My_account_item my_account_item= my_account_itemList.get(i);
        myAccount_viewHolder.mytext_view.setText(my_account_item.getMy_Name());
        myAccount_viewHolder.mytext_view1.setText(my_account_item.getMy_Contact());
        myAccount_viewHolder.mytext_view2.setText(my_account_item.getMy_blood());
        myAccount_viewHolder.mytext_view3.setText(my_account_item.getMy_district());

        myAccount_viewHolder.myimageView.setImageDrawable(contex.getResources().getDrawable(my_account_item.getImage()));
        myAccount_viewHolder.myimageView1.setImageDrawable(contex.getResources().getDrawable(my_account_item.getImage1()));
        myAccount_viewHolder.myimageView2.setImageDrawable(contex.getResources().getDrawable(my_account_item.getImage2()));
        myAccount_viewHolder.myimageView3.setImageDrawable(contex.getResources().getDrawable(my_account_item.getImage3()));
    }

    @Override
    public int getItemCount() {
        return my_account_itemList.size();
    }

    class MyAccount_ViewHolder extends RecyclerView.ViewHolder{

        TextView mytext_view, mytext_view1, mytext_view2, mytext_view3;
        ImageView myimageView, myimageView1, myimageView2, myimageView3;

        public MyAccount_ViewHolder(@NonNull View itemView) {
            super(itemView);

            mytext_view = itemView.findViewById(R.id.dn_model_name);
            mytext_view1 = itemView.findViewById(R.id.dn_model_bl_type);
            mytext_view2 = itemView.findViewById(R.id.dn_model_district);
            mytext_view3 = itemView.findViewById(R.id.dn_model_contact);

            myimageView = itemView.findViewById(R.id.dn_icon_model1);
            myimageView1 = itemView.findViewById(R.id.dn_icon_model2);
            myimageView2 = itemView.findViewById(R.id.dn_icon_model3);
            myimageView3 = itemView.findViewById(R.id.dn_icon_model4);
        }
    }
}

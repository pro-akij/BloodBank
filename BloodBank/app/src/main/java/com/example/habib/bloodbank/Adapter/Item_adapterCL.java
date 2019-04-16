package com.example.habib.bloodbank.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.habib.bloodbank.Model.Item_viewCL;
import com.example.habib.bloodbank.R;
import java.util.List;

public class Item_adapterCL extends RecyclerView.Adapter<Item_adapterCL.CLViewHolder> {

    Context contex;
    List<Item_viewCL> item_viewCLList;

    public Item_adapterCL(Context contex, List<Item_viewCL> item_viewCLList) {
        this.contex = contex;
        this.item_viewCLList = item_viewCLList;
    }

    @NonNull
    @Override
    public CLViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(contex);
        View view= layoutInflater.inflate(R.layout.sample_viewcl, null);
        return new CLViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CLViewHolder clViewHolder, int i) {

        Item_viewCL item_viewCL= item_viewCLList.get(i);
        clViewHolder.cltextView.setText(item_viewCL.getClub_Name());
        clViewHolder.cltextView1.setText(item_viewCL.getClub_location());
        clViewHolder.cltextView2.setText(item_viewCL.getClub_district());
        clViewHolder.cltextView3.setText(item_viewCL.getClub_Contact());

        clViewHolder.climageView.setImageDrawable(contex.getResources().getDrawable(item_viewCL.getImage()));
        clViewHolder.climageView1.setImageDrawable(contex.getResources().getDrawable(item_viewCL.getImage1()));
        clViewHolder.climageView2.setImageDrawable(contex.getResources().getDrawable(item_viewCL.getImage2()));
        clViewHolder.climageView3.setImageDrawable(contex.getResources().getDrawable(item_viewCL.getImage3()));

    }

    @Override
    public int getItemCount() {
        return item_viewCLList.size();
    }

    class CLViewHolder extends RecyclerView.ViewHolder{
        TextView cltextView, cltextView1, cltextView2, cltextView3;
        ImageView climageView, climageView1, climageView2, climageView3;

        public CLViewHolder(@NonNull View itemView) {
            super(itemView);

            cltextView= itemView.findViewById(R.id.cl_model_name);
            cltextView1= itemView.findViewById(R.id.cl_model_location);
            cltextView2= itemView.findViewById(R.id.cl_model_district);
            cltextView3= itemView.findViewById(R.id.cl_model_contact);

            climageView= itemView.findViewById(R.id.cl_icon_model1);
            climageView1= itemView.findViewById(R.id.cl_icon_model2);
            climageView2= itemView.findViewById(R.id.cl_icon_model3);
            climageView3= itemView.findViewById(R.id.cl_icon_model4);
        }
    }
}

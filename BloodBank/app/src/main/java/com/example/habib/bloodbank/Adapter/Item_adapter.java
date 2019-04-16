package com.example.habib.bloodbank.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.habib.bloodbank.Model.Item_view;
import com.example.habib.bloodbank.R;

import java.util.List;

public class Item_adapter extends RecyclerView.Adapter<Item_adapter.ItemViewHolder> {
    Context context;
    List<Item_view> itemViewList;

    public Item_adapter(Context context, List<Item_view> itemViewList) {
        this.context = context;
        this.itemViewList = itemViewList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.sample_view, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        Item_view model_item= itemViewList.get(i);
        itemViewHolder.textView.setText(model_item.getName());
        itemViewHolder.textView1.setText(model_item.getBlood());
        itemViewHolder.textView2.setText(model_item.getBl_amount());
        itemViewHolder.textView3.setText(model_item.getDistrict());
        itemViewHolder.textView4.setText(model_item.getContact());
        itemViewHolder.textView5.setText(model_item.getHospital_name());
        itemViewHolder.textView6.setText(model_item.getHospital_loc());
        itemViewHolder.textView7.setText(model_item.getDescription());

        itemViewHolder.imageView.setImageDrawable(context.getResources().getDrawable(model_item.getImage()));
        itemViewHolder.imageView1.setImageDrawable(context.getResources().getDrawable(model_item.getImage1()));
        itemViewHolder.imageView2.setImageDrawable(context.getResources().getDrawable(model_item.getImage2()));
        itemViewHolder.imageView3.setImageDrawable(context.getResources().getDrawable(model_item.getImage3()));
        itemViewHolder.imageView4.setImageDrawable(context.getResources().getDrawable(model_item.getImage4()));
        itemViewHolder.imageView5.setImageDrawable(context.getResources().getDrawable(model_item.getImage5()));
        itemViewHolder.imageView6.setImageDrawable(context.getResources().getDrawable(model_item.getImage6()));
        itemViewHolder.imageView7.setImageDrawable(context.getResources().getDrawable(model_item.getImage7()));

    }

    @Override
    public int getItemCount() {
        return itemViewList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView, imageView1, imageView2, imageView3,
                imageView4, imageView5, imageView6, imageView7;
        TextView textView, textView1, textView2, textView3,
                textView4, textView5,textView6, textView7;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.model_name);
            textView1= itemView.findViewById(R.id.model_blood);
            textView2= itemView.findViewById(R.id.model_blood_amount);
            textView3= itemView.findViewById(R.id.model_district);
            textView4= itemView.findViewById(R.id.model_contact);
            textView5= itemView.findViewById(R.id.model_hospital_name);
            textView6= itemView.findViewById(R.id.model_hospital_location);
            textView7= itemView.findViewById(R.id.model_description);

            imageView= itemView.findViewById(R.id.icon_model1);
            imageView1= itemView.findViewById(R.id.icon_model2);
            imageView2= itemView.findViewById(R.id.icon_model3);
            imageView3= itemView.findViewById(R.id.icon_model4);
            imageView4= itemView.findViewById(R.id.icon_model5);
            imageView5= itemView.findViewById(R.id.icon_model6);
            imageView6= itemView.findViewById(R.id.icon_model7);
            imageView7= itemView.findViewById(R.id.icon_model8);
        }
    }
}

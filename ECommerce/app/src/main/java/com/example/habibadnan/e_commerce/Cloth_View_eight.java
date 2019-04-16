package com.example.habibadnan.e_commerce;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Cloth_View_eight extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView_share, for_cardview;
    private Button cloth_Specification;
    private TextView textView;
    private MenuItem menuItem;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth__vew_eight);
        cloth_Specification= findViewById(R.id.cloth_specific_eight);
        imageView_share= findViewById(R.id.share_eight);
        setTitle("E-Commerce");

        cloth_Specification.setOnClickListener(this);
        imageView_share.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        menuItem= menu.findItem(R.id.cart);
        View view= menuItem.getActionView();
        if (view!= null){
            textView= view.findViewById(R.id.card_notification_textview);
            for_cardview= view.findViewById(R.id.shopping_card_layout);
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id==R.id.cloth_specific_eight){
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setTitle("Specification");
            builder.setMessage("available in stock");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.create();
            builder.show();
        }
        else if (id== R.id.share_eight){
            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(intent.EXTRA_SUBJECT,"E-commerce App");
            intent.putExtra(intent.EXTRA_TEXT,"www.getjar.mobi/mobile/966549/BBPI");
            startActivity(intent.createChooser(intent,"Share With"));
        }
    }
}
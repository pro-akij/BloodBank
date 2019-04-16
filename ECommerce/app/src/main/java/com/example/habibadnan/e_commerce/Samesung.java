package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Samesung extends AppCompatActivity {
    private Button add_card;
    private ImageView share, share_fabourite, for_cardview;
    private int count=0;
    private TextView textView;
    private MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samesung);
        add_card= findViewById(R.id.add_to_card_samesumg);
        share= findViewById(R.id.share_samesumg);
        share_fabourite= findViewById(R.id.fabourite_share_samesumg);
        Share();
        Add_Card();
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

    public void Share(){
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(intent.EXTRA_SUBJECT,"E-commerce App");
                intent.putExtra(intent.EXTRA_TEXT,"www.getjar.mobi/mobile/966549/BBPI");
                startActivity(intent.createChooser(intent,"Share With"));
            }
        });
    }
    private void Add_Card(){
        add_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText(String.valueOf(count));
            }
        });
    }
}

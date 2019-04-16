package com.example.habibadnan.e_commerce;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Cloth_View_one extends AppCompatActivity implements View.OnClickListener {
    private Button add_card, cloth_specific;
    private ImageView imageView_share, for_cardview;
    DB_Healper db_healper;
    TextView header_text, prize;
    private String for_Header_Text, for_Prize;
    private TextView textView;
    private MenuItem menuItem;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_view_one);
        add_card= findViewById(R.id.add_to_card);
        cloth_specific= findViewById(R.id.cloth_specific_one);
        imageView_share= findViewById(R.id.share_one);
        header_text= findViewById(R.id.get_header_text);
        prize= findViewById(R.id.get_prize);
        db_healper= new DB_Healper(this);

        add_card.setOnClickListener(this);
        cloth_specific.setOnClickListener(this);
        image_Share();

        for_Header_Text=header_text.getText().toString();
        for_Prize=prize.getText().toString();
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
        if (id==R.id.add_to_card){
            long cheker=db_healper.insertData(for_Header_Text,for_Prize);
            if (cheker>0){
                Toast.makeText(this,"data successfully",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"data not inserted",Toast.LENGTH_LONG).show();
            }
            /*Intent intent= new Intent(Cloth_View_one.this,Test.class);
            intent.putExtra("View_one_image",R.drawable.tshirt1);
            startActivity(intent);*/
            Toast.makeText(this,"click successfully!!",Toast.LENGTH_LONG).show();
        }else if (id==R.id.cloth_specific_one){
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
    }
    public void image_Share(){
        imageView_share.setOnClickListener(new View.OnClickListener() {
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
}

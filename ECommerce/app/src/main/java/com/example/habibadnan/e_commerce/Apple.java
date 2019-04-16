package com.example.habibadnan.e_commerce;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class Apple extends AppCompatActivity{
    private Button add_Card;
    private ImageButton share, share_favourite, for_cardview;
    public int count=0;
    private TextView count_card_item, get_header_text, get_prize;
    private MenuItem menuItem;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private String details, prize, quantity;
    private Spinner spin_quantity;
    private Uri imageUri;
    Cart_model cart_model= new Cart_model();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);
        get_header_text= findViewById(R.id.get_header_text);
        get_prize= findViewById(R.id.get_prize);
        spin_quantity= findViewById(R.id.specifi_quantity);
        add_Card= findViewById(R.id.add_to_card_apple);
        share= findViewById(R.id.share_apple);
        share_favourite= findViewById(R.id.fabourite_share_apple);
        Share();
        Add_Card();
        Set_Quantity();
        mAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("Apple Data");
        storageReference= FirebaseStorage.getInstance().getReference("Apple Location");
    }
    public void Set_Quantity(){
        String[] get_quantity= getResources().getStringArray(R.array.Quantity);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,get_quantity);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_quantity.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        menuItem= menu.findItem(R.id.cart);
        View view= menuItem.getActionView();
        if (view!= null){
            count_card_item= view.findViewById(R.id.card_notification_textview);
            for_cardview= view.findViewById(R.id.shopping_card_layout);
        }
        return true;
    }

    private void Share(){
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

    public String getFileExtension(Uri uri){
        ContentResolver contentResolver= getContentResolver();
        MimeTypeMap mimeTypeMap= MimeTypeMap.getSingleton();
        return mimeTypeMap.getMimeTypeFromExtension(contentResolver.getType(uri));
    }

    private void Add_Card(){
        add_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart_model.countincr=count++;
                count=cart_model.countincr;
                count_card_item.setText(String.valueOf(count));
                details = get_header_text.getText().toString().trim();
                prize = get_prize.getText().toString().trim();
                final String key = databaseReference.push().getKey();

                StorageReference ref= storageReference.child(System.currentTimeMillis()+"."+getFileExtension(imageUri));
                ref.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        String getSelect_quantity = (String) spin_quantity.getSelectedItem();

                        Model model = new Model(taskSnapshot.getStorage().getDownloadUrl().toString(), details, prize, getSelect_quantity);
                        databaseReference.child(key).setValue(model);
                        Toast.makeText(Apple.this, "success uploading", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                        Toast.makeText(Apple.this, "not uploading", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}


package com.example.android.tourguidelondonandsalsa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String currentAddress = address;
        Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(currentAddress));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    //Get name, picture, address from previous Activity.
    Intent intent = getIntent();
    Items placeChosen = intent.getParcelableExtra(getString(com.example.android.tourguidelondonandsalsa.R.string.PlaceChosen));
    String address = placeChosen.getAddress();
    String name = placeChosen.getName();
    int imageRes = placeChosen.getImageResourceId();
}

package com.example.resturant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dishDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button menu = findViewById(R.id.backMenuDetail);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dishDetails.this, menu.class);
                startActivity(intent);
            }
        });

        TextView nameText = findViewById(R.id.detailName);
        TextView ingText = findViewById(R.id.detailIngr);
        TextView priceText = findViewById(R.id.detailPrice);

        Intent intent=getIntent();
        String nameOfDish = intent.getExtras().getString("name");
        String ingOfDish = intent.getExtras().getString("ing");
        String priceOfDish = intent.getExtras().getString("price");

        nameText.setText(nameOfDish);
        ingText.setText(ingOfDish);
        priceText.setText(priceOfDish);

    }
}
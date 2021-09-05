package com.example.resturant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addDish extends AppCompatActivity {
    AppDatabase appDatabase;
    DishDao dishDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onStart(){
        super.onStart();

        EditText dishName= findViewById(R.id.dishName);
        EditText dishIngrediants = findViewById(R.id.ingrediants);
        EditText dishPrice = findViewById(R.id.price);

        Button submitDish = findViewById(R.id.submitDish);
        submitDish.setOnClickListener(v -> {


            Dish dish = new Dish(dishName.getText().toString(),dishIngrediants.getText().toString()
            ,dishPrice.getText().toString());
            appDatabase =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                    "dishDatabase").allowMainThreadQueries()
                    .build();
            DishDao dishDao=appDatabase.dishDao();
            dishDao.insertAll(dish);
            Intent menuPage = new Intent(addDish.this,menu.class);
            Toast.makeText(getApplicationContext(),"Added Successfully!",Toast.LENGTH_LONG).show();
            startActivity(menuPage);


        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
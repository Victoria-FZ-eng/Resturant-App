package com.example.resturant;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface TaskDao {

    @Query("SELECT * FROM dish")
    List<Dish> getAll();

    @Insert
    void insertAll(Dish...dishes);

    @Delete
    void deleteAll(Dish dish);
}

package com.git.workshop.database;

import com.git.workshop.database.dao.UserDao;
import com.git.workshop.database.model.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

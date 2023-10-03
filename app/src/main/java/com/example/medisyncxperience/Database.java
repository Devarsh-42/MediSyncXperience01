package com.example.medisyncxperience;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Healthcare";
    public static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "CREATE TABLE users (username TEXT, email TEXT, password TEXT, bloodgroup TEXT, recent_diseases TEXT)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "CREATE TABLE carts (username TEXT, product TEXT, price float,Otype TEXT)";
        sqLiteDatabase.execSQL(qry2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Implement code for handling database schema upgrades if needed.
    }

    public void register(String username, String email, String password, String bloodgroup, String medHistory) {
        SQLiteDatabase sdb = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        cv.put("bloodgroup", bloodgroup);
        cv.put("Recent Medical History", medHistory);
        sdb.insert("users", null, cv);
        sdb.close();
    }

    public int login(String username, String password) {
        SQLiteDatabase sdb = getReadableDatabase();
        int result = 0; // User Doesn't exist
        String[] columns = {"username"};
        String selection = "username=? AND password=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = sdb.query("users", columns, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            result = 1; // User Exists
            cursor.close();
        }

        sdb.close();
        return result;
    }

    public void addToCart(String username, String product, float price, String Otype) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", price);
        cv.put("Order Type", Otype);
        db.insert("carts", null, cv);
        db.close();
    }

    public int checkCart(String username, String product) {// To Check if the Data Already Exist.
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart where username=? and product = ?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        db.close();
        return result;
    }

    public void removeCart(String username, String Otype) {// Delete Order from Cart
        String str[] = new String[2];
        str[0] = username;
        str[1] = Otype;
        SQLiteDatabase db = getReadableDatabase();
        db.delete("carts", "username=? and Otype=?", str);
        db.close();
    }

    public UserData getUserData(String username) {
        SQLiteDatabase db = getReadableDatabase();
        UserData userData = null;

        // Define the selection criteria
        String selection = "username=?";
        String[] selectionArgs = {username};

        // Query the database to retrieve user data
        Cursor cursor = db.query("users", null, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            int usernameIndex = cursor.getColumnIndex("username");
            int bloodGroupIndex = cursor.getColumnIndex("blood-group");
            int recentDiseasesIndex = cursor.getColumnIndex("recent_diseases");

            if (usernameIndex != -1 && bloodGroupIndex != -1 && recentDiseasesIndex != -1) {
                // Retrieve data from the cursor
                String fetchedUsername = cursor.getString(usernameIndex);
                String bloodGroup = cursor.getString(bloodGroupIndex);
                String recentDiseases = cursor.getString(recentDiseasesIndex);

                // Create a UserData object with the retrieved data
                userData = new UserData(fetchedUsername, bloodGroup, recentDiseases);
            }

            // Close the cursor
            cursor.close();
        }

        // Close the database connection
        db.close();

        return userData;
    }

    public void register(String username, String email, String password) {
        SQLiteDatabase sdb = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        sdb.insert("users", null, cv);
        sdb.close();
    }
}
package com.example.sugondese;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_PRODUCTS = "products";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";
    public static final String COLUMN_QUANTITY = "quantity";

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " +

                TABLE_PRODUCTS + "("

                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME

                + " TEXT," + COLUMN_QUANTITY + " INTEGER" + ")";

        db.execSQL(query);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);

    }

    public Boolean addProducts(Product product) {

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PRODUCTNAME, product.get_productname());
        cv.put(COLUMN_QUANTITY, product.get_quantity());

        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_PRODUCTS, null, cv);
        db.close();

        if (result == -1)
            return false;
        else
            return true;
    }

    public Product findProduct(String productname) {

        String query = "Select * from " + TABLE_PRODUCTS + " Where " + COLUMN_PRODUCTNAME + " =\"" + productname + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Product product = new Product();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.set_id(Integer.parseInt(cursor.getString(0)));
            product.set_productname(cursor.getString(1));
            product.set_quantity(Integer.parseInt(cursor.getString(2)));

            cursor.close();

        } else {
            product = null;
        }

        db.close();
        return product;

    }

    public Boolean deleteProduct(String productname) {

        Boolean result = false;
        String query = "Select * from " + TABLE_PRODUCTS + " Where " + COLUMN_PRODUCTNAME + " = \"" + productname + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Product product = new Product();

        if (cursor.moveToFirst()) {
            product.set_id(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?", new String[]{String.valueOf(product.get_id())});
            cursor.close();
            result = true;

        }

        db.close();
        return result;
    }
}






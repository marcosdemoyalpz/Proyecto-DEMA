package com.example.silentechoes.dema.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gatorade on 08/10/2015.
 */
public class DbHelper extends SQLiteOpenHelper {



    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "orders.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_ORDER_TABLE = "CREATE TABLE " + Contract.OrderEntry.TABLE_NAME + " (" +

                Contract.OrderEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +

                // the ID of the location entry associated with this weather data
                Contract.OrderEntry.COLUMN_CLIENT_CEDULA + " TEXT NOT NULL, " +
                Contract.OrderEntry.COLUMN_CLIENT_NAME + " TEXT NOT NULL, " +
                Contract.OrderEntry.COLUMN_CLIENT_LAST_NAME + " TEXT NOT NULL, " +
                Contract.OrderEntry.COLUMN_CLIENT_TEL + " NUMERIC NOT NULL," +
                Contract.OrderEntry.COLUMN_CLIENT_PROVINCE + "TEXT NOT NULL," +
                Contract.OrderEntry.COLUMN_CLIENT_TOWN + "TEXT NOT NULL," +
                Contract.OrderEntry.COLUMN_CLIENT_SECTOR + "TEXT NOT NULL," +
                Contract.OrderEntry.COLUMN_CLIENT_STREET + "TEXT NOT NULL," +
                Contract.OrderEntry.COLUMN_CLIENT_STREET_NO + "INTEGER NULL," +
                Contract.OrderEntry.COLUMN_CLIENT_DIR_REF + "TEXT NULL," +
                Contract.OrderEntry.COLUMN_ORDER_STATUS + "TEXT NOT NULL," +
                Contract.OrderEntry.COLUMN_ORDER_RECEIVER + "TEXT NULL," +
                Contract.OrderEntry.COLUMN_ORDER_RECEIVER_CED + "TEXT NULL" +
                Contract.OrderEntry.COLUMN_ORDER_STATUS_SENT + "NUMERIC NOT NULL," +
                Contract.OrderEntry.COLUMN_ORDER_ACTUAL_DATE + "NUMERIC NULL," +
                Contract.OrderEntry.COLUMN_COORD_LAT + "REAL NOT NULL," +
                Contract.OrderEntry.COLUMN_COORD_LONG + "REAL NOT NULL)";

        sqLiteDatabase.execSQL(SQL_CREATE_ORDER_TABLE);

        final String SQL_CREATE_ITEMS_ORDER_TABLE = "CREATE TABLE " + Contract.ItemsOrderEntry.TABLE_NAME + " (" +

                Contract.ItemsOrderEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +


                Contract.ItemsOrderEntry.COLUMN_DESC + " TEXT NOT NULL, " +
                Contract.ItemsOrderEntry.COLUMN_COUNT + " INTEGER NOT NULL, " +

                " FOREIGN KEY (" + Contract.ItemsOrderEntry.COLUMN_ORDER_ID + ") REFERENCES " +
                Contract.OrderEntry.TABLE_NAME + " (" + Contract.OrderEntry.COLUMN_ID + "))";

        sqLiteDatabase.execSQL(SQL_CREATE_ITEMS_ORDER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        // Note that this only fires if you change the version number for your database.
        // It does NOT depend on the version number for your application.
        // If you want to update the schema without wiping data, commenting out the next 2 lines
        // should be your top priority before modifying this method.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.OrderEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.ItemsOrderEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

package com.example.silentechoes.dema.Data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Gatorade on 08/10/2015.
 */
public class Contract {


    public static final String CONTENT_AUTHORITY = "com.example.silentechoes.dema";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final String PATH_ORDER = "order";
    public static final String PATH_ITEMS = "items";

    public static enum OrderStatus {
        ONWAY("De Camino", 0),
        DELIVERED("Entregado", 1),
        RETURNED("Devuelto", 2),
        NOT_DELIVERED("No Entregado", 3);

        private String stringValue;
        private int intValue;
        OrderStatus(String s, int i) {
            stringValue = s;
            intValue = i;
        }

        public String toString(){
            return stringValue;
        }
        public int value(){
            return intValue;
        }
    }

    public static final class OrderEntry implements BaseColumns {
        public static final String TABLE_NAME = "order";

        public static final String COLUMN_ID = "_id";

        public static final String COLUMN_CLIENT_CEDULA = "cedula";

        public static final String COLUMN_CLIENT_NAME = "client_name";

        public static final String COLUMN_CLIENT_LAST_NAME = "client_last_name";

        public static final String COLUMN_CLIENT_TEL = "client_tel";

        public static final String COLUMN_CLIENT_PROVINCE = "client_province";

        public static final String COLUMN_CLIENT_TOWN = "client_town";

        public static final String COLUMN_CLIENT_SECTOR = "client_sector";

        public static final String COLUMN_CLIENT_STREET = "client_street";

        public static final String COLUMN_CLIENT_STREET_NO = "client_street_no";

        public static final String COLUMN_CLIENT_DIR_REF = "client_dir_ref";

        public static final String COLUMN_ORDER_STATUS = "order_status";

        public static final String COLUMN_ORDER_STATUS_SENT = "order_status_confirmed";

        public static final String COLUMN_ORDER_RECEIVER = "order_receiver_name";

        public static final String COLUMN_ORDER_RECEIVER_CED = "order_receiver_ced";

        public static final String COLUMN_ORDER_ACTUAL_DATE = "client_actual_date";

        public static final String COLUMN_COORD_LAT = "lat";

        public static final String COLUMN_COORD_LONG = "long";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ORDER).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ORDER;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ORDER;

        public static Uri buildOrderUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }


    public static final class ItemsOrderEntry implements BaseColumns {

        public static final String TABLE_NAME = "items";


        public static final String COLUMN_ID = "_id";

        public static final String COLUMN_DESC = "desc";

        public static final String COLUMN_ORDER_ID = "order_id";

        public static final String COLUMN_COUNT = "items_count";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ITEMS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEMS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEMS;


        public static Uri buildItemsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}

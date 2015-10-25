package com.example.silentechoes.dema.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Created by Gatorade on 07/10/2015.
 */
public class ItemsOrderAdapter extends CursorAdapter {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public ItemsOrderAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}

package com.in.dbexample.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.in.dbexample.R;
import com.in.dbexample.holders.ContactListItemHolder;

public class ContactListAdapter extends CursorAdapter {


    public ContactListAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View convertView = View.inflate(context, R.layout.contact_list_item,null) ;

        ContactListItemHolder contactListItemHolder = new ContactListItemHolder() ;

        contactListItemHolder.cName = (TextView) convertView.findViewById(R.id.name);
        contactListItemHolder.cNumber = (TextView) convertView.findViewById(R.id.number);

        return convertView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}

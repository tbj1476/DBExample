package com.in.dbexample;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.in.dbexample.adapters.ContactListAdapter;
import com.in.dbexample.data.DbManager;

class ContactListActivity extends Activity {

    ListView cList ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.contact_list);

        cList = findViewById(R.id.clist) ;


        setCListAdapter() ;

    }

    private void setCListAdapter() {


        DbManager dbManager = new DbManager(getApplicationContext()) ;

        Cursor contactsListCursor = dbManager.getContactList() ;

        if(contactsListCursor.getCount() > 0){

            ContactListAdapter contactListAdapter = new ContactListAdapter(getApplicationContext(),contactsListCursor) ;
            cList.setAdapter(contactListAdapter);
        }
        else{

        }

    }


}

package com.in.dbexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.in.dbexample.data.DbManager;

public class MainActivity extends AppCompatActivity {

    public DbManager dbManager = null ;

    EditText name, contact ;
    Button buttonSave ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DbManager(this) ;

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        buttonSave = findViewById(R.id.save);


        buttonSave.setOnClickListener(onClickListener);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String contactName = name.getText().toString() ;
            String contactNumber = contact.getText().toString() ;

            if(contactName.isEmpty()){
                Toast.makeText(getApplicationContext(), R.string.cname_empty_error, Toast.LENGTH_SHORT).show();
                return;
            }

            if(contactNumber.isEmpty()){
                Toast.makeText(getApplicationContext(), R.string.cnumber_empty_error, Toast.LENGTH_SHORT).show();
                return;
            }
            else if(contactNumber.length() != 10){
                Toast.makeText(getApplicationContext(), R.string.cnumber_length_error, Toast.LENGTH_SHORT).show();
                return;
            }

            long insertRes = dbManager.insertData(contactName, contactNumber) ;

            if(insertRes == -1){

                Intent contactDetails = new Intent(getApplicationContext(),ContactListActivity.class) ;


                Toast.makeText(getApplicationContext(), R.string.contact_insert_success, Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), R.string.contact_insert_success, Toast.LENGTH_SHORT).show();
            }

        }
    };

}

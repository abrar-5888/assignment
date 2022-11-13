package com.example.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper1;
    SQLiteDatabase db;
    Button update1;
    String id;
    EditText id1,locnaa,locaddd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        locnaa=(EditText)findViewById(R.id.locan);
        locaddd=(EditText)findViewById(R.id.locaddd);
        update1 = (Button) findViewById(R.id.update1);
        id1 = (EditText) findViewById(R.id.id);

        openHelper1 = new DatabaseHelper(this);


        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper1.getWritableDatabase();
                String locn = locnaa.getText().toString();
                String loca = locaddd.getText().toString();
                id=id1.getText().toString();
                updatedata(locn, loca );
                Toast.makeText(updateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }

        });

    }
    private void updatedata(String locana, String locaadd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.locCOL_2, locana);
        contentValues.put(DatabaseHelper.locCOL_3,locaadd);
        db.update(DatabaseHelper.TABLE_loca,contentValues,"ID=?",new String[]{id});

    }

}


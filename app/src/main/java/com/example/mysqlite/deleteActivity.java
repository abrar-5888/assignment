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

public class deleteActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper1;
    SQLiteDatabase db;
    Button delete1;
//    String id2;
    EditText id1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);



        openHelper1 =new DatabaseHelper(this);
        delete1=(Button) findViewById(R.id.delete1);
        id1=(EditText) findViewById(R.id.id1);


        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper1.getWritableDatabase();
                deletedata(id1.getText().toString());

                Toast.makeText(deleteActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deletedata(String id2) {
        db.delete(DatabaseHelper.TABLE_loca,"ID=?",new String[] {id2});

    }
}
package com.example.mysqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class locActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper1;
    private final int REQ=1;
    private Bitmap bitmap;
    SQLiteDatabase db;
    Button add,sign,update,delete;
    EditText locna,locadd;
    ImageView showimg;
    String locn,loca;
    CardView addimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc);

        openHelper1 =new DatabaseHelper(this);

        locna=(EditText) findViewById(R.id.locname);
        addimg=(CardView)findViewById(R.id.addimg);
        showimg=(ImageView)findViewById(R.id.showimg);
        locadd=(EditText) findViewById(R.id.locadd);
        add=(Button) findViewById(R.id.Add);
        update=(Button) findViewById(R.id.update);
        delete=(Button) findViewById(R.id.delete);
        sign=(Button) findViewById(R.id.sign);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper1.getWritableDatabase();
                locn = locna.getText().toString();
                loca = locadd.getText().toString();

                insertdata(locn,loca);


                Toast.makeText(locActivity.this, "LOCATION ADDED", Toast.LENGTH_SHORT).show();
            }


        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(locActivity.this,updateActivity.class);
                startActivity(intent);


            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(locActivity.this,deleteActivity.class);
                startActivity(intent);
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(locActivity.this,loginActivity.class);
                startActivity(intent);
            }
        });
        addimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
                Toast.makeText(locActivity.this, "CARD IS WORKING", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void openGallery() {
        Intent pickimg=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickimg,REQ);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ && resultCode==RESULT_OK)
        {
            Uri uri=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            }
            showimg.setImageBitmap(bitmap);
        }
    }

    private void insertdata(String locn, String loca) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.locCOL_2, locn);
        contentValues.put(DatabaseHelper.locCOL_3,loca);
        long id = db.insert(DatabaseHelper.TABLE_loca, null, contentValues);


    }
}
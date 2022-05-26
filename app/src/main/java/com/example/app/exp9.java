package com.example.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class exp9 extends AppCompatActivity {
    EditText name, id, pname, item,type;
    Button insert, delete, update, view;
    DBhelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp9);

        name = findViewById(R.id.name);
        id = findViewById(R.id.vid);
        pname = findViewById(R.id.pname);
        item=findViewById(R.id.item);
        type = findViewById(R.id.type);
        insert = findViewById(R.id.insert);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        view = findViewById(R.id.view);

        db = new DBhelper(this);

        insert.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String nametxt = name.getText().toString();
                String idtxt = id.getText().toString();
                String pnametxt = pname.getText().toString();
                String itemtxt = item.getText().toString();
                String typetxt = type.getText().toString();

                boolean checkinsert = db.insertData(nametxt, idtxt, pnametxt,itemtxt,typetxt);

                if (checkinsert == true)
                    Toast.makeText(exp9.this, "New entry", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(exp9.this, "Failed to enter", Toast.LENGTH_SHORT).show();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt = name.getText().toString();
                String contacttxt = id.getText().toString();
                String dobtxt = pname.getText().toString();

                boolean checkupdate = db.UpdateData(nametxt, contacttxt, dobtxt);

                if (checkupdate == true)
                    Toast.makeText(exp9.this, "updated entry", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(exp9.this, "Failed to update", Toast.LENGTH_SHORT).show();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt = name.getText().toString();
                boolean checkdelete = db.deleteData(nametxt);

                if (checkdelete == true)
                    Toast.makeText(exp9.this, "deleted entry", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(exp9.this, "Failed to delete", Toast.LENGTH_SHORT).show();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getData();

                if (res.getCount()==0) {
                    Toast.makeText(exp9.this, "No data", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Vendor Name: "+res.getString(0)+"\n"+"ID  : "+res.getString(1)+"\n"+"Product Name : "+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(exp9.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}

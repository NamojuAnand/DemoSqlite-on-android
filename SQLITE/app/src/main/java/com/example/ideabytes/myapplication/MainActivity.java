package com.example.ideabytes.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseHandler db;
    EditText e1,e2,e3;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHandler(this);

        e1= findViewById(R.id.edit1);
        e2= findViewById(R.id.edit2);
        e3= findViewById(R.id.edit3);
        b1= findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2= findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3= findViewById(R.id.button3);
        b3.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1){
                    boolean isInserted=db.onInsert(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                    if (isInserted == true){
                        Toast.makeText(MainActivity.this,"Data inserted succefully",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                    }

        } else if(v.getId()==R.id.button2){

                    boolean isUpdated=db.onUpdate(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                    if (isUpdated == true){
                        Toast.makeText(MainActivity.this,"Data updated successfully",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Data not updated",Toast.LENGTH_LONG).show();

                    }

        } else if (v.getId()==R.id.button3){

                    int isDeleted=db.onDelete(e1.getText().toString());
                    if (isDeleted>0){
                        Toast.makeText(MainActivity.this,"Row deleted successfully",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Row not deleted",Toast.LENGTH_LONG).show();

                    }
        }
    }
}

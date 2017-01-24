package com.example.yassarchohan.sqlite_2_prc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Custom_database cus = new Custom_database(this) ;

        final EditText txt1 = (EditText) findViewById(R.id.name);
        final EditText txt2 = (EditText) findViewById(R.id.fathername);
        final EditText txt3 = (EditText) findViewById(R.id.marks);

        Button btn = (Button) findViewById(R.id.button);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                      String name = txt1.getText().toString();
                        String fname = txt2.getText().toString();
                        int marks = Integer.parseInt(txt3.getText().toString());

                        cus.insertdata(name,fname,marks);
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                }
            });

        Button btn1 = (Button) findViewById(R.id.newactivity);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,student_records.class);
                startActivity(intent);
            }
        });

        }
    }


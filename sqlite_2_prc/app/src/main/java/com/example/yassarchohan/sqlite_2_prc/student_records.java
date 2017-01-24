package com.example.yassarchohan.sqlite_2_prc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class student_records extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_records);

        final Custom_database custom_database = new Custom_database(this);

        Button btn = (Button) findViewById(R.id.showdata);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<getrecords> abc = custom_database.readData();

                ListView list = (ListView) findViewById(R.id.list);
                Custom_adapter ca = new Custom_adapter(student_records.this,abc);
                list.setAdapter(ca);
            }
        });

    }
}

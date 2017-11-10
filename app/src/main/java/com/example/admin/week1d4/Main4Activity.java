package com.example.admin.week1d4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView tvPerson = findViewById(R.id.showPersonList);
        Intent intent = getIntent();
        String getPeronList = intent.getStringExtra("person");
        tvPerson.setText(getPeronList);
    }
}

package com.example.admin.week1d4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private EditText firstname;
    private EditText lastname;
    private String firstName;
    private String lastName;
    List<Person> personList = new ArrayList<>();
    private TextView showPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        firstname = findViewById(R.id.firstName);
        lastname = findViewById(R.id.lastName);
        showPerson = findViewById(R.id.showPerson);
    }

    public void submitPerson(View view) {

        firstName = firstname.getText().toString();
        lastName = lastname.getText().toString();

        Person person = new Person(firstName, lastName);
        personList.add(person);
        Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show();
        showPerson.setText(personList.toString());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("person", showPerson.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showPerson.setText(savedInstanceState.getString("person"));
    }

    public void goToSeePerson(View view) {

        Intent intent = new Intent(this, Main4Activity.class);
        intent.putExtra("person", personList.toString());
        startActivity(intent);
    }
}

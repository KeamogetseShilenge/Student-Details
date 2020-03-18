package com.example.pihestudentdetails;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button searchButton;
    Button clearButton;
    Button saveButton;

    EditText ID;
    EditText firstName;
    EditText lastName;
    EditText contact;
    EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addButton);
        searchButton = (Button) findViewById(R.id.searchButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        saveButton = (Button) findViewById(R.id.saveButton);

        ID = (EditText) findViewById(R.id.ID);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        contact = (EditText) findViewById(R.id.contact);
        address = (EditText) findViewById(R.id.address);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToDatabase();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }

            public void search() {
                //when no ID has been entered
                if (ID.getText().toString() == "") {
                    Toast.makeText(this, "Enter Student ID", Toast.LENGTH_LONG).show();
                    return;
                }
                DBHandler db = new DBHandler(this);
                Cursor res = db.search(ID.getText().toString());
                //when the ID is invalid
                if (res.getCount() == 0)
                    Toast.makeText(this, "No student with that ID", Toast.LENGTH_LONG).show();
                //when the ID is valid
                else {
                    while (res.moveToNext()) {
                        firstName.setText(res.getString(1));
                        lastName.setText(res.getString(2));
                        contact.setText(res.getString(3));
                        address.setText(res.getString(4));
                    }
                }
            }


            public void add () {
                ID.setEnabled(true);
                firstName.setEnabled(true);
                lastName.setEnabled(true);
                contact.setEnabled(true);
                address.setEnabled(true);

                saveButton.setEnabled(true);
                clearButton.setEnabled(true);

                searchButton.setEnabled(false);
                addButton.setEnabled(false);
            }


            public void addToDatabase() {
                DBHandler db = new DBHandler(this);

                Student s = new Student(ID.getText().toString(),
                        firstName.getText().toString(),
                        lastName.getText().toString(),
                        contact.getText().toString(),
                        address.getText().toString());

                String res = db.addStudent(s);

                Toast.makeText(this, res, Toast.LENGTH_LONG).show();
                clear();
                firstName.setEnabled(false);
                lastName.setEnabled(false);
                contact.setEnabled(false);
                address.setEnabled(false);
            }


            public void clear() {
                ID.setText("");
                firstName.setText("");
                lastName.setText("");
                contact.setText("");
                address.setText("");
                clearButton.setEnabled(false);
                saveButton.setEnabled(false);
                searchButton.setEnabled(true);
                addButton.setEnabled(true);

            }



}

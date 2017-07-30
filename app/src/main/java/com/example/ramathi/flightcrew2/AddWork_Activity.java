package com.example.ramathi.flightcrew2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Tharindu Wanninayake on 7/27/2017.
 */

public class AddWork_Activity extends AppCompatActivity {
    private EditText userId;
    private EditText workId;
    private EditText workName;
    private EditText date;
    private EditText time;
    private Button add;
    private TextView mConditionTextView;
    private String email;


    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    //for testing
    DatabaseReference mConditionRef = mRootRef.child("condition");


    DatabaseReference addWorkAdmin = mRootRef.child("AddWork");
    DatabaseReference users = addWorkAdmin.child("userID");
    DatabaseReference datedb = users.child("date");
    DatabaseReference timedb = users.child("time");
    DatabaseReference workIDdb = users.child("workID");
    DatabaseReference workdb = users.child("work");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addwork_layout);



        userId = (EditText) findViewById(R.id.userId);
        workId = (EditText) findViewById(R.id.workId);
        workName = (EditText) findViewById(R.id.workName);
        date = (EditText) findViewById(R.id.inputDate);
        time = (EditText) findViewById(R.id.inputTime);
        mConditionTextView = (TextView) findViewById(R.id.textViewCondition);
        add = (Button) findViewById(R.id.addWork);


    }


    @Override
    protected void onStart() {
        super.onStart();

        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mConditionTextView.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CurrentUser sessionEmail = new CurrentUser();
                email = sessionEmail.getCurrentUserEmail();

                mConditionRef.setValue(email);
                datedb.setValue(date.getText().toString());
                timedb.setValue(time.getText().toString());
                workIDdb.setValue(workId.getText().toString());
                workdb.setValue(workName.getText().toString());

            }
        });

    }

}

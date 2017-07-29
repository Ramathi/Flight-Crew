package com.example.ramathi.flightcrew2;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by TharinduWanninayake on 7/26/2017.
 */

public class AdminHome_Activity extends AppCompatActivity {
    private Button addWork;
    private Button approval;
    private Button userDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhome_layout);

        addWork = (Button) findViewById(R.id.addWork);
        approval = (Button) findViewById(R.id.approvals);
        userDB = (Button) findViewById(R.id.userDB);

        addWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addWork = new Intent(getApplicationContext(), AddWork_Activity.class);
                startActivity(addWork);
            }
        });

        approval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apprl = new Intent(getApplicationContext(), AdminApproval_Activity.class);
                startActivity(apprl);
            }
        });

        userDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userDBStart = new Intent(getApplicationContext(), ViewUserDB_Activity.class);
                startActivity(userDBStart);
            }
        });
    }
}

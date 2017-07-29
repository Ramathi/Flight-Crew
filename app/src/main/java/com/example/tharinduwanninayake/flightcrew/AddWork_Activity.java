package com.example.tharinduwanninayake.flightcrew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tharindu Wanninayake on 7/27/2017.
 */

public class AddWork_Activity extends AppCompatActivity {

    private EditText userId;
    private EditText work;
    private EditText workId;
    private EditText date;
    private EditText time;
    private Button addWork;
    private Button addWorkAdmin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addwork_layout);

        userId = (EditText) findViewById(R.id.addUserId);
        work = (EditText) findViewById(R.id.addWork);
        workId = (EditText) findViewById(R.id.addWorkId);
        date = (EditText) findViewById(R.id.addDate);
        time = (EditText) findViewById(R.id.addTime);

        addWork = (Button) findViewById(R.id.addWorkbtn);
        addWorkAdmin = (Button) findViewById(R.id.addWorkAdminbtn);

        addWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //json connect server-db
            }
        });

        addWorkAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ramathigen ahanna
            }
        });






    }
}

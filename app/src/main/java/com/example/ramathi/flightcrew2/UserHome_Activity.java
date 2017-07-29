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

public class UserHome_Activity extends AppCompatActivity {
    private Button viewWork;
    private Button viewHistory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhome_layout);


        viewWork = (Button) findViewById(R.id.userWorkFlow);
        viewHistory = (Button) findViewById(R.id.workHistory);

        viewWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent viewWork = new Intent(getApplicationContext(), UserWork_activity.class);
                startActivity(viewWork);
            }
        });

        viewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(getApplicationContext(), ViewUserWork_Activity.class);
                startActivity(history);
            }
        });
    }
}

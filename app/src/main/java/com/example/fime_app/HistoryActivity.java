package com.example.fime_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.History);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.Setting:
                        startActivity(new Intent(getApplicationContext(), Setting_tips.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.History:
                        return true;
                    case R.id.Search:
                        startActivity(new Intent(getApplicationContext(), game_selection.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.Ongoing:
                        startActivity(new Intent(getApplicationContext(),OngoingActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}



package com.example.fime_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fime_app.databinding.OngoingActivityBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.storage.StorageReference;

public class OngoingActivity extends AppCompatActivity {

    OngoingActivityBinding binding;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ongoing_activity);
        binding = OngoingActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ImageButton ImageButton = findViewById(R.id.scrllviewbox);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.Ongoing);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.Setting:
                        startActivity(new Intent(getApplicationContext(), Setting_tips.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.History:
                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Search:
                        startActivity(new Intent(getApplicationContext(), game_selection.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Ongoing:
                        return true;
                }
                return false;
            }
        });
    }
}

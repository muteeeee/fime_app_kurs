package com.example.fime_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class game_selection extends AppCompatActivity {

    private Spinner processorSpinner, graphicsCardSpinner, ramSpinner, operatingSystemSpinner;
    private Button findGamesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameselection);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.Search);

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
                        return true;
                    case R.id.Ongoing:
                        startActivity(new Intent(getApplicationContext(), OngoingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        processorSpinner = findViewById(R.id.processorSpinner);
        graphicsCardSpinner = findViewById(R.id.graphicsCardSpinner);
        ramSpinner = findViewById(R.id.ramSpinner);
        operatingSystemSpinner = findViewById(R.id.operatingSystemSpinner);
        findGamesButton = findViewById(R.id.findGamesButton);

        setupSpinners();

        findGamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(game_selection.this, ResultActivity.class);
                intent.putExtra("processor", processorSpinner.getSelectedItem().toString());
                intent.putExtra("graphicsCard", graphicsCardSpinner.getSelectedItem().toString());
                intent.putExtra("ram", ramSpinner.getSelectedItem().toString());
                intent.putExtra("operatingSystem", operatingSystemSpinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> processorAdapter = ArrayAdapter.createFromResource(this,
                R.array.processors_array, android.R.layout.simple_spinner_item);
        processorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        processorSpinner.setAdapter(processorAdapter);

        ArrayAdapter<CharSequence> graphicsCardAdapter = ArrayAdapter.createFromResource(this,
                R.array.graphics_cards_array, android.R.layout.simple_spinner_item);
        graphicsCardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphicsCardSpinner.setAdapter(graphicsCardAdapter);

        ArrayAdapter<CharSequence> ramAdapter = ArrayAdapter.createFromResource(this,
                R.array.ram_array, android.R.layout.simple_spinner_item);
        ramAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ramSpinner.setAdapter(ramAdapter);

        ArrayAdapter<CharSequence> operatingSystemAdapter = ArrayAdapter.createFromResource(this,
                R.array.operating_systems_array, android.R.layout.simple_spinner_item);
        operatingSystemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operatingSystemSpinner.setAdapter(operatingSystemAdapter);
    }
}

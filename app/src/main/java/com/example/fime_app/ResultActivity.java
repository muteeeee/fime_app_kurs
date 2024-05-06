package com.example.fime_app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    Spinner genreSpinner;
    Spinner yearSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        genreSpinner = findViewById(R.id.genreSpinner);
        yearSpinner = findViewById(R.id.yearSpinner);

        ArrayAdapter<CharSequence> genreAdapter = ArrayAdapter.createFromResource(this, R.array.genres_array, android.R.layout.simple_spinner_item);
        genreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genreSpinner.setAdapter(genreAdapter);

        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this, R.array.years_array, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateFilteredGames();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateFilteredGames();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на GameSelectionActivity
                Intent intent = new Intent(ResultActivity.this, game_selection.class);
                startActivity(intent);
            }
        });
    }

    private void updateFilteredGames() {
        String selectedGenre = genreSpinner.getSelectedItem().toString();
        String selectedYear = yearSpinner.getSelectedItem().toString();
        String selectedProcessor = getIntent().getStringExtra("processor");
        String selectedGraphicsCard = getIntent().getStringExtra("graphicsCard");
        String selectedRAM = getIntent().getStringExtra("ram");
        String selectedOperatingSystem = getIntent().getStringExtra("operatingSystem");
        boolean sortByYearAscending = !selectedYear.equals("Не выбрано") && selectedYear.equals("Ascending");

        displayGamesByGenreAndYear(selectedGenre, selectedYear, selectedProcessor, selectedGraphicsCard, selectedRAM, selectedOperatingSystem, sortByYearAscending);
    }

    private void displayGamesByGenreAndYear(String selectedGenre, String selectedYear, String selectedProcessor, String selectedGraphicsCard, String selectedRAM, String selectedOperatingSystem, boolean sortByYearAscending) {
        List<Game> games = Game_selector.findMatchingGames(selectedProcessor, selectedGraphicsCard, selectedRAM, selectedOperatingSystem);

        // Фильтрация по жанру
        List<Game> filteredGamesByGenre = new ArrayList<>();
        for (Game game : games) {
            if (selectedGenre.equals("Не выбрано") || game.getGenre().equalsIgnoreCase(selectedGenre)) {
                filteredGamesByGenre.add(game);
            }
        }

        // Фильтрация по году выпуска
        List<Game> filteredGamesByYear = new ArrayList<>();
        for (Game game : filteredGamesByGenre) {
            if (selectedYear.equals("Не выбрано") || String.valueOf(game.getReleaseYear()).equals(selectedYear)) {
                filteredGamesByYear.add(game);
            }
        }

        // Сортировка по году выпуска
        if (!selectedYear.equals("Не выбрано") && !selectedYear.equals("Жанр не выбран")) {
            if (!sortByYearAscending) {
                Collections.sort(filteredGamesByYear, (game1, game2) -> game2.getReleaseYear() - game1.getReleaseYear());
            } else {
                Collections.sort(filteredGamesByYear, Comparator.comparingInt(Game::getReleaseYear));
            }
        }

        LinearLayout verticalLinearLayout = findViewById(R.id.verticalLinearLayout);
        verticalLinearLayout.removeAllViews();

        LinearLayout rowLinearLayout = null;
        int gamesInRow = 0;
        for (final Game matchingGame : filteredGamesByYear) {
            ImageView imageView = new ImageView(this);
            int imageResourceId = getResources().getIdentifier(matchingGame.getName().toLowerCase(), "drawable", getPackageName());
            if (imageResourceId != 0) {
                imageView.setImageResource(imageResourceId);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(450, 450);
                params.setMargins(40, 40, 40, 0);
                imageView.setLayoutParams(params);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String gameUrl = matchingGame.getUrl();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(gameUrl));
                        startActivity(intent);
                    }
                });

                if (gamesInRow == 0) {
                    rowLinearLayout = new LinearLayout(this);
                    rowLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    rowLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    rowLinearLayout.setGravity(Gravity.CENTER);
                    verticalLinearLayout.addView(rowLinearLayout);
                }

                if (rowLinearLayout != null) {
                    rowLinearLayout.addView(imageView);

                    gamesInRow++;
                    if (gamesInRow == 2) {
                        gamesInRow = 0;
                    }
                }
            }
        }
    }
}

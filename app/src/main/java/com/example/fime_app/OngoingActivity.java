package com.example.fime_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OngoingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ongoing_activity);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.Ongoing);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.Setting:
                        startActivity(new Intent(getApplicationContext(), Setting_tips.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.Search:
                        startActivity(new Intent(getApplicationContext(), game_selection.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.Ongoing:
                        return true;
                }
                return false;
            }
        });
        GameInfo gta6 = new GameInfo("Grand Theft Auto 6", "Grand Theft Auto 6 переносит нас в песчаные пляжи и пальмовые аллеи вымышленного штата Леонида, вдохновлённого солнечной Флоридой. Действие разворачивается в огромном открытом мире, центром которого является мегаполис Вайс-Сити со своими небоскрёбами, казино и фешенебельными кварталами.\n" +
                "\n", "2026", "Rockstar North");
        GameInfo stalker2 = new GameInfo("S.T.A.L.K.E.R. 2: Heart of Chornobyl", "Возьмите на себя роль сталкера по имени Скиф и напишите собственную историю, проходя сюжетную кампанию с разнообразными вариантами развития, которые определят вашу судьбу в конце. \n" +
                "\n", "05.09.2024", "GSC Game World");
        GameInfo TES6 = new GameInfo("The Elder Scrolls 6", "Предстоящая компьютерная игра в жанре Action/RPG с открытым миром, разрабатываемая студией Bethesda Game Studios и планируемая к выпуску компанией Bethesda Softworks.", "2028", "Bethesda Softworks");
        GameInfo DeathStranding2 = new GameInfo("Death Stranding 2: On the Beach", "Продолжение научно-фантастического приключенческого экшена Death Stranding." +
                "Чтобы спасти человечество, Сэм вместе с верными спутниками отправляется в опасное путешествие на поиски ответов. Им предстоит пересечь постапокалиптическую Америку, изменившуюся до неузнаваемости из-за аномалий.", "2025", "Kojima Productions");
        GameInfo  AssassinscodenameRED= new GameInfo("Assassin's Creed: Codename RED", "Новая игра серии Assassins Creed в долгожданном сеттинге феодальной Японии. В игре будет сделан большой упор на RPG-элементы и онлайн-составляющую.", "2025", "Ubisoft Quebec");
        GameInfo HumanFallFlat2 = new GameInfo("Human Fall Flat 2", "Продолжение популярного платформера, в котором вы снова управляете неуклюжим человечком, пытающимся пройти разные уровни, полные головоломок и препятствий. На этот раз вы можете играть вместе с друзьями в составе команды из восьми человек.", "2026", "No Brakes Games");
        GameInfo Zarya = new GameInfo("Zarya", "В этой игре вы окунётесь в атмосферу постсоветской глубинки и примерите на себя роль сельского водителя. Стоит отметить, что не просто симулятор вождения, но и история о жизни людей, далёких от суеты больших городов. Вам суждено стать частью этого мира, наполненного аутентичными деталями нашей родины.", "2025", "SBSR");

        ImageButton scrllviewbox = findViewById(R.id.scrllviewbox);
        ImageButton scrllviewbox1 = findViewById(R.id.scrllviewbox1);
        ImageButton scrllviewbox2 = findViewById(R.id.scrllviewbox2);
        ImageButton scrllviewbox3 = findViewById(R.id.scrllviewbox3);
        ImageButton scrllviewbox4 = findViewById(R.id.scrllviewbox4);
        ImageButton scrllviewbox5 = findViewById(R.id.scrllviewbox5);
        ImageButton scrllviewbox6 = findViewById(R.id.scrllviewbox6);

        final RelativeLayout gameInfoLayout = findViewById(R.id.game_info_layout);
        final TextView gameTitle = findViewById(R.id.game_title);
        final TextView gameDescription = findViewById(R.id.game_description);
        final TextView gameReleaseDate = findViewById(R.id.game_release_date);
        final TextView gameDeveloper = findViewById(R.id.game_developer);

        scrllviewbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfoLayout.setVisibility(View.VISIBLE);
                gameTitle.setText(gta6.getTitle());
                gameDescription.setText(gta6.getDescription());
                gameReleaseDate.setText(gta6.getReleaseDate());
                gameDeveloper.setText(gta6.getDeveloper());
            }
        });

        scrllviewbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfoLayout.setVisibility(View.VISIBLE);
                gameTitle.setText(stalker2.getTitle());
                gameDescription.setText(stalker2.getDescription());
                gameReleaseDate.setText(stalker2.getReleaseDate());
                gameDeveloper.setText(stalker2.getDeveloper());
            }
        });

        scrllviewbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfoLayout.setVisibility(View.VISIBLE);
                gameTitle.setText(TES6.getTitle());
                gameDescription.setText(TES6.getDescription());
                gameReleaseDate.setText(TES6.getReleaseDate());
                gameDeveloper.setText(TES6.getDeveloper());
            }
        });

        scrllviewbox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfoLayout.setVisibility(View.VISIBLE);
                gameTitle.setText(DeathStranding2.getTitle());
                gameDescription.setText(DeathStranding2.getDescription());
                gameReleaseDate.setText(DeathStranding2.getReleaseDate());
                gameDeveloper.setText(DeathStranding2.getDeveloper());
            }
        });

        scrllviewbox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfoLayout.setVisibility(View.VISIBLE);
                gameTitle.setText(AssassinscodenameRED.getTitle());
                gameDescription.setText(AssassinscodenameRED.getDescription());
                gameReleaseDate.setText(AssassinscodenameRED.getReleaseDate());
                gameDeveloper.setText(AssassinscodenameRED.getDeveloper());
            }
        });

        scrllviewbox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfoLayout.setVisibility(View.VISIBLE);
                gameTitle.setText(HumanFallFlat2.getTitle());
                gameDescription.setText(HumanFallFlat2.getDescription());
                gameReleaseDate.setText(HumanFallFlat2.getReleaseDate());
                gameDeveloper.setText(HumanFallFlat2.getDeveloper());
            }
        });

        scrllviewbox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfoLayout.setVisibility(View.VISIBLE);
                gameTitle.setText(Zarya.getTitle());
                gameDescription.setText(Zarya.getDescription());
                gameReleaseDate.setText(Zarya.getReleaseDate());
                gameDeveloper.setText(Zarya.getDeveloper());
            }
        });
    }
}

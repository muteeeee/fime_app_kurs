package com.example.fime_app;

import java.util.ArrayList;
import java.util.List;

public class Game_selector {

    public static List<Game> findMatchingGames(String selectedProcessor, String selectedGraphicsCard, String selectedRAM, String selectedOperatingSystem) {
        List<Game> games = getGames();
        List<Game> matchingGames = new ArrayList<>();

        for (Game game : games) {
            if (game.matches(selectedProcessor, selectedGraphicsCard, selectedRAM, selectedOperatingSystem)) {
                matchingGames.add(game);
            }
        }

        return matchingGames;
    }

    public static List<Game> getGames() {
        List<Game> games = new ArrayList<>();
        games.add(new Game("valorant_i", 3, 3, 2, 1 | 2 , "https://store.epicgames.com/ru/p/valorant", "FPS Shooter", 2020));
        games.add(new Game("fallguys_i", 1, 1, 1, 1 | 2 , "https://store.epicgames.com/ru/p/fall-guys", "Arcade game", 2020));
        games.add(new Game("watchdogslegion_i", 4, 5, 3|2, 1 | 2 , "https://www.ubisoft.com/ru-ru/game/watch-dogs/legion", "Action-adventure", 2020));
        games.add(new Game("deathstranding_i", 6, 5, 3|2, 1 | 2 , "https://deathstrandingpc.505games.com/en/", "Action-adventure", 2020));
        games.add(new Game("apexlegends_i", 5, 4, 3|2, 1 | 2 , "https://www.ea.com/ru-ru/games/apex-legends/about", "FPS Shooter", 2020));
        games.add(new Game("cyberpunk2077_i", 5, 4, 3|2, 1 | 2, "https://steamcommunity.com/app/1091500", "RPG", 2020));
        games.add(new Game("farcry6_i", 3, 2, 3, 1 | 2 , "https://www.ubisoft.com/ru-ru/game/far-cry/far-cry-6", "FPS Shooter", 2021));
        games.add(new Game("battlefield2042_i", 3, 2, 3, 1 | 2 , "https://www.ea.com/games/battlefield/battlefield-2042?isLocalized=true", "FPS Shooter", 2021));
        games.add(new Game("hitman3_i", 3, 4, 3, 1 | 2 , "https://store.steampowered.com/agecheck/app/1659040/?ref=dtf.ru", "Stealth action", 2021));
        games.add(new Game("residentevilvillage_i", 7|6, 7|6, 3, 1 | 2 , "https://www.residentevil.com/village/", "Survival horror", 2021));
        games.add(new Game("fortnite_i", 5, 5, 3|2, 1 | 2 , "https://store.epicgames.com/ru/p/fortnite", "Battle royale", 2017));
        games.add(new Game("destiny2_i", 4|3, 3, 3, 1 | 2 , "https://store.steampowered.com/app/1085660/Destiny_2/", "FPS Shooter", 2017));
        games.add(new Game("reddeadredemption2_i", 6|5, 6|5, 3, 1 | 2 , "https://steamcommunity.com/app/1174180", "FPS Shooter", 2018));
        games.add(new Game("battlefield5_i", 2, 1, 3|2, 1 | 2 , "https://store.steampowered.com/app/1238810/Battlefield_V/", "FPS Shooter", 2018));
        games.add(new Game("control_i", 4|3, 4|3, 3|2, 1 | 2 , "https://www.remedygames.com/games/control", "Action-adventure", 2019));
        games.add(new Game("starwarsjedi_i", 6, 5|6, 3, 1 | 2 , "https://www.starwars.com/games-apps/star-wars-jedi-fallen-order", "Action-adventure", 2019));
        games.add(new Game("overwatch_i", 4, 3, 3|2, 1 | 2 , "https://overwatch.blizzard.com/ru-ru/", "FPS Shooter", 2016));
        games.add(new Game("assasinscreed_i", 1, 2, 3|2, 1 | 2 , "https://www.ubisoft.com/en-gb/game/assassins-creed", "RPG", 2016));
        games.add(new Game("counterstrike2_i", 2, 3, 3|2, 1 | 2 , "https://store.steampowered.com/agecheck/app/730/", "FPS Shooter", 2023));
        games.add(new Game("doometernal_i", 3, 2, 3|2, 1 | 2 , "https://bethesda.net/en/game/doom", "FPS Shooter", 2023));
        games.add(new Game("tomclancysghostreconbreakpoint_i", 6, 5, 3, 1 | 2 , "https://www.ubisoft.com/ru-ru/game/ghost-recon/breakpoint", "FPS Shooter", 2023));
        games.add(new Game("rocketleague_i", 2, 1, 1, 1 | 2 , "https://store.epicgames.com/ru/p/rocket-league", "Football", 2015));
        games.add(new Game("thewitcher3_i", 3|2, 3|2, 2, 1 | 2 , "https://www.thewitcher.com/ru/ru/witcher3", "RPG", 2015));
        games.add(new Game("rainbowsixsiege_i", 3, 2, 3, 1 | 2 , "https://www.ubisoft.com/ru-ru/game/rainbow-six/siege", "FPS Shooter", 2015));
        games.add(new Game("grandtheftauto5_i", 3, 1, 2, 1 | 2 , "https://steamcommunity.com/app/271590", "Action-adventure", 2013));
        games.add(new Game("dota2_i", 3, 2, 3, 1 | 2 , "https://store.steampowered.com/app/570", "MOBA", 2013));
        games.add(new Game("callofduty_i", 2, 1, 2, 1 | 2 , "https://store.steampowered.com/app/2630", "FPS Shooter", 2005));
        games.add(new Game("halflife_i", 1, 1, 1, 1 | 2 , "https://store.steampowered.com/app/70", "FPS Shooter", 2000));
        games.add(new Game("leagueoflegends_i", 2, 2, 2, 1 | 2 , "https://play.na.leagueoflegends.com/en_US", "MOBA", 2009));
        games.add(new Game("minecraft_i", 2|1, 2|3, 2|3, 1 | 2 , "https://www.minecraft.net/", "Sandbox", 2011));
        games.add(new Game("helldivers2_i", 5|4, 2|3, 3, 1 | 2 , "https://store.steampowered.com/app/553850/HELLDIVERS_2", "Action-adventure", 2023));

        return games;
    }
}

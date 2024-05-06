package com.example.fime_app;

public class GameInfo {
    private String title;
    private String description;
    private String releaseDate;
    private String developer;

    public GameInfo(String title, String description, String releaseDate, String developer) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.developer = developer;

    }

    // Геттеры и сеттеры для каждого поля
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}

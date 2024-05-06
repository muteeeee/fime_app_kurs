package com.example.fime_app;

public class Game {

    private String name;
    private int processorRequirement;
    private int graphicsCardRequirement;
    private int ramRequirement;
    private int operatingSystemRequirement;
    private String url;
    private String genre;
    private int releaseYear;

    public Game(String name, int processorRequirement, int graphicsCardRequirement, int ramRequirement, int operatingSystemRequirement, String url, String genre, int releaseYear) {
        this.name = name;
        this.processorRequirement = processorRequirement;
        this.graphicsCardRequirement = graphicsCardRequirement;
        this.ramRequirement = ramRequirement;
        this.operatingSystemRequirement = operatingSystemRequirement;
        this.url = url;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public int getProcessorRequirement() {
        return processorRequirement;
    }

    public int getGraphicsCardRequirement() {
        return graphicsCardRequirement;
    }

    public int getRamRequirement() {
        return ramRequirement;
    }

    public int getOperatingSystemRequirement() {
        return operatingSystemRequirement;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getUrl() {
        return url;
    }

    public int getRequirementLevel() {
        return processorRequirement + graphicsCardRequirement + ramRequirement + operatingSystemRequirement;
    }

    private boolean isOperatingSystemSupported(int selectedOperatingSystemValue) {
        return (operatingSystemRequirement & selectedOperatingSystemValue) != 0;
    }

    public boolean matches(String processor, String graphicsCard, String ram, String operatingSystem) {
        int selectedProcessorValue = getProcessorValue(processor);
        int selectedGraphicsCardValue = getGraphicsCardValue(graphicsCard);
        int selectedRamValue = getRamValue(ram);
        int selectedOperatingSystemValue = getOperatingSystemValue(operatingSystem);

        return selectedProcessorValue >= processorRequirement &&
                selectedGraphicsCardValue >= graphicsCardRequirement &&
                selectedRamValue >= ramRequirement &&
                isOperatingSystemSupported(selectedOperatingSystemValue);
    }

    private int getProcessorValue(String processor) {
        switch (processor) {
            case "AMD Ryzen 5 3600":
                return 1;
            case " Intel Core i3-10100F":
                return 2;
            case "AMD Ryzen 5 2600":
                return 3;
            case "Intel Core i5-11400F":
                return 4;
            case "AMD Ryzen 5 5600X":
                return 5;
            case "Intel Core i7-11700KF":
                return 6;
            case "AMD Ryzen 7 5800X":
                return 7;
            case "Intel Core i5-12600KF":
                return 8;
            case "AMD Ryzen 9 5950X":
                return 9;
            case "Intel Core i9-12900KF":
                return 10;
            default:
                return 0;
        }
    }

    private int getGraphicsCardValue(String graphicsCard) {
        switch (graphicsCard) {
            case "GeForce GTX 1050 Ti":
                return 1;
            case "GeForce GTX 1660 Super":
                return 2;
            case "GeForce RTX 2060 Super":
                return 3;
            case "GeForce RTX 3050":
                return 4;
            case "GeForce RTX 3060":
                return 5;
            case "Radeon RX 6650 XT":
                return 6;
            case "GeForce RTX 3070 TI":
                return 7;
            case "GeForce RTX 3080 Ti":
                return 8;
            case "GeForce RTX 4080 SUPER":
                return 9;
            case "GeForce RTX 4090":
                return 10;

            default:
                return 0;
        }
    }

    private int getRamValue(String ram) {
        switch (ram) {
            case "4GB":
                return 1;
            case "8GB":
                return 2;
            case "16GB":
                return 3;
            case "32GB":
                return 4;
            case "64GB":
                return 5;
            default:
                return 0;
        }
    }

    private int getOperatingSystemValue(String operatingSystem) {
        switch (operatingSystem) {
            case "Windows":
                return 1;
            case "Linux":
                return 2;
            default:
                return 0;
        }
    }
}

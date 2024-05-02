package com.example.fime_app;

public class    Game {

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
            case "INTEL CORE I3":
                return 1;
            case "INTEL CORE I5":
                return 2;
            case "INTEL CORE I7":
                return 3;
            default:
                return 0;
        }
    }

    private int getGraphicsCardValue(String graphicsCard) {
        switch (graphicsCard) {
            case "GTX 1050":
                return 1;
            case "GTX 1660":
                return 2;
            case "RTX 3060":
                return 3;
            case "RTX 4090":
                return 4;
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
            case "macOS":
                return 3;
            default:
                return 0;
        }
    }
}

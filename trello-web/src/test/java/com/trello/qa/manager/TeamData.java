package com.trello.qa.manager;

public class TeamData {
    private final String teamName;
    private final String description;

    public TeamData(String teamName, String description) {
        this.teamName = teamName;
        this.description = description;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }
}

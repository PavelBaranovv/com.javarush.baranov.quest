package com.javarush.baranov.quest.gameLogic;

public class Player {
    private final String name;
    private int gamesCount;

    Player(String name) {
        this.name = name;
        this.gamesCount = 0;
    }

    public void incrementGamesCount() {
        gamesCount++;
    }

    public String getName() {
        return name;
    }

    public int getGamesCount() {
        return gamesCount;
    }
}

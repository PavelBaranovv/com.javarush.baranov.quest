package com.javarush.baranov.quest.gameLogic;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int gamesCount;

    public Player() {
        this.name = null;
        this.gamesCount = 0;
    }

    public void incrementGamesCount() {
        gamesCount++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGamesCount() {
        return gamesCount;
    }
}

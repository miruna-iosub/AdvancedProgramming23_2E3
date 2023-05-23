package com.compulsory;

public class Player {
    public int playerColor;

    public Player(int playerColor) {
        this.playerColor = playerColor;
    }

    public int getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(int playerColor) {
        this.playerColor = playerColor;
    }

    @Override
    public String toString() {
        return "Player{" + "playerColor=" + playerColor + '}';
    }
}
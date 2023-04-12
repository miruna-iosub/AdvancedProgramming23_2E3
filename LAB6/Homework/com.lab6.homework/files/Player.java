package com.lab6.homework.files;

public class Player {
    private String playerName;
    private Color playerColor;
    public Player() {}
    public Player(String playerName, Color playerColor) {
        this.playerName = playerName;
        this.playerColor = playerColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public javafx.scene.paint.Color getColor() {
        return playerColor == Color.GREEN ? javafx.scene.paint.Color.GREEN : javafx.scene.paint.Color.YELLOW;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    @Override
    public String toString() {
        return "Player{" + "playerName='" + playerName + '\'' + '}';
    }
}
package com.lab6.homework.files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private Player nextPlayerToMove;
    private Player firstPlayerToMove;
    private Integer numberOfDots;
    private Double lineProbability;
    private final Map<Line, Player> playerMoves;
    private List<Line> blackLines;
    private final Map<String, List<SerializedLine>> playerMovesSerialized;
    private final List<SerializedLine> blackLinesSerialized;

    public Game() {
        this.playerMoves = new HashMap<>();
        this.playerMovesSerialized = new HashMap<>();
        this.blackLines = new ArrayList<>();
        this.blackLinesSerialized = new ArrayList<>();
    }

    public Map<Line, Player> getPlayerMoves() {
        return playerMoves;
    }

    public Double getLineProbability() {
        return lineProbability;
    }

    public void setLineProbability(Double lineProbability) {
        this.lineProbability = lineProbability;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Game(Player player1, Player player2, Integer dots, Double lineProbability) {
        this();
        this.playerOne = player1;
        this.playerTwo = player2;
        this.numberOfDots = dots;
        this.lineProbability = lineProbability;

        firstPlayerToMove = player1.getColor() == Color.GREEN ? player1 : player2;
        nextPlayerToMove = player1.getColor() == Color.YELLOW ? player1 : player2;
    }

    public Player getFirstPlayerToMove() {
        return firstPlayerToMove;
    }

    public void addMove(Line line, Player currentPlayer) {
        if (currentPlayer.equals(playerOne)) {
            nextPlayerToMove = playerTwo;
        } else if (currentPlayer.equals(playerTwo)) {
            nextPlayerToMove = playerOne;
        }

        playerMoves.put(line, currentPlayer);
    }

    public Player nextPlayerToMove() {
        return nextPlayerToMove;
    }

    public boolean checkFirstMove() {
        return this.playerMoves.size() == 0;
    }

    public boolean validMove(Line line) {
        return playerMoves.containsKey(line);
    }

    public boolean displayWinner(Player currentPlayer) {
        List<Line> currentPlayerMoves = new ArrayList<>();

        for (Line line : playerMoves.keySet()) {
            if (playerMoves.get(line) == currentPlayer) {
                currentPlayerMoves.add(line);
            }
        }

        boolean shapeFound = checkShape(currentPlayerMoves);
        if (shapeFound) {
            resetGame();
        }

        return shapeFound;
    }

    public Integer getNumberOfDots() {
        return numberOfDots;
    }

    public void setNumberOfDots(Integer numberOfDots) {
        this.numberOfDots = numberOfDots;
    }

    public void resetGame() {
        this.playerMoves.clear();
        this.playerTwo = null;
        this.playerOne = null;
        this.firstPlayerToMove = null;
        this.nextPlayerToMove = null;
        this.playerMovesSerialized.clear();
    }

    private boolean checkShape(List<Line> lines) {
        // Check all possible combinations of 3 lines
        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                for (int k = j + 1; k < lines.size(); k++) {
                    Line line1 = lines.get(i);
                    Line line2 = lines.get(j);
                    Line line3 = lines.get(k);

                    // Check if all three lines intersect at the same point
                    if (linesIntersect(line1, line2) && linesIntersect(line1, line3) && linesIntersect(line2, line3)) {
                        return true;
                    }
                }
            }
        }
        // If no triangle was found, return false
        return false;
    }

    private boolean linesIntersect(Line line1, Line line2) {
        double x1 = line1.getStartX();
        double y1 = line1.getStartY();
        double x2 = line1.getEndX();
        double y2 = line1.getEndY();

        double x3 = line2.getStartX();
        double y3 = line2.getStartY();
        double x4 = line2.getEndX();
        double y4 = line2.getEndY();

        double crossProduct1 = crossProduct(x3-x1, y3-y1, x2-x1, y2-y1);
        double crossProduct2 = crossProduct(x4-x1, y4-y1, x2-x1, y2-y1);
        double crossProduct3 = crossProduct(x1-x3, y1-y3, x4-x3, y4-y3);
        double crossProduct4 = crossProduct(x2-x3, y2-y3, x4-x3, y4-y3);

        return crossProduct1 * crossProduct2 < 0 && crossProduct3 * crossProduct4 < 0;
    }

    private double crossProduct(double x1, double y1, double x2, double y2) {
        return x1*y2 - x2*y1;
    }
    public void saveState() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gameAsJson = gson.toJson(this);

        try (PrintWriter out = new PrintWriter(new FileWriter("game.json"))) {
            out.write(gameAsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setNextPlayerToMove(Player nextPlayerToMove) {
        this.nextPlayerToMove = nextPlayerToMove;
    }

    public void setFirstPlayerToMove(Player firstPlayerToMove) {
        this.firstPlayerToMove = firstPlayerToMove;
    }

    public Map<String, List<SerializedLine>> getPlayerMovesSerialized() {
        return playerMovesSerialized;
    }

    public void loadState() {
        Gson gson = new Gson();

        try {
            FileReader fileReader = new FileReader("game.json");
            Game gameDeserialized = gson.fromJson(fileReader, Game.class);

            // Copy values from deserialized game to current game
            playerOne = gameDeserialized.getPlayerOne();
            playerTwo = gameDeserialized.getPlayerTwo();
            firstPlayerToMove = gameDeserialized.getFirstPlayerToMove();
            nextPlayerToMove = gameDeserialized.nextPlayerToMove();
            numberOfDots = gameDeserialized.getNumberOfDots();

            // Re-create lines from serialized lines and add to appropriate maps
            for (Map.Entry<String, List<SerializedLine>> entry : gameDeserialized.getPlayerMovesSerialized().entrySet()) {
                Player player = entry.getKey().equals(playerOne.getPlayerName()) ? playerOne : playerTwo;
                for (SerializedLine serializedLine : entry.getValue()) {
                    Line line = serializedLine.lineEnd();
                    playerMoves.put(line, player);
                }
            }

            for (SerializedLine serializedLine : gameDeserialized.getBlackLinesSerialized()) {
                blackLines.add(serializedLine.lineEnd());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Line> getBlackLines() {
        return blackLines;
    }

    public void setBlackLines(List<Line> blackLines) {
        this.blackLines = blackLines;
    }

    public List<SerializedLine> getBlackLinesSerialized() {
        return blackLinesSerialized;
    }

    @Override
    public String toString() {
        return "Game{" + "playerOne=" + playerOne + ", playerTwo=" + playerTwo + ", nextPlayerToMove=" + nextPlayerToMove + ", firstPlayerToMove=" + firstPlayerToMove + '}';
    }
}
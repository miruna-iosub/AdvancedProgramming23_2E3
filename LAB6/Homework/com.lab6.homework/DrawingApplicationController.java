package com.lab6.homework;

import com.lab6.homework.files.Game;
import com.lab6.homework.files.Player;
import com.lab6.homework.files.Color;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class DrawingApplicationController {
    public ComboBox<Double> lineProbabilityCombo;
    public Spinner<Integer> numberOfDotsSpinner;
    public Canvas canvasPaneId;
    public TextArea greenPlayerName;
    public TextArea yellowPlayerName;
    public Group canvasGroupRoot;
    public TextArea playerToMoveName;

    private Game game;

    @FXML
    public void initialize() {
        lineProbabilityCombo.getItems().removeAll(lineProbabilityCombo.getItems());
        lineProbabilityCombo.getItems().addAll(0.0, 0.15, 0.25, 0.35, 0.5, 0.65, 0.75, 1.0);
        lineProbabilityCombo.getSelectionModel().select(1.0);
        numberOfDotsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10));
    }

    public void handleLoadButtonClick(MouseEvent mouseEvent) {
        handleResetButtonClick(mouseEvent);

        game.loadState();

        Integer dotsNumber = game.getNumberOfDots();
        Map<Line, Player> playerMoves = game.getPlayerMoves();
        drawDots(dotsNumber);

        for (Line blackLine : game.getBlackLines()) {
            blackLine.setStroke(javafx.scene.paint.Color.BLACK);
            blackLine.setStrokeWidth(8);
            canvasGroupRoot.getChildren().add(blackLine);
            blackLine.addEventHandler(MouseEvent.MOUSE_PRESSED, getEventHandlers());
        }

        for (Map.Entry<Line, Player> entry : playerMoves.entrySet()) {
            Line line = entry.getKey();
            Player player = entry.getValue();
            line.setStroke(player.getColor());
            line.setStrokeWidth(5);
            canvasGroupRoot.getChildren().add(line);
        }

        playerToMoveName.setText(game.nextPlayerToMove().getPlayerName());
    }

    private List<Line> blackLines(Integer dotsNumber, List<Circle> dots) {
        List<Line> lines = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < dotsNumber; i++) {
            for (int j = i + 1; j < dotsNumber; j++) {
                if (rand.nextDouble() <= lineProbabilityCombo.getValue()) {
                    Line line = new Line(dots.get(i).getCenterX(), dots.get(i).getCenterY(), dots.get(j).getCenterX(), dots.get(j).getCenterY());
                    line.setStroke(javafx.scene.paint.Color.BLACK);
                    line.setStrokeWidth(8);
                    canvasGroupRoot.getChildren().add(line);
                    lines.add(line);
                }
            }
        }
        return lines;
    }

    private List<Circle> drawDots(Integer dotsNumber) {
        double centerX = canvasPaneId.getWidth() / 2;
        double centerY = canvasPaneId.getHeight() / 1.7;

        // Create a list to hold the dots
        List<Circle> dots = new ArrayList<>();

        // Calculate the position of each dot around the circle
        for (int i = 0; i < dotsNumber; i++) {
            double angle = 2 * Math.PI * i / dotsNumber;
            int CIRCLE_RADIUS = 250;
            double x = centerX + CIRCLE_RADIUS * Math.cos(angle);
            double y = centerY + CIRCLE_RADIUS * Math.sin(angle);

            // Create the dot
            Circle dot = new Circle(x, y, 10, javafx.scene.paint.Color.BLACK);

            // Add the dot to the list and to the scene
            dots.add(dot);
            canvasGroupRoot.getChildren().add(dot);
        }

        return dots;
    }

    public void handleSaveButtonClick(MouseEvent mouseEvent) throws IOException {
        game.saveState();
    }

    public void handleResetButtonClick(MouseEvent mouseEvent) {
        canvasGroupRoot.getChildren().clear();
        if (game != null) {
            game.resetGame();
        }
    }

    public void handleExitButtonClick(MouseEvent mouseEvent) {
        Platform.exit();
    }

    public void handleNewGameButton(MouseEvent mouseEvent) {
        canvasGroupRoot.getChildren().clear();

        String greenPlayer = greenPlayerName.getText();
        String yellowPlayer = yellowPlayerName.getText();

        Player player1 = new Player(greenPlayer, Color.GREEN);
        Player player2 = new Player(yellowPlayer, Color.YELLOW);

        game = new Game(player1, player2, numberOfDotsSpinner.getValue(), lineProbabilityCombo.getValue());

        playerToMoveName.setText(game.getFirstPlayerToMove().getPlayerName());

        GraphicsContext gc = canvasPaneId.getGraphicsContext2D();
        gc.setLineWidth(0.5);

        // Create a list to hold the dots
        Integer dotsNumber = numberOfDotsSpinner.getValue();
        List<Circle> dots = drawDots(dotsNumber);

        List<Line> blackLines = blackLines(dotsNumber, dots);
        blackLines.forEach(blackLine -> blackLine.addEventHandler(MouseEvent.MOUSE_PRESSED, getEventHandlers()));

        game.setBlackLines(blackLines);
    }

    private void handleMouseEvent(MouseEvent event) {
        Player playerToMove = game.checkFirstMove() ? game.getFirstPlayerToMove() : game.nextPlayerToMove();
        Line line = (Line) event.getSource();
        if (game.validMove(line)) {
            new Alert(Alert.AlertType.INFORMATION, "Line already colored, choose another line", ButtonType.OK).showAndWait();
        } else {
            System.out.println("Player " + playerToMove.getPlayerName() + " printed a line.");
            line.setStroke(playerToMove.getColor());
            game.addMove(line, playerToMove);
            playerToMoveName.setText(game.nextPlayerToMove().getPlayerName());
            if (game.displayWinner(playerToMove)) {
                new Alert(Alert.AlertType.INFORMATION, "Player " + playerToMove.getPlayerName() + " won! ", ButtonType.OK).showAndWait();
                canvasGroupRoot.getChildren().clear();
            }
        }
    }

    private EventHandler<MouseEvent> getEventHandlers() {
        return this::handleMouseEvent;
    }

    public void handleExportPNG(MouseEvent mouseEvent) {
        WritableImage writableImage = canvasGroupRoot.snapshot(null, null);
        File file = new File("canvas.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
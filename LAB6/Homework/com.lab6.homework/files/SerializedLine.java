package com.lab6.homework.files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.shape.Line;
public class SerializedLine {
    private Double startX;
    private Double startY;
    private Double endX;
    private Double endY;
    public SerializedLine(Double startX, Double startY, Double endX, Double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    public SerializedLine() {}
    public Double getStartX() {
        return startX;
    }

    public void setStartX(Double startX) {
        this.startX = startX;
    }

    public Double getStartY() {
        return startY;
    }

    public void setStartY(Double startY) {
        this.startY = startY;
    }

    public Double getEndX() {
        return endX;
    }

    public void setEndX(Double endX) {
        this.endX = endX;
    }

    public Double getEndY() {
        return endY;
    }

    public void setEndY(Double endY) {
        this.endY = endY;
    }

    public static SerializedLine lineStart(Line line) {
        return new SerializedLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
    }
    public Line lineEnd() {
        return new Line(startX, startY, endX, endY);
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
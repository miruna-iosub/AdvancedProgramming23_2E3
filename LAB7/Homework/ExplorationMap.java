package org.homework;

public class ExplorationMap {
    private final int[][] cells;
    private final int n;

    public ExplorationMap(int n) {
        this.n = n;
        cells = new int[n][n];
    }

    //method which checks if a given cell has already been visited and updates the cells array if the cell is available for visiting
    public synchronized boolean visitCell(int x, int y) {
        if (cells[x][y] != 0) {
            return false;
        }
        cells[x][y] = 1;
        return true;
    }

    //method which checks if a given position is valid within the map
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public synchronized void addToken(int x, int y, int value) {
        cells[x][y] = value;
    }

    public int getN() {
        return n;
    }
}

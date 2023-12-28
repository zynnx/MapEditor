package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.Arrays;

public class Grid extends Rectangle {

    public static int ROWS = 20, COLS = 20, CELL_SIZE = 20;
    private Rectangle[][] gridCells;

    public Grid() {
        gridCells = new Rectangle[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                gridCells[row][col] = new Rectangle(10 + row * CELL_SIZE, 10 + col * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gridCells[row][col].draw();
            }
        }
    }

    public Rectangle[][] getGridCells() {
        return gridCells;
    }

    public String toString(int x, int j) {
        return "Condition met at row " + x + " column " + j;
    }
}

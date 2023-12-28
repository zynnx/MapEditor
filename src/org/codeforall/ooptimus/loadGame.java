package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class loadGame {
    private String[] words = null;

    public void loadLastGame(Grid grid) {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader("resources/test.txt"));
            String line = "";
            while ((line = bReader.readLine()) != null) {
                words = line.split(" ");
                num(grid, words);
            }
            bReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void num(Grid grid, String[] words) {
        Rectangle rectangle = grid.getGridCells()[Integer.parseInt(words[4])][Integer.parseInt(words[6])];
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
    }
}
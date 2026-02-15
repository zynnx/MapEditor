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
                words = line.split(" "); parseLine(grid, words);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void parseLine(Grid grid, String[] parts) {
        int row = Integer.parseInt(parts[4]);
        int col = Integer.parseInt(parts[6]);
        int r   = Integer.parseInt(parts[8]);
        int g   = Integer.parseInt(parts[10]);
        int b   = Integer.parseInt(parts[12]);

        Rectangle rect = grid.getGridCells()[row][col];
        rect.setColor(new Color(r, g, b));
        rect.fill();
    }
}

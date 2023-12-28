package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class KeyboardGame implements KeyboardHandler {
    private Keyboard kb = new Keyboard(this);
    private Rectangle[][] copy = new Rectangle[Grid.ROWS][Grid.COLS];
    private Cursor cursor;
    private Grid grid;

    public KeyboardGame(Cursor cursor, Grid grid) {
        this.cursor = cursor;
        this.grid = grid;
        getOriginal(grid);
    }

    public void handler() {
        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(space);

        KeyboardEvent s = new KeyboardEvent();
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        s.setKey(KeyboardEvent.KEY_S);
        kb.addEventListener(s);

        KeyboardEvent l = new KeyboardEvent();
        l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        l.setKey(KeyboardEvent.KEY_L);
        kb.addEventListener(l);

        KeyboardEvent c = new KeyboardEvent();
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        c.setKey(KeyboardEvent.KEY_C);
        kb.addEventListener(c);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT -> {
                if ((Grid.COLS * Grid.CELL_SIZE) > (cursor.getRectangle().getX() + Grid.CELL_SIZE)) {
                    cursor.getRectangle().translate(Grid.CELL_SIZE, 0);
                }
            }
            case KeyboardEvent.KEY_LEFT -> {
                if (cursor.getRectangle().getX() > Grid.CELL_SIZE) {
                    cursor.getRectangle().translate(-Grid.CELL_SIZE, 0);
                }
            }
            case KeyboardEvent.KEY_UP -> {
                if (cursor.getRectangle().getY() > Grid.CELL_SIZE) {
                    cursor.getRectangle().translate(0, -Grid.CELL_SIZE);
                }
            }
            case KeyboardEvent.KEY_DOWN -> {
                if ((Grid.COLS * Grid.CELL_SIZE) > (cursor.getRectangle().getY() + Grid.CELL_SIZE)) {
                    cursor.getRectangle().translate(0, Grid.CELL_SIZE);
                }
            }
            case KeyboardEvent.KEY_SPACE -> {
                Rectangle currentRectangle = grid.getGridCells()[cursor.getRectangle().getX() / Grid.CELL_SIZE][cursor.getRectangle().getY() / Grid.CELL_SIZE];
                if (!grid.getGridCells()[cursor.getRectangle().getX() / Grid.CELL_SIZE][cursor.getRectangle().getY() / Grid.CELL_SIZE].isFilled()) {
                    currentRectangle.setColor(Color.BLUE);
                    currentRectangle.fill();
                } else {
                    currentRectangle.setColor(Color.BLACK);
                    currentRectangle.draw();
                }
            }
            case KeyboardEvent.KEY_S -> {
                saveGame saveGame = new saveGame();
                String rectanglePaint = "";
                for (int i = 0; i < grid.getGridCells().length; i++) {
                    for (int j = 0; j < grid.getGridCells()[i].length; j++) {
                        if (grid.getGridCells()[i][j].isFilled()) {
                            rectanglePaint += grid.toString(i, j) + "\n";
                        }
                    }
                }
                saveGame.saveG(rectanglePaint);
            }
            case KeyboardEvent.KEY_L -> {
                loadGame loadGame = new loadGame();
                loadGame.loadLastGame(grid);
            }
            case KeyboardEvent.KEY_C -> {
                printCopy();
            }
            default -> throw new IllegalStateException("Unexpected value: " + keyboardEvent.getKey());
        }
    }

    public void getOriginal(Grid grid) {
        for (int i = 0; i < grid.getGridCells().length; i++) {
            copy[i] = grid.getGridCells()[i].clone();
        }
    }

    public void printCopy() {
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                copy[i][j].setColor(Color.BLACK);
                copy[i][j].draw();
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}

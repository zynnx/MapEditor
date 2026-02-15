package org.codeforall.ooptimus;

public class Game {
    private Grid grid;
    private Cursor cursor;
    private KeyboardGame kb;

    public Game() {
        grid = new Grid();
        this.cursor = new Cursor();
        this.kb = new KeyboardGame(cursor, grid);
    }

    public void init() {
        kb.handler();
    }
}





package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {
    private Rectangle rectangle = new Rectangle(10,10,Grid.CELL_SIZE,Grid.CELL_SIZE);
    public Cursor() {
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }
    public Rectangle getRectangle() {
        return rectangle;
    }

}

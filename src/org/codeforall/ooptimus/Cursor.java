package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.Random;

public class Cursor {
    private final Rectangle rectangle = new Rectangle(10,10,Grid.CELL_SIZE,Grid.CELL_SIZE);
    public Cursor() {
        rectangle.setColor(ColorUtil.randomColor());
        rectangle.fill();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}

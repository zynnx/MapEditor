package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.Random;

public class ColorUtil {
    private static final Random random = new Random();

    public static Color randomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }
}

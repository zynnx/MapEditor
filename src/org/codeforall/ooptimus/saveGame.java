package org.codeforall.ooptimus;

import java.io.*;

public class saveGame {
    public void saveG(String str) {
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter("resources/test.txt"));
            bWriter.write(str);
            bWriter.flush();
            bWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

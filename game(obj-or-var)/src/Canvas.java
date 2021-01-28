import acm.graphics.GLine;

import java.awt.*;

public class Canvas {
    public static final int CANVAS_WIDTH = 1000;
    public static final int CANVAS_HEIGHT = 500;

    public static void initDesk(Run program) {
        program.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        GLine line = new GLine((float)CANVAS_WIDTH/2, 0, (float)CANVAS_WIDTH/2, CANVAS_HEIGHT);
        line.setColor(Color.BLACK);
        program.add(line);
    }
}


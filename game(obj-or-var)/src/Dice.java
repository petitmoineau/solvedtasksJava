import acm.graphics.*;
import acm.util.RandomGenerator;
import java.awt.*;

public class Dice {

    protected static final int DICE_SIDE = 42;
    protected static final int DOT_DIAMETER = 6;
    protected int NUMBER_OF_DOTS;
    int SCORE;

    public void draw(Run program, int START_X, int START_Y) {

        GRect dice = new GRect(START_X, START_Y, DICE_SIDE, DICE_SIDE);
        program.add(dice);

        RandomGenerator rand = RandomGenerator.getInstance();
        NUMBER_OF_DOTS = rand.nextInt(1, 6);
        SCORE += NUMBER_OF_DOTS;

        GOval dot1 = new GOval(START_X+DOT_DIAMETER*3, START_Y+ DOT_DIAMETER*3,
                DOT_DIAMETER, DOT_DIAMETER);
        dot1.setFillColor(Color.BLACK);
        dot1.setFilled(true);

        GOval dot2 = new GOval(START_X+ DOT_DIAMETER*5, START_Y+ DOT_DIAMETER,
                DOT_DIAMETER, DOT_DIAMETER);
        dot2.setFillColor(Color.BLACK);
        dot2.setFilled(true);

        GOval dot3 = new GOval(START_X+ DOT_DIAMETER, START_Y+ DOT_DIAMETER*5,
                DOT_DIAMETER, DOT_DIAMETER);
        dot3.setFillColor(Color.BLACK);
        dot3.setFilled(true);

        GOval dot4 = new GOval(START_X+ DOT_DIAMETER, START_Y+ DOT_DIAMETER,
                DOT_DIAMETER, DOT_DIAMETER);
        dot4.setFillColor(Color.BLACK);
        dot4.setFilled(true);

        GOval dot5 = new GOval(START_X+ DOT_DIAMETER*5, START_Y+ DOT_DIAMETER*5,
                DOT_DIAMETER, DOT_DIAMETER);
        dot5.setFillColor(Color.BLACK);
        dot5.setFilled(true);

        GOval dot6 = new GOval(START_X+ DOT_DIAMETER, START_Y+ DOT_DIAMETER*3,
                DOT_DIAMETER, DOT_DIAMETER);
        dot6.setFillColor(Color.BLACK);
        dot6.setFilled(true);

        GOval dot7 = new GOval(START_X+ DOT_DIAMETER*5, START_Y+ DOT_DIAMETER*3,
                DOT_DIAMETER, DOT_DIAMETER);
        dot7.setFillColor(Color.BLACK);
        dot7.setFilled(true);

        switch (NUMBER_OF_DOTS) {
            case 1 -> program.add(dot1);
            case 2 -> {
                program.add(dot2);
                program.add(dot3);
            }
            case 3 -> {
                program.add(dot1);
                program.add(dot2);
                program.add(dot3);
            }
            case 4 -> {
                program.add(dot2);
                program.add(dot3);
                program.add(dot4);
                program.add(dot5);
            }
            case 5 -> {
                program.add(dot1);
                program.add(dot2);
                program.add(dot3);
                program.add(dot4);
                program.add(dot5);
            }
            case 6 -> {
                program.add(dot2);
                program.add(dot3);
                program.add(dot4);
                program.add(dot5);
                program.add(dot6);
                program.add(dot7);
            }
        }
    }
}


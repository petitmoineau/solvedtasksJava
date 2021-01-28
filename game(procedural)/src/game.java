import acm.graphics.*;
import acm.io.IODialog;
import acm.program.GraphicsProgram;
import acm.util.*;
import java.awt.*;

public class game extends GraphicsProgram {
    final int diceSide = 42;
    final int space = 10;
    final int canvasWidth = 1000;
    final int canvasHeight = 500;

    int amountOfDices;
    int tryAgain = 1;

    final int dotDiam = 6;
    int score1, score2;
    int number;

    IODialog window = new IODialog();

    Font font = new Font("Times New Roman", Font.BOLD, 18);

    public void run(){
        while (tryAgain != 0) {
            removeAll();
            amountOfDices = window.readInt("How many dices do you want to use? ");
            setCanvas();
            player1(amountOfDices);
            player2(amountOfDices);
            GLabel player1 = new GLabel("Total first player`s score: " + score1, space, space*2);
            GLabel player2 = new GLabel("Total second player`s score: " + score2,
                    (float)canvasWidth/2+space, space*2);
            player1.setFont(font);
            player2.setFont(font);
            add(player1);
            add(player2);
            window = new IODialog();
            tryAgain = window.readInt("Try again or end the game(1 or 0): ");
        }
        removeAll();

        String resultMsg;

        if(score1 == score2)
            resultMsg = "Draw!";
        else
            resultMsg = "Player " + (score1 > score2 ? 1 : 2) + " wins!";

        GLabel draw = new GLabel(resultMsg, (float)canvasWidth/2-space*6, (float)canvasHeight/2);
        draw.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(draw);
    }


    public void setCanvas() {
        this.setSize(canvasWidth, canvasHeight);
        GLine line = new GLine((float)canvasWidth/2, 0, (float)canvasWidth/2, canvasHeight);
        line.setColor(Color.BLACK);
        add(line);
    }

    public void player1(int dices) {
        int startX = space;
        int startY = space*3;
        locateDices(startX, startY, dices);
    }

    public void player2(int dices) {
        int startX = canvasWidth/2 + space;
        int startY = space*3;
        locateDices(startX, startY, dices);
    }

    public void locateDices(int x, int y, int amountOfDices) {
        if ((canvasWidth/2 - x) < diceSide && x < canvasWidth/2) {
            x = space;
            y += diceSide + space;
        }
        if ((canvasWidth-x) < diceSide && x > canvasWidth/2) {
            x = canvasWidth/2 + space;
            y += diceSide + space;
        }
        drawDice(x, y);
        drawDotsOnDice(x, y);
        if (amountOfDices == 1) {
            return;
        }
        locateDices(x+diceSide+space, y, --amountOfDices);
    }

    public void drawDice(int x, int y) {
        GRect dice = new GRect(x, y, diceSide, diceSide);
        add(dice);
    }

    public void drawDotsOnDice(int x, int y) {
        RandomGenerator rand = RandomGenerator.getInstance();
        number = rand.nextInt(1, 6);
        if (x < canvasWidth/2) score1 += number;
        else score2 += number;
        drawDots(x, y, number);
    }

    public void drawDots(int x, int y, int numberOfDots) {
        GOval dot1 = new GOval(x+dotDiam*3, y+dotDiam*3, dotDiam, dotDiam);
        dot1.setFillColor(Color.BLACK);
        dot1.setFilled(true);

        GOval dot2 = new GOval(x+dotDiam*5, y+dotDiam, dotDiam, dotDiam);
        dot2.setFillColor(Color.BLACK);
        dot2.setFilled(true);

        GOval dot3 = new GOval(x+dotDiam, y+dotDiam*5, dotDiam, dotDiam);
        dot3.setFillColor(Color.BLACK);
        dot3.setFilled(true);

        GOval dot4 = new GOval(x+dotDiam, y+dotDiam, dotDiam, dotDiam);
        dot4.setFillColor(Color.BLACK);
        dot4.setFilled(true);

        GOval dot5 = new GOval(x+dotDiam*5, y+dotDiam*5, dotDiam, dotDiam);
        dot5.setFillColor(Color.BLACK);
        dot5.setFilled(true);

        GOval dot6 = new GOval(x+dotDiam, y+dotDiam*3, dotDiam, dotDiam);
        dot6.setFillColor(Color.BLACK);
        dot6.setFilled(true);

        GOval dot7 = new GOval(x+dotDiam*5, y+dotDiam*3, dotDiam, dotDiam);
        dot7.setFillColor(Color.BLACK);
        dot7.setFilled(true);

        switch (numberOfDots) {
            case 1 -> add(dot1);
            case 2 -> {
                add(dot2);
                add(dot3);
            }
            case 3 -> {
                add(dot1);
                add(dot2);
                add(dot3);
            }
            case 4 -> {
                add(dot2);
                add(dot3);
                add(dot4);
                add(dot5);
            }
            case 5 -> {
                add(dot1);
                add(dot2);
                add(dot3);
                add(dot4);
                add(dot5);
            }
            case 6 -> {
                add(dot2);
                add(dot3);
                add(dot4);
                add(dot5);
                add(dot6);
                add(dot7);
            }
        }
    }
}


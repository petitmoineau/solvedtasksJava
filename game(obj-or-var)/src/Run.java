import acm.graphics.*;
import acm.io.IODialog;
import acm.program.GraphicsProgram;
import java.awt.*;

public class Run extends GraphicsProgram {
    public void run() {
        int amountOfDices;
        int tryAgain = 1;

        IODialog window = new IODialog();
        DiceManager pl1 = new DiceManager(this);
        DiceManager pl2 = new DiceManager(this);

        Canvas.initDesk(this);

        GLabel player1 = new GLabel("", Player.START_X_PL1, Player.SPACE * 2);
        GLabel player2 = new GLabel("", Player.START_X_PL2, Player.SPACE * 2);
        Font font = new Font("Times New Roman", Font.BOLD, 18);
        player1.setFont(font);
        player2.setFont(font);

        while (tryAgain != 0) {
            removeAll();

            amountOfDices = window.readInt("How many dices do you want to use? ");
            pl1.locateDices(Player.START_X_PL1, Player.START_Y_PL1, amountOfDices);
            pl2.locateDices(Player.START_X_PL2, Player.START_Y_PL2, amountOfDices);
            player1.setLabel("Total first player`s score: " + pl1.getScore());
            add(player1);
            player2.setLabel("Total second player`s score: " + pl2.getScore());
            add(player2);
            window = new IODialog();
            tryAgain = window.readInt("Try again or end the game(1 or 0): ");
        }

        removeAll();

        String resultMsg;

        if(pl1.getScore() == pl2.getScore())
            resultMsg = "Draw!";
        else
            resultMsg = "Player " + (pl1.getScore() > pl2.getScore() ? 1 : 2) + " wins!";

        GLabel draw = new GLabel(resultMsg, (float)Canvas.CANVAS_WIDTH / 2 - Player.SPACE * 6,
                (float)Canvas.CANVAS_HEIGHT / 2);
        draw.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(draw);
    }
}

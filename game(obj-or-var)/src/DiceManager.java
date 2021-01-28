public class DiceManager {

    protected Dice DICE;
    protected Run PROGRAM;

    DiceManager (Run program) {
        DICE = new Dice();
        PROGRAM = program;
    }

    public void locateDices(int START_X, int START_Y, int amount_of_dices) {
        if ((Canvas.CANVAS_WIDTH/2 - START_X) < Dice.DICE_SIDE && START_X < Canvas.CANVAS_WIDTH/2) {
            START_X = Player.SPACE;
            START_Y += Dice.DICE_SIDE + Player.SPACE;
        }
        if ((Canvas.CANVAS_WIDTH-START_X) < Dice.DICE_SIDE && START_X > Canvas.CANVAS_WIDTH/2) {
            START_X = Canvas.CANVAS_WIDTH/2 + Player.SPACE;
            START_Y += Dice.DICE_SIDE + Player.SPACE;
        }
        DICE.draw(PROGRAM, START_X, START_Y);
        if (amount_of_dices == 1) {
            return;
        }
        locateDices(START_X+ Dice.DICE_SIDE+Player.SPACE, START_Y, --amount_of_dices);
    }

    public int getScore() { return DICE.SCORE; }
}


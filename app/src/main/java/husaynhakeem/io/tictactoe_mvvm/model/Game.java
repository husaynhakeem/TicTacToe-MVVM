package husaynhakeem.io.tictactoe_mvvm.model;


public class Game {

    private static final int BOARD_SIZE = 3;

    public Player player1;
    public Player player2;
    public Cell[][] cells;


    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
    }
}

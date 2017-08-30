package husaynhakeem.io.tictactoe_mvvm.game;


import org.junit.Before;
import org.junit.Test;

import husaynhakeem.io.tictactoe_mvvm.model.Cell;
import husaynhakeem.io.tictactoe_mvvm.model.Game;
import husaynhakeem.io.tictactoe_mvvm.model.Player;

import static org.junit.Assert.assertEquals;

public class GameShould {

    private Game game;
    private Player player;
    private Player anotherPlayer;


    @Before
    public void setUp() throws Exception {
        player = new Player("Husayn", "x");
        anotherPlayer = new Player("Yasin", "o");

        game = new Game();
        game.player1 = player;
        game.player2 = anotherPlayer;
    }


    @Test
    public void endGameIfHasThreeSameHorizontalCells() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][0] = cell;
        game.cells[0][1] = cell;
        game.cells[0][2] = cell;
        boolean hasGameEnded = game.hasGameEnded();
        assertEquals(true, hasGameEnded);
    }


    @Test
    public void endGameIfHasThreeSameVerticalCells() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][0] = cell;
        game.cells[1][0] = cell;
        game.cells[2][0] = cell;
        boolean hasGameEnded = game.hasGameEnded();
        assertEquals(true, hasGameEnded);
    }


    @Test
    public void endGameIfHasThreeSameDiagonalCells() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][0] = cell;
        game.cells[1][1] = cell;
        game.cells[2][2] = cell;
        boolean hasGameEnded = game.hasGameEnded();
        assertEquals(true, hasGameEnded);
    }


    @Test
    public void endGameIfBoardIsFull() throws Exception {
        Cell cell1 = new Cell(new Player("1", "1"));
        Cell cell2 = new Cell(new Player("2", "2"));
        Cell cell3 = new Cell(new Player("3", "3"));
        Cell cell4 = new Cell(new Player("4", "4"));
        Cell cell5 = new Cell(new Player("5", "5"));
        Cell cell6 = new Cell(new Player("6", "6"));
        Cell cell7 = new Cell(new Player("7", "7"));
        Cell cell8 = new Cell(new Player("8", "8"));
        Cell cell9 = new Cell(new Player("9", "9"));

        game.cells[0][0] = cell1;
        game.cells[0][1] = cell2;
        game.cells[0][2] = cell3;
        game.cells[1][0] = cell4;
        game.cells[1][1] = cell5;
        game.cells[1][2] = cell6;
        game.cells[2][0] = cell7;
        game.cells[2][1] = cell8;
        game.cells[2][2] = cell9;

        boolean isBoardFull = game.isBoardFull();
        assertEquals(true, isBoardFull);
    }


    @Test
    public void switchFromPlayer1ToPlayer2() throws Exception {
        game.currentPlayer = game.player1;
        game.switchPlayer();
        assertEquals(game.player2, game.currentPlayer);
    }
}

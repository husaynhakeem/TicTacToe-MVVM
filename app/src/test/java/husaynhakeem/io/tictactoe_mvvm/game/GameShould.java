package husaynhakeem.io.tictactoe_mvvm.game;


import junit.framework.Assert;

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
        Assert.assertEquals(true, hasGameEnded);
    }


    @Test
    public void endGameIfHasThreeSameVerticalCells() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][0] = cell;
        game.cells[1][0] = cell;
        game.cells[2][0] = cell;
        boolean hasGameEnded = game.hasGameEnded();
        Assert.assertEquals(true, hasGameEnded);
    }


    @Test
    public void endGameIfHasThreeSameDiagonalCells() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][0] = cell;
        game.cells[1][1] = cell;
        game.cells[2][2] = cell;
        boolean hasGameEnded = game.hasGameEnded();
        Assert.assertEquals(true, hasGameEnded);
    }


    @Test
    public void switchFromPlayer1ToPlayer2() throws Exception {
        game.currentPlayer = game.player1;
        game.switchPlayer();
        assertEquals(game.player2, game.currentPlayer);
    }
}

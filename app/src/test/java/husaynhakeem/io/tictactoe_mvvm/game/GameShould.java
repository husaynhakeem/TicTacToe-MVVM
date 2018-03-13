package husaynhakeem.io.tictactoe_mvvm.game;


import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import husaynhakeem.io.tictactoe_mvvm.model.Cell;
import husaynhakeem.io.tictactoe_mvvm.model.Game;
import husaynhakeem.io.tictactoe_mvvm.model.Player;

import static org.junit.Assert.assertEquals;

public class GameShould {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private Game game;
    private Player player;

    @Before
    public void setUp() throws Exception {
        game = new Game("Husayn", "Yasin");
        player = game.player1;
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
        Cell cell1 = new Cell(new Player("1", "x"));
        Cell cell2 = new Cell(new Player("2", "o"));
        Cell cell3 = new Cell(new Player("1", "x"));
        Cell cell4 = new Cell(new Player("2", "o"));
        Cell cell5 = new Cell(new Player("1", "x"));
        Cell cell6 = new Cell(new Player("2", "o"));
        Cell cell7 = new Cell(new Player("1", "x"));
        Cell cell8 = new Cell(new Player("2", "o"));
        Cell cell9 = new Cell(new Player("1", "x"));

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

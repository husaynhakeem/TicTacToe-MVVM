package husaynhakeem.io.tictactoe_mvvm.game;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import husaynhakeem.io.tictactoe_mvvm.model.Cell;
import husaynhakeem.io.tictactoe_mvvm.model.Game;
import husaynhakeem.io.tictactoe_mvvm.model.Player;

public class GameDiagonalCellsShould {

    private Game game;
    private Player player;
    private Player anotherPlayer;


    @Before
    public void setUp() throws Exception {
        game = new Game();
        player = new Player("Husayn", "x");
        anotherPlayer = new Player("Yasin", "o");
    }


    @Test
    public void returnTrueIfHasThreeSameDiagonalCellsFromLeft() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][0] = cell;
        game.cells[1][1] = cell;
        game.cells[2][2] = cell;
        boolean hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells();
        Assert.assertEquals(true, hasThreeSameDiagonalCells);
    }


    @Test
    public void returnTrueIfHasThreeSameDiagonalCellsFromRight() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][2] = cell;
        game.cells[1][1] = cell;
        game.cells[2][0] = cell;
        boolean hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells();
        Assert.assertEquals(true, hasThreeSameDiagonalCells);
    }


    @Test
    public void returnFalseIfDoesNotHaveThreeSameDiagonalCells() throws Exception {
        Cell cell = new Cell(player);
        Cell anotherCell = new Cell(anotherPlayer);
        game.cells[0][2] = cell;
        game.cells[1][1] = cell;
        game.cells[2][0] = anotherCell;
        boolean hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells();
        Assert.assertEquals(false, hasThreeSameDiagonalCells);
    }
}

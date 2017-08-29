package husaynhakeem.io.tictactoe_mvvm.model;


public class Cell {

    public Player player;
    public String value;


    public Cell(Player player, String value) {
        this.player = player;
        this.value = value;
    }
}

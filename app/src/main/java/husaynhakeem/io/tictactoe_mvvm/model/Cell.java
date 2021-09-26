package husaynhakeem.io.tictactoe_mvvm.model;


import husaynhakeem.io.tictactoe_mvvm.utilities.StringUtility;

public class Cell {

    private Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public boolean isEmpty() {
        return player == null || StringUtility.isNullOrEmpty(player.getValue());
    }

    public Player getPlayerCell(){
        return player;
    }
}

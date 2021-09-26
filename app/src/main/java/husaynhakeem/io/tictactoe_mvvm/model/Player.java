package husaynhakeem.io.tictactoe_mvvm.model;


public class Player {

    private String name;
    private String value;

    public Player(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public String getValue(){
        return this.value;
    }
}

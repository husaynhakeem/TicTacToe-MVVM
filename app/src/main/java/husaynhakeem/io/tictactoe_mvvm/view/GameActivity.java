package husaynhakeem.io.tictactoe_mvvm.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

import husaynhakeem.io.tictactoe_mvvm.R;

public class GameActivity extends AppCompatActivity implements Observer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}

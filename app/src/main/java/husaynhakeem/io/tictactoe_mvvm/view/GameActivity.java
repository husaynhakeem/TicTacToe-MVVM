package husaynhakeem.io.tictactoe_mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

import husaynhakeem.io.tictactoe_mvvm.R;
import husaynhakeem.io.tictactoe_mvvm.databinding.ActivityGameBinding;
import husaynhakeem.io.tictactoe_mvvm.viewmodel.GameViewModel;

public class GameActivity extends AppCompatActivity implements Observer {


    private ActivityGameBinding activityGameBinding;
    private GameViewModel gameViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        promptForPlayers();
    }


    private void initDataBinding() {
        activityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        gameViewModel = new GameViewModel();
        activityGameBinding.setGameViewModel(gameViewModel);
    }


    private void promptForPlayers() {

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}

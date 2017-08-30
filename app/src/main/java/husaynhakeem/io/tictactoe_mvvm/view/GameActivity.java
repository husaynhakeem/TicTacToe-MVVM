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


    private static final String GAME_BEGIN_DIALOG_TAG = "game_dialog_tag";
    private static final String GAME_END_DIALOG_TAG = "game_end_dialog_tag";
    private ActivityGameBinding activityGameBinding;
    private GameViewModel gameViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        promptForPlayers();
    }


    public void promptForPlayers() {
        GameBeginDialog dialog = GameBeginDialog.newInstance(this);
        dialog.show(getSupportFragmentManager(), GAME_BEGIN_DIALOG_TAG);
    }


    public void onPlayersSet(String player1, String player2) {
        initDataBinding(player1, player2);
    }


    private void initDataBinding(String player1, String player2) {
        activityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        gameViewModel = new GameViewModel(player1, player2);
        activityGameBinding.setGameViewModel(gameViewModel);
        gameViewModel.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        GameEndDialog dialog = GameEndDialog.newInstance(this, (String) arg);
        dialog.show(getSupportFragmentManager(), GAME_END_DIALOG_TAG);
    }
}

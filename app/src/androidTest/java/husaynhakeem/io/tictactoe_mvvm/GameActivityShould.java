package husaynhakeem.io.tictactoe_mvvm;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import husaynhakeem.io.tictactoe_mvvm.model.Player;
import husaynhakeem.io.tictactoe_mvvm.view.GameActivity;

import static com.schibsted.spain.barista.BaristaAssertions.assertDisplayed;
import static com.schibsted.spain.barista.BaristaClickActions.click;

public class GameActivityShould {

    @Rule
    public ActivityTestRule<GameActivity> activityRule = new ActivityTestRule<>(
            GameActivity.class, true, false);

    private Context context = InstrumentationRegistry.getTargetContext();

    private Player player1 = new Player("Husayn", "x");
    private Player player2 = new Player("Yasin", "o");

    @Test
    public void end_game_when_one_player_wins() throws Exception {
        givenGameActivityLaunched();
        givenPlayersSet();

        click(R.id.cell_00);
        click(R.id.cell_10);
        click(R.id.cell_01);
        click(R.id.cell_11);
        click(R.id.cell_02);

        assertDisplayed(R.id.tv_winner);
        assertDisplayed(player1.name);
    }

    private void givenGameActivityLaunched() {
        Intent intent = new Intent(context, GameActivity.class);
        activityRule.launchActivity(intent);
    }

    private void givenPlayersSet() {
        GameActivity activity = activityRule.getActivity();
        activity.onPlayersSet(player1.name, player2.name);
    }
}

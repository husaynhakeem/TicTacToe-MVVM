package husaynhakeem.io.tictactoe_mvvm;


import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import husaynhakeem.io.tictactoe_mvvm.view.GameActivity;

import static com.schibsted.spain.barista.BaristaAssertions.assertDisplayed;
import static com.schibsted.spain.barista.BaristaAssertions.assertNotExist;
import static com.schibsted.spain.barista.BaristaDialogActions.clickDialogPositiveButton;
import static com.schibsted.spain.barista.BaristaEditTextActions.writeToEditText;

public class GameBeginDialogShould {

    @Rule
    public ActivityTestRule<GameActivity> activityRule = new ActivityTestRule<>(
            GameActivity.class, true, false);

    Context context = InstrumentationRegistry.getTargetContext();

    @Test
    public void display_empty_names_message_if_names_empty() throws Exception {
        Intent intent = new Intent(context, GameActivity.class);
        activityRule.launchActivity(intent);
        writeToEditText(R.id.et_player1, "");
        writeToEditText(R.id.et_player2, "");
        clickDialogPositiveButton();
        assertDisplayed(R.string.game_dialog_empty_name);
    }

    @Test
    public void display_same_names_message_if_names_same() throws Exception {
        Intent intent = new Intent(context, GameActivity.class);
        activityRule.launchActivity(intent);
        writeToEditText(R.id.et_player1, "husaynhakeem");
        writeToEditText(R.id.et_player2, "husaynhakeem");
        clickDialogPositiveButton();
        assertDisplayed(R.string.game_dialog_same_names);
    }

    @Test
    public void display_empty_name_message_if_one_name_empty() throws Exception {
        Intent intent = new Intent(context, GameActivity.class);
        activityRule.launchActivity(intent);
        writeToEditText(R.id.et_player1, "");
        writeToEditText(R.id.et_player2, "husaynhakeem");
        clickDialogPositiveButton();
        assertDisplayed(R.string.game_dialog_empty_name);
    }

    @Test
    public void close_dialog_after_names_valid() throws Exception {
        Intent intent = new Intent(context, GameActivity.class);
        activityRule.launchActivity(intent);
        writeToEditText(R.id.et_player1, "husaynhakeem 1");
        writeToEditText(R.id.et_player2, "husaynhakeem 2");
        clickDialogPositiveButton();
        assertNotExist(R.id.layout_player1);
    }
}

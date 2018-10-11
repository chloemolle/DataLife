package mastertransmedia.datalife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chloemolle on 04/07/2018.
 */

public class EndOfInitializationPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_of_initialization_page);

        final Globals globalVariables = (Globals) getApplicationContext();
        ArrayList<Player> players = globalVariables.getPlayersList();
        fillTextField(players.get(0), R.id.player1);
        fillTextField(players.get(1), R.id.player2);
        fillTextField(players.get(2), R.id.player3);
        fillTextField(players.get(3), R.id.player4);
        if (players.size() > 5) {
            fillTextField(players.get(4), R.id.player5);
            if (players.size() > 6) {
                fillTextField(players.get(5), R.id.player6);
            } else {
                TextView titleNewPlayer = findViewById(R.id.player6);
                titleNewPlayer.setText("");
            }
        } else {
            TextView titleNewPlayer = findViewById(R.id.player5);
            titleNewPlayer.setText("");
            TextView titleNewPlayer2 = findViewById(R.id.player6);
            titleNewPlayer2.setText("");
        }


    }

    private void fillTextField(Player player, int id){
        TextView titleNewPlayer = findViewById(id);
        titleNewPlayer.setText(player.getName() + ": " +
                               player.getFamilyCard() + ", " +
                               player.getTasteCard() + ", " +
                               player.getAffinityCard() + ", " +
                               player.getAspirationCard() + ", " +
                               player.getSecretCard());
    }


}

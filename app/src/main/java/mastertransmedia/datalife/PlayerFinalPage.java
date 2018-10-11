package mastertransmedia.datalife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chloemolle on 03/07/2018.
 */

public class PlayerFinalPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_final_page);

        final Integer remainingNumberOfPlayer = getIntent().getExtras().getInt("Number_of_player");

        final Globals globalVariables = (Globals) getApplicationContext();
        ArrayList<Player> players = globalVariables.getPlayersList();
        Player lastPlayer = players.get(players.size() - 1);

        TextView playerName = findViewById(R.id.player_name);
        playerName.setText(lastPlayer.getName());

        TextView titleNewPlayer = findViewById(R.id.family_card);
        titleNewPlayer.setText(lastPlayer.getFamilyCard());

        TextView tasteCard = findViewById(R.id.taste_card);
        tasteCard.setText(lastPlayer.getTasteCard());

        TextView affinityCard = findViewById(R.id.affinity_card);
        affinityCard.setText(lastPlayer.getAffinityCard());

        TextView aspirationCard = findViewById(R.id.aspiration_card);
        aspirationCard.setText(lastPlayer.getAspirationCard());

        TextView secretCard = findViewById(R.id.secret_card);
        secretCard.setText(lastPlayer.getSecretCard());

        Button button = findViewById((R.id.end_player_button));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (remainingNumberOfPlayer > 0){
                    // Next page depending if there are still players to register or not
                    Intent intent = new Intent(v.getContext(), PlayerCreationPage.class);
                    intent.putExtra("Number_of_player", remainingNumberOfPlayer);
                    startActivity(intent);
                } else {
                    // Next page depending if there are still players to register or not
                    globalVariables.setTime(0);
                    Intent intent = new Intent(v.getContext(), DisplayWhichTurnWeReAt.class);
                    globalVariables.setCurrentPlayer(globalVariables.getPlayersList().get(0));
                    globalVariables.setCurrentPlayerIndex(0);
                    startActivity(intent);
                }
            }
        });


    }

}

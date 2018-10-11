package mastertransmedia.datalife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chloemolle on 23/08/2018.
 */

public class ActionMenuPage extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Globals globalVariables = (Globals) getApplicationContext();
        Room currentRoom = globalVariables.getCurrentRoom();
        ArrayList<Player> playerList = globalVariables.getPlayersList();
        Player currentPlayer = globalVariables.getCurrentPlayer();
        setContentView(R.layout.action_menu_page);
        LinearLayout linearLayout = findViewById(R.id.menu_action_layout);


        Button endTurn = findViewById(R.id.finishing_turn);

        endTurn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (globalVariables.getCurrentPlayerIndex() < globalVariables.getNumberOfPlayer() - 1) {
                    globalVariables.setCurrentPlayerIndex(globalVariables.getCurrentPlayerIndex() + 1);
                    Intent intent = new Intent(v.getContext(), DisplayWhichPlayerTurnItIsPage.class);
                    startActivity(intent);
                } else {
                    if (globalVariables.getTime() < 8) {
                        globalVariables.setTime(globalVariables.getTime() + 1);
                        globalVariables.setCurrentPlayerIndex(0);
                        Intent intent = new Intent(v.getContext(), DisplayWhichTurnWeReAt.class);
                        startActivity(intent);
                    } else {
                        //TODO: end page
                        Intent intent = new Intent(v.getContext(), WelcomePage.class);
                        startActivity(intent);
                    }
                }
            }
        });

        LinearLayout.LayoutParams layoutParamsTextView = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2);
        LinearLayout.LayoutParams layoutParamsDenounceButton = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,3);
        LinearLayout.LayoutParams layoutParamsSpyButton = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,3);


        Integer countPlayer = 0;
        for (int i = 0; i < playerList.size(); i ++ ) {
            if (playerList.get(i) != currentPlayer && playerList.get(i).getRoomsTagged().indexOf(currentRoom.getName()) != -1) {
                countPlayer ++;
                LinearLayout linearLayoutPlayer = new LinearLayout(this);
                linearLayoutPlayer.setOrientation(linearLayout.HORIZONTAL);
                LinearLayout.LayoutParams layoutParamsLinearLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
                linearLayoutPlayer.setLayoutParams(layoutParamsLinearLayout);
                linearLayout.addView(linearLayoutPlayer);


                TextView namePlayer = new TextView(this);
                namePlayer.setText(playerList.get(i).getName());
                namePlayer.setLayoutParams(layoutParamsTextView);
                linearLayoutPlayer.addView(namePlayer);

                Button spyButton = new Button(this);
                spyButton.setText(R.string.spy_button);
                spyButton.setLayoutParams(layoutParamsSpyButton);
                spyButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(ActionMenuPage.this, RoomPage.class);
                        startActivity(intent);
                    }
                });
                linearLayoutPlayer.addView(spyButton);

                Button denounceButton = new Button(this);
                denounceButton.setText(R.string.denounce_button);
                denounceButton.setLayoutParams(layoutParamsDenounceButton);
                linearLayoutPlayer.addView(denounceButton);

            }
        }
        if (countPlayer == 0) {
            TextView noPlayer = new TextView(this);
            noPlayer.setText(R.string.no_player);
            linearLayout.addView(noPlayer);
        }
    }
}

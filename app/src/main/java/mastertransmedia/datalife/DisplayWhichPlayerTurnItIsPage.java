package mastertransmedia.datalife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chloemolle on 05/07/2018.
 */

public class DisplayWhichPlayerTurnItIsPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_which_player_turn_it_is_page);

        LinearLayout layout = findViewById(R.id.layout_all_page);

        final Globals globalVariables = (Globals) getApplicationContext();
        Player currentPlayer = globalVariables.getCurrentPlayer();

        TextView text = findViewById(R.id.current_player);
        text.setText("It's at " + currentPlayer.getName() + " to play");

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                Intent intent = new Intent(DisplayWhichPlayerTurnItIsPage.this, PopupChoseRoom.class);
                startActivity(intent);
                return true;
            }

        });
    }


}

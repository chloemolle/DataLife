package mastertransmedia.datalife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by chloemolle on 08/09/2018.
 */

public class DisplayWhichTurnWeReAt extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_which_turn_we_re_at);

        LinearLayout layout = findViewById(R.id.layout_all_page);

        final Globals globalVariables = (Globals) getApplicationContext();

        TextView text = findViewById(R.id.current_turn);
        Integer timeIs = 8 + globalVariables.getTime();
        Integer turnNumber = 1 + globalVariables.getTime();
        text.setText("we're on turn " + turnNumber + ", It is " + timeIs + "h00");

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                Intent intent = new Intent(v.getContext(), DisplayWhichPlayerTurnItIsPage.class);
                startActivity(intent);
                return true;
            }

        });
    }

}

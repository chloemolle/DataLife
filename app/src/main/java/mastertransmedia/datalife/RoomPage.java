package mastertransmedia.datalife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by chloemolle on 26/08/2018.
 */

public class RoomPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_page);
        final Globals globalVariables = (Globals) getApplicationContext();

        Room room = globalVariables.getCurrentRoom();
        Button fbButton = findViewById(R.id.fb_button);
        if (room.getAvailabeApplication().indexOf("FB") == -1) {
            fbButton.setEnabled(false);
        }
        Button smsButton = findViewById(R.id.sms_button);
        if (room.getAvailabeApplication().indexOf("SMS") == -1) {
            smsButton.setEnabled(false);
        }
        Button emailButton = findViewById(R.id.email_button);
        if (room.getAvailabeApplication().indexOf("EMAIL") == -1) {
            emailButton.setEnabled(false);
        }
        Button eurosButton = findViewById(R.id.euros_button);
        if (room.getAvailabeApplication().indexOf("EUROS") == -1) {
            eurosButton.setEnabled(false);
        }

    }


}

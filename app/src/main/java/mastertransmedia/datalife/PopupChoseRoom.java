package mastertransmedia.datalife;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chloemolle on 26/08/2018.
 */

public class PopupChoseRoom extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_chose_room);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widthPopup = (int) dm.widthPixels / 2;
        int heightPopup = (int) dm.heightPixels / 2;
        getWindow().setLayout(widthPopup, heightPopup);

        final Globals globalVariables = (Globals) getApplicationContext();
        Integer time = globalVariables.getTime();


        final Spinner spinnerRoom = (Spinner) findViewById(R.id.spinner_room);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterRooms;
        if (time == 2 ||time == 3) {
            adapterRooms = ArrayAdapter.createFromResource(this,
                    R.array.rooms1012, android.R.layout.simple_spinner_item);
        } else if (time == 4){
            adapterRooms = ArrayAdapter.createFromResource(this,
                    R.array.rooms1213, android.R.layout.simple_spinner_item);
        } else if (time == 6 || time == 7){
            adapterRooms = ArrayAdapter.createFromResource(this,
                    R.array.rooms1416, android.R.layout.simple_spinner_item);
        } else {
            adapterRooms = ArrayAdapter.createFromResource(this,
                    R.array.rooms, android.R.layout.simple_spinner_item);
        }
        // Specify the layout to use when the list of choices appears
        adapterRooms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerRoom.setAdapter(adapterRooms);

        Button button = findViewById(R.id.button_ok_room);
        final Spinner spinnerRoomFinal = spinnerRoom;


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Globals globalVariables = (Globals) getApplicationContext();
                ArrayList<Room> rooms = globalVariables.getRoomList();
                String roomName = spinnerRoomFinal.getSelectedItem().toString();
                if (globalVariables.getCurrentPlayer().getPreviousRoom() == roomName) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());

                    alertDialog.setTitle("Wrong room");
                    alertDialog.setMessage("You were already in that room during the previous turn");
                    alertDialog.setCancelable(true);
                    alertDialog.create().show();

                } else {
                    globalVariables.getCurrentPlayer().getRoomsTagged().add(roomName);
                    globalVariables.getCurrentPlayer().setPreviousRoom(roomName);
                    for (int i = 0; i < rooms.size(); i ++) {
                        String currentRoomName = rooms.get(i).getName();
                        if (currentRoomName.equals(roomName)) {
                            globalVariables.setCurrentRoom(rooms.get(i));
                        }
                    }
                    Intent intent = new Intent(v.getContext(), ActionMenuPage.class);
                    startActivity(intent);
                }
            }
        });

    }

}

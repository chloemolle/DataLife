package mastertransmedia.datalife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        final Globals globalVariables = (Globals) getApplicationContext();
        globalVariables.setNumberOfPlayer(0);
        globalVariables.setPlayersList(new ArrayList<Player>());

        final Button newGameButton = findViewById(R.id.new_game_button);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChosingNumberOfPlayerPage.class);
                startActivity(intent);
            }
        });

        //Initialization of the rooms
        ArrayList<String> rooms = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.rooms)));
        globalVariables.setRoomList(new ArrayList<Room>());
        for(int i = 0; i < rooms.size(); i ++) {
            String roomName = rooms.get(i);
            String changedRoomName = roomName.toLowerCase().replace(" ", "_");
            ArrayList<String> apps = new ArrayList<String>(Arrays.asList(getResources().getStringArray(getResources().getIdentifier(changedRoomName, "array", getPackageName()))));
            ArrayList<String> time = new ArrayList<String>(Arrays.asList(getResources().getStringArray(getResources().getIdentifier(changedRoomName + "_time", "array", getPackageName()))));
            Room newRoom = new Room(roomName, apps, time, false);
            globalVariables.getRoomList().add(newRoom);
        }

        ArrayList<Room> roomList = globalVariables.getRoomList();
        Integer test = 1;

    }


}

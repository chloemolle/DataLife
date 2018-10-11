package mastertransmedia.datalife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by chloemolle on 02/07/2018.
 */

public class ChosingNumberOfPlayerPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chosing_number_of_player_page);

        Button fourPlayerButton = findViewById(R.id.four_player_button);
        Button fivePlayerButton = findViewById(R.id.five_player_button);
        Button sixPlayerButton = findViewById(R.id.six_player_button);

        fourPlayerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayerCreationPage.class);
                intent.putExtra("Number_of_player", 2);
                intent.putExtra("Is_first_time", true);
                startActivity(intent);
            }
        });

        fivePlayerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayerCreationPage.class);
                intent.putExtra("Number_of_player", 5);
                intent.putExtra("Is_first_time", true);
                startActivity(intent);
            }
        });

        sixPlayerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayerCreationPage.class);
                intent.putExtra("Number_of_player", 6);
                intent.putExtra("Is_first_time", true);
                startActivity(intent);
            }
        });

    }

}

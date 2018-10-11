package mastertransmedia.datalife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by chloemolle on 02/07/2018.
 */

public class PlayerCreationPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_creation_page);

        final Integer remainingNumberOfPlayer = getIntent().getExtras().getInt("Number_of_player");
        Boolean firstTime = getIntent().getExtras().getBoolean("Is_first_time");

        final Globals globalVariables = (Globals) getApplicationContext();

        if (firstTime) {
            globalVariables.setNumberOfPlayer(remainingNumberOfPlayer);
        }

        TextView titleNewPlayer = findViewById(R.id.player_creation_title);
        titleNewPlayer.setText("Player " + (globalVariables.getNumberOfPlayer() - remainingNumberOfPlayer + 1));
        final EditText editTextName = findViewById(R.id.player_name);

        // Deal with the spinners
        Spinner spinnerFamily = (Spinner) findViewById(R.id.family_choices);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterFamily = ArrayAdapter.createFromResource(this,
                R.array.family_cards_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterFamily.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerFamily.setAdapter(adapterFamily);

        Spinner spinnerTaste = (Spinner) findViewById(R.id.taste_choices);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterTaste = ArrayAdapter.createFromResource(this,
                R.array.taste_cards_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterTaste.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTaste.setAdapter(adapterTaste);

        Spinner spinnerAffinity = (Spinner) findViewById(R.id.affinity_choices);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterAffinity = ArrayAdapter.createFromResource(this,
                R.array.affinity_cards_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterAffinity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAffinity.setAdapter(adapterAffinity);

        Spinner spinnerAspiration = (Spinner) findViewById(R.id.aspiration_choices);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterAspiration = ArrayAdapter.createFromResource(this,
                R.array.aspiration_cards_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterAspiration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAspiration.setAdapter(adapterAspiration);

        Spinner spinnerSecrets = (Spinner) findViewById(R.id.secrets_choices);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterSecrets = ArrayAdapter.createFromResource(this,
                R.array.secret_cards_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterSecrets.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSecrets.setAdapter(adapterSecrets);

        Button nextButton = findViewById(R.id.nextButton);
        final Spinner spinnerFamilyFinal = spinnerFamily;
        final Spinner spinnerTasteFinal = spinnerTaste;
        final Spinner spinnerAffinityFinal = spinnerAffinity;
        final Spinner spinnerAspirationFinal = spinnerAspiration;
        final Spinner spinnerSecretsFinal = spinnerSecrets;


        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // We register this player
                String familyCard = spinnerFamilyFinal.getSelectedItem().toString();
                String tasteCard = spinnerTasteFinal.getSelectedItem().toString();
                String affinityCard = spinnerAffinityFinal.getSelectedItem().toString();
                String aspirationCard = spinnerAspirationFinal.getSelectedItem().toString();
                String secretsCard = spinnerSecretsFinal.getSelectedItem().toString();
                String playerName = editTextName.getText().toString();
                if (playerName.equals("Name")) {
                    playerName = "Player " + (globalVariables.getNumberOfPlayer() - remainingNumberOfPlayer + 1);
                }
                if(secretsCard == "Hacker") {
                    Hacker player = new Hacker(playerName, familyCard, tasteCard, affinityCard, aspirationCard, secretsCard);
                    globalVariables.getPlayersList().add(player);

                } else{
                    Investigator player = new Investigator(playerName, familyCard, tasteCard, affinityCard, aspirationCard, secretsCard);
                    globalVariables.getPlayersList().add(player);
                }

                Intent intent = new Intent(v.getContext(), PlayerFinalPage.class);
                intent.putExtra("Number_of_player", (remainingNumberOfPlayer - 1));
                startActivity(intent);
            }
        });

    }

}

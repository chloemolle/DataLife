package mastertransmedia.datalife;

import java.util.ArrayList;

/**
 * Created by chloemolle on 02/07/2018.
 */

public abstract class Player {
    private String name;
    private String familyCard;
    private String tasteCard;
    private String affinityCard;
    private String aspirationCard;
    private String secretCard;
    private ArrayList<String> roomsTagged;
    private String previousRoom;

    public Player(String _name, String _familyCard, String _tasteCard, String _affinityCard, String _aspirationCard, String _secretCard) {
        this.name = _name;
        this.familyCard = _familyCard;
        this.tasteCard = _tasteCard;
        this.affinityCard = _affinityCard;
        this.aspirationCard = _aspirationCard;
        this.secretCard = _secretCard;
        this.roomsTagged = new ArrayList<String>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAffinityCard() {
        return affinityCard;
    }

    public void setAffinityCard(String affinityCard) {
        this.affinityCard = affinityCard;
    }

    public String getFamilyCard() {
        return familyCard;
    }

    public void setFamilyCard(String familyCard) {
        this.familyCard = familyCard;
    }

    public String getAspirationCard() {
        return aspirationCard;
    }

    public void setAspirationCard(String aspirationCard) {
        this.aspirationCard = aspirationCard;
    }

    public String getTasteCard() {
        return tasteCard;
    }

    public void setTasteCard(String tasteCard) {
        this.tasteCard = tasteCard;
    }

    public String getSecretCard() {
        return secretCard;
    }

    public void setSecretCard(String secretCard) {
        this.secretCard = secretCard;
    }

    public ArrayList<String> getRoomsTagged() {
        return roomsTagged;
    }

    public void setRoomsTagged(ArrayList<String> roomsTagged) {
        this.roomsTagged = roomsTagged;
    }

    public String getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(String previousRoom) {
        this.previousRoom = previousRoom;
    }
}

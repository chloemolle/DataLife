package mastertransmedia.datalife;

import java.util.ArrayList;

/**
 * Created by chloemolle on 02/07/2018.
 */

public class Room {

    private String name;
    private ArrayList<String> availableApplication; // Dans application penser à donner les types d'indices disponibles (3 et pas 4)
    private ArrayList<String> timeLocked;
    private Boolean isLocked;

    public Room(String _name, ArrayList<String> _availableApplication, ArrayList<String> _timeLocked, Boolean _isLocked){
        this.name = _name;
        this.availableApplication = _availableApplication;
        this.timeLocked = _timeLocked;
        this.isLocked = _isLocked;
    }


    /* getters and setters */
    public String getName() {
        return this.name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public ArrayList<String> getAvailabeApplication() {
        return this.availableApplication;
    }

    public void setAvailableApplication(ArrayList<String> _availableApplication) {
        this.availableApplication = _availableApplication;
    }

    public ArrayList<String> getTimeLocked() {
        return this.timeLocked;
    }

    public void setTimeLocked(ArrayList<String> _timeLocked) {
        this.timeLocked = _timeLocked;
    }

    public Boolean getIsLocked() {
        return this.isLocked;
    }

    public void setIsLocked(Boolean _isLocked) {
        this.isLocked = _isLocked;
    }

}

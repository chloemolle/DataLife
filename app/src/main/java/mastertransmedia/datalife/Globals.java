package mastertransmedia.datalife;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by chloemolle on 02/07/2018.
 */

public class Globals extends Application {
    private Integer numberOfPlayer;
    private ArrayList<Player> playersList;
    private Player currentPlayer;
    private Integer currentPlayerIndex;
    private Integer Time;
    private ArrayList<Room> roomList;
    private Room currentRoom;


    public Integer getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(Integer _numberOfPlayer) {
        numberOfPlayer = _numberOfPlayer;
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(ArrayList<Player> _players) {
        this.playersList = _players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        this.currentPlayerIndex = this.playersList.indexOf(currentPlayer);
    }

    public Integer getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(Integer currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
        this.currentPlayer = this.playersList.get(currentPlayerIndex);
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }
}

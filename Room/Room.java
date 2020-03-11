package Room;

import Character.Player;
import Ennemy.Ennemy;
import Game.Game;

import java.util.ArrayList;
import java.util.List;

public class Room extends Game {
    public ArrayList<Ennemy> ennemies;
    public List<Room> rooms;
    public Player player;

        public Room(ArrayList<Ennemy> ennemies, Player player) {
            this.ennemies = ennemies;
            this.player = player;
    }

    public void removeRoom(Room room_name)
    {
	    ennemies.remove(room_name);
    }

    public List<Room> getRoom()
        {
            return rooms;
        }

    public boolean roomOver(ArrayList<Room> rooms)
    {
        if(rooms != null)
            return true;
        return false;
    }
}
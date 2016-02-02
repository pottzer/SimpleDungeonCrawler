package level;

import level.Room;
import player.Player;
import src.GuiObserver;
import monster.*;
import item.*;

public class Level {
		//The amount of rooms in the level = to the size of the array.
        private Room[] room = new Room[101];

        private Room exitRoom;
        
        public Level(){
                //Creating all the rooms for the level
                room[0] = new Room(0,"Room 1","This is a extremtly filty room");
                room[1] = new Room(1,"Room 2","This room has a dead body in it");
                room[2] = new Room(2,"Room 3","This room has a dumdum in it");
                room[3] = new Room(3,"Room 4","This is a bed not a room silly");
                room[4] = new Room(4,"Room 5","This is a treasureden");
                room[5] = new Room(5,"Room 6","This is where i banged ur mom");
                room[100] = new Room(100,"Exit","You feel a breeze of fresh air when you step out of the cave");

                //Set the connections between the rooms
                room[0].setRoomConnections(room[1], null, room[4], null);
                room[1].setRoomConnections(null, room[2], room[0], null);
                room[2].setRoomConnections(null, room[100], room[3], room[1]);
                room[3].setRoomConnections(room[2], room[5], null, room[4]);
                room[4].setRoomConnections(room[0], room[3], null, null);
                room[5].setRoomConnections(null,null,null,room[3]);
                room[100].setRoomConnections(null, null, null, null);
                
                //Set an exit room
                setExitRoom(room[100]);

                //Creating all the monsters for the level.
                Monster dragon = new Dragon();
                Monster beast = new Beast();
                
                //Setting a monster to a room.
                room[2].setMonster(beast);
                room[5].setMonster(dragon);
                
                //Creating Items
                Item simpleSword = new SimpleSword();
                Item healthPotion = new HealthPotion();
                Item treasure = new Treasure();
                //Item key = new Key();
                Key yellowKey = new YellowKey();
                
                //LockRoom
                room[5].setRoomLocked(yellowKey);
                
                //Setting a item to a room.
                room[1].setItem(simpleSword);
                room[3].setItem(healthPotion);
                room[4].setItem(yellowKey);
                room[5].setItem(treasure);

        }
        
        //Get functions for the values in the level object
        public Room getExitRoom(){
        	return exitRoom;
        }
        
        //Function to get a room object
        public Room getRoom(int index){
        	return room[index];
        }
        
        //Functions to set the place where the player starts
        public void setStartRoom(Player player){
        	player.setNewPosition(room[0].getRoomIndex());
        }
        
        //Function to set the place where the player
        public Room setExitRoom(Room room){
        	return exitRoom = room;
        }


        
        //Functions that handles if the player is victorius
        public boolean isVictory(Player player){
        	if(player.getPosition() == exitRoom.getRoomIndex()){
        		for(int i = 0; i <player.getInventory().length; i++){
        			if(player.getInventory()[i] instanceof Treasure){
        				GuiObserver.trueWinner();
        				return true;
        			}
        		}
        		GuiObserver.fakeWinner();
        		return true;
        	}
        	return false;			
        }


}


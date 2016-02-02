package level;

import monster.*;
import item.*;

public class Room{
        private int index; //array index of the room
        private String name;
        private String description;
        private Room[] connections = new Room[4];
        
        private Item item;
        private Monster monster;
        
        private Key key;
        private boolean locked;
        
        //Constructor for a room
        public Room(int arrayIndex, String roomName, String roomDescription){
                index = arrayIndex;
                name = roomName;
                description = roomDescription;
                monster = null;
                item = null;
                
                locked = false;
                key = null;
        }
        
        //Room get value functions
        public int getRoomIndex(){
        	return index;
        }
        public String getRoomName(){
        	return name;
        }
        public String getRoomDescription(){
        	return description;
        }

        public Room getConnectedRoom(int orientation){
        	return connections[orientation];
        }

 //****Rooms for handling locks ****//      
        //Returns the needed key to unlock the lock
        public Key getKey(){
        	return key;
        }
        //Sets the key that will unlock the lock and locks the room
        public void setRoomLocked(Key roomKey){
        	key = roomKey;
        	locked = true;	
        }

        //Unlocks the room
        public void setRoomUnlocked(){
        	locked = false;
        }
        
        //Checks if the room is locked
        public boolean isRoomLocked(){
        	return locked;
        }
//*****Room connections****////
        //Functions that sets the connections in a room to other rooms
        public void setRoomConnections(Room north, Room east, Room south, Room west){
        	connections[0] = north;
            connections[1] = east;
            connections[2] = south;
            connections[3] = west;
        }
        //Checks if the room is connected to the given direction
        public boolean isRoomConnected(int orientation){
        	if(connections[orientation] == null){
        		return false;
        	}
        	else{
        		return true;
        	}
        }
 
 ///****Monster in rooms****///
        //Sets a monster in a room
        public void setMonster(Monster roomMonster){
        	monster = roomMonster;
        }
        //Returns the monster in the room
        public Monster getMonster(){
        	return monster;
        }
        

  ///***Items in rooms***///
        //Sets a item in a room
        public void setItem(Item roomItem){
        	item = roomItem;
        }

        //Returns the item in the room
        public Item getItem(){
        	return item;
        }

}

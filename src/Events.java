package src;

import player.Player;
import level.Room;

public class Events {
	
	//The function that handles a monster fight
	public static void fightMonster(Player player, Room room){
	        if(room.getMonster() != null){
	        	
	        	while((room.getMonster().getHealth() > 0) && (player.getCurrentHealth() > 0)){
	        		room.getMonster().takeDamage(player.dealDamage());
	        		player.takeDamage(room.getMonster().dealDamage());

	        	}
	        	
	        	if(player.isAlive()){
	        		GuiObserver.killedTheMonster(room);
	        		GuiObserver.healthLeft(player.getCurrentHealth(), player.getName());
	        		room.setMonster(null);
	        		GuiObserver.writeOutRoom(room);
	        		}
	        	}	        	        	       	 
	}
	
	//The functions that handles a locked door and unlocks it
    public static void unlockRoom(Player player, Room room){
    	if((room.getKey() == null) && (room.isRoomLocked() == false)){
    		return;
    	}
    	else{
    		for(int i = 0; i < player.getInventory().length; i++){
    			if(player.getInventory()[i] == room.getKey()){
    				room.setRoomUnlocked();
    				GuiObserver.unlockRoom(room);
    				return;
    			}
    		}
    		return;
    	}	
    }
}



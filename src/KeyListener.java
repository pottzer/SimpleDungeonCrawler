package src;

import player.Player;
import level.Level;
import src.GuiObserver;
import src.Events;


public class KeyListener {

		//Function that handles the different "Actions" Characters that are being entered
        public static void action(Player player, String move, Level level){
        		
                if((move.equals("n")) && (level.getRoom(player.getPosition()).isRoomConnected(0))){
                	
                	Events.unlockRoom(player, level.getRoom(player.getPosition()).getConnectedRoom(0));
                	if(level.getRoom(player.getPosition()).getConnectedRoom(0).isRoomLocked()){
                		GuiObserver.roomIsLocked();
                		GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));  
                	}
                	else{
                		player.setNewPosition(level.getRoom(player.getPosition()).getConnectedRoom(0).getRoomIndex());
                		GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                		 
                	}
                }

                else if((move.equals("e")) && (level.getRoom(player.getPosition()).isRoomConnected(1))){
                	
                	Events.unlockRoom(player, level.getRoom(player.getPosition()).getConnectedRoom(1));
                	if(level.getRoom(player.getPosition()).getConnectedRoom(1).isRoomLocked()){
                		GuiObserver.roomIsLocked();
                		GuiObserver.writeOutRoom(level.getRoom(player.getPosition())); 

                	}
                	else{
                		player.setNewPosition(level.getRoom(player.getPosition()).getConnectedRoom(1).getRoomIndex());
                		GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                		
                	}
                }


                else if((move.equals("s")) && (level.getRoom(player.getPosition()).isRoomConnected(2))){
                	
                	Events.unlockRoom(player, level.getRoom(player.getPosition()).getConnectedRoom(2));
                	if(level.getRoom(player.getPosition()).getConnectedRoom(2).isRoomLocked()){
                		GuiObserver.roomIsLocked();
                		GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                	}
                	else{
                		player.setNewPosition(level.getRoom(player.getPosition()).getConnectedRoom(2).getRoomIndex());
                		GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));                       
                	}
                }


                else if((move.equals("w")) && (level.getRoom(player.getPosition()).isRoomConnected(3))){
                	
                	Events.unlockRoom(player, level.getRoom(player.getPosition()).getConnectedRoom(3));
                	if(level.getRoom(player.getPosition()).getConnectedRoom(3).isRoomLocked()){	
                		GuiObserver.roomIsLocked();
                		GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                	}
                	else{
                		player.setNewPosition(level.getRoom(player.getPosition()).getConnectedRoom(3).getRoomIndex());
                		GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                        
                	}
                }
                
                else if((move.equals("p")) && (level.getRoom(player.getPosition()).getItem() != null)){
                		
                	GuiObserver.pickedUpItem(level.getRoom(player.getPosition()));
                		if(player.pickUpItem(level.getRoom(player.getPosition()).getItem())){             		           			
                			level.getRoom(player.getPosition()).setItem(null);               	
                			GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                		}
                		else{
                			GuiObserver.fullInventory();
                			GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                		}
                }
                
                else if((move.equals("d")) && (player.getPotion() != null)){
                		if(player.drinkPotion(player.getPotion())){
                			GuiObserver.drankPotion(player);
                			GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                		}
                		else{
                			GuiObserver.noPotion();
                			GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                		}
                }

                else{
                	GuiObserver.writeOutError(level.getRoom(player.getPosition()));
                }

        }

}


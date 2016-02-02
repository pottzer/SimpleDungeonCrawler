package src;

import level.Room;
import player.Player;


public class GuiObserver{
	
		//Printing out the room with accessories such as monster and items.
        public static void writeOutRoom(Room room){
               System.out.println(room.getRoomDescription());
                                
               if(room.getMonster() != null){
                	System.out.println(room.getMonster().getDescription());
                	if(room.getMonster().getMonsterPicture() != null){
                     	System.out.println(room.getMonster().getMonsterPicture());
                    }
                	return;
                
                }
               
               if(room.getItem() != null){
                	System.out.println(room.getItem().getItemDescription());
                	System.out.println("Do you want to pick up the item " + room.getItem().getItemName() + " type \"p\" and press ENTER.");
                	writeOutDirections(room);
                	return;
                }
               
               
                else if(room.getRoomName() == "Exit"){
                	return;
                }
                else{
                 	 writeOutDirections(room); 
                }
        }
        
        //Writing out if a character that the KeyListener didn't recognice was entered
        public static void writeOutError(Room room){
                System.out.println("You stumble and fall.");
                writeOutDirections(room);

        }
        
        //Writing out all the different directions to take in a room
        public static String writeOutDirections(Room room){
        	
        		
                String directions = "You see openings to the ";

                if(room.getConnectedRoom(0) != null){
                	if(room.getConnectedRoom(0).getRoomName() == "Exit"){
                		directions = directions + "north exit [n] ";
                	}
                	else{
                		directions = directions + "north [n] ";   
                	}	 
                }

                if(room.getConnectedRoom(1) != null){
                	if(room.getConnectedRoom(1).getRoomName() == "Exit"){
                		directions = directions + "east exit [e] ";
                	}
                	else{
                        directions = directions + "east [e] ";  
                	}	
  
                }

                if(room.getConnectedRoom(2) != null){
                	if(room.getConnectedRoom(2).getRoomName() == "Exit"){
                		directions = directions + "south exit [s] ";
                	}
                	else{
                        directions = directions + "south [s] ";  
                	}
                }

                if(room.getConnectedRoom(3) != null){
                	if(room.getConnectedRoom(3).getRoomName() == "Exit"){
                		directions = directions + "west exit [w] ";
                	}
                	else{
                        directions = directions + "west [w] ";  
                	}
                }
                
                System.out.println(directions);	
                return directions;


        }

 
 //*****ItemPrintOuts*****//
        
        //Prints out when you succesfully picked up a item
        public static void pickedUpItem(Room room){
        		System.out.println("You picked up "+ room.getItem().getItemName() + " and put it in your inventory.");
        }
        
        //Prints out when a player successfully drank a potion
        public static void drankPotion(Player player){
        	System.out.println(player.getPotion().getPotionEffect());
        }
        
        //Prints out when you have a full inventory
        public static void fullInventory(){
        	System.out.println("Your inventory is full");
        }
        
        //Prints out when you try to drink a potion but don't have one 
        public static void noPotion(){
        	System.out.println("You don't have a potion to drink");
        }
        
       

//**BattlePrintOuts**//
        //Print outs for fighting a monster
        public static void killedTheMonster(Room room){
        	System.out.println(room.getMonster().getDeathText());
        }
        //Prints outs the characters health left
        public static void healthLeft(int health, String name){
        	System.out.println(name +" have " + health + " left.");
        }
        
        //Prints how much the characters deals damage
        public static void dealDamage(int dmg, String name){
        	System.out.println(name + " deals "+ dmg + " damage.");
        }
        
 //*****Print Outs For Room Locks*****/////       
        
        //Print outs for rooms that are locked
        public static void unlockRoom(Room room){
        	System.out.println("The " + room.getKey().getItemName() + " fits and the door opens.");
        }
        
        //Print for when a player tryes to enter a locked room
        public static void roomIsLocked(){
        	System.out.println("The door to the room is locked, try to find a key for the door or you don't have the correct key");
        }


        
//******Game effects******//
        
        //Writing out the instructions when starting the game
        public static void instructions(Player player){
                System.out.println("Welcome " + player.getName()+ " to your treasure hunt. \nBeware of the monsters and parrels ahead of you, collect items on the way to defeat the monsters!");
                System.out.println("To make actions in the dungeons, caves and castles, you will type commands and press ENTER for example to walk east you type \"e\" and press ENTER.\nGOODLUCK!");
        }  
    
        //Writing out the intro text when a player has entered a dungeon
        public static void intro(){
        	System.out.println("You wake up with a headache in a room, you look around and realizes that");
        }
        
        //Prints out when you got the treasure and have left the dungeon
        public static void trueWinner(){
        	System.out.println("You leave the dungeon with your riches. Congratulations, you won");
        }
        //Prints out when you left the dungeon without the treasure
        public static void fakeWinner(){
        	System.out.println("You coward");
        }
        //Prints out when a player died
        public static void gameOver(){
        	System.out.println("You died... Game over");
        }


        
}


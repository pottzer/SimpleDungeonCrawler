package player;

import item.*;
import src.GuiObserver;

public class Player {
		private int maxHealth;
		private int currentHealth;
        private Weapon weapon;
        private Armor armor;
        private Potion potion;
        private Item[] inventory;
        private String name;
        private int position;

        //
        public Player(String charName){
        	maxHealth = 10;
        	currentHealth = maxHealth;
        	weapon = new NoWeapon();
            armor = new NoArmor();
            potion = null;
            //Setting how many items that can be had in the inventory
            inventory = new Item[5];
            name = charName;
                
        }
        
        //Get the player values;
        public int getMaxHealth(){
        	return maxHealth;
        }
        
        public int getCurrentHealth(){
        	return currentHealth;
        }
        
        public Weapon getWeapon(){
        	return weapon;
        }
        
        public Armor getArmor(){
        	return armor;
        }
        
        public Potion getPotion(){
        	return potion;
        }
        
        public Item[] getInventory(){
        	return inventory;
        }
        
        public String getName(){
        	return name;
        }
        
        public int getPosition(){
        	return position;
        }

        
        //Setting a players position to a room through an int value that is the index of the room
        public void setNewPosition(int newPosition){
                position = newPosition;
        }
        
        //Function to handle dealing damage
        public int dealDamage(){
        	GuiObserver.dealDamage(weapon.getDmg(), getName());
        	return weapon.getDmg();
        }
        
        //Function to handle taking damage
        public int takeDamage(int dmg){
        	currentHealth = currentHealth - (dmg - armor.getDefense());
        	GuiObserver.healthLeft(getCurrentHealth(), getName());
        	return currentHealth;
        	
        }
        
        //Check if the player is alive
        public boolean isAlive(){
        	if(currentHealth == 0){
        		return false;
        	}
        	else{
        		return true;
        	}
        }
        
        //Picking up a item as a player, putting it into it's inventory or equipping it
        public boolean pickUpItem(Item item){
        	if(item instanceof Weapon && weapon instanceof NoWeapon){
        		System.out.println("You equip the " + item.getItemName()+".");
        		weapon = (Weapon) item;
        		return true;
        	}
        	
        	else if(item instanceof Armor && armor instanceof NoArmor){
        		System.out.println("You equip the " + item.getItemName() +".");
        		armor = (Armor) item;
        		return true;
        	}
        	
        	else if(item instanceof Potion && potion == null){
       			System.out.println("To drink a potion type \"d\" then press ENTER.");
        		potion = (Potion) item;
        		return true;		
        	}
        	
        	else{
        		for(int i = 0; i < inventory.length; i++){
        			if(inventory[i] == null){
        				inventory[i] = item; 
        				return true;
        			}
        		}
        		return false;
        	}
        			
        }
        
        //Function for drink a health potion
        public boolean drinkPotion(Potion potion){
        	if(potion != null){
        		currentHealth = currentHealth + potion.getHealingValue();
        		if(currentHealth > maxHealth){
        			currentHealth = maxHealth;
        		}
        			potion = null;
        			return true;
        	}
        	return false;
        }
		
        
}


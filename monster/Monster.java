package monster;

import src.GuiObserver;

public class Monster{

    protected int health;
    protected int dmg;
    protected String name;
    protected String description;
    protected String picture;
    protected String monsterDeath;
    
    //Functions that returns the objects values
    public int getHealth(){
    	return health;
    }
    
    public int getDamage(){
    	return dmg;
    }
    
    public String getName(){
    	return name;
    }
    
    public String getDescription(){
    	return description;
    }

    public String getMonsterPicture(){
    	return picture;
    }

    public String getDeathText(){
    	return monsterDeath;
    }
    
//**Functions handling combat****///
    
    //Handling taking damage
    public void takeDamage(int damage){
    	health = health - damage;
    	GuiObserver.healthLeft(getHealth(), getName());
    	
    }
    
    //handling dealing damage
    public int dealDamage(){
    	GuiObserver.dealDamage(getDamage(), getName());
    	return dmg;
    }
    

    

}


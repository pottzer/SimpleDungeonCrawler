package item;

public class Potion extends Item{
	protected int health;
	protected String effect;
	
//**Functions that returns object values**//		
	public int getHealingValue(){
		return health;
	}
	
	public String getPotionEffect(){
		return effect;
	}
	
}

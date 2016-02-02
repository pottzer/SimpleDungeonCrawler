package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import player.Player;
import level.Level;


public class Core {
        public Player player;
        public Level level;
        
        private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //Struct for Core that creates the Level and the player as well as sets the players starting room and launching the game
        public Core() throws Exception {
                level = new Level();
                createPlayer();
                level.setStartRoom(player);
                launch();

        }
        
        //The game function this is a while true loop until the player leaves or dies.
        public void launch() throws Exception {
        	//Writing out all the intro
        	GuiObserver.instructions(player);
        	GuiObserver.intro();
        	GuiObserver.writeOutRoom(level.getRoom(player.getPosition()));
                
        		//The loop that keeps the game running.
                while(!(level.isVictory(player))){
                		Events.fightMonster(player, level.getRoom(player.getPosition()));
                		
                		if(!(player.isAlive())){
                			GuiObserver.gameOver();
                			System.exit(0);
                    	}
                		
                        String action = bufferedReader.readLine();
                        KeyListener.action(player, action, level);
                }
                System.exit(0);
                
        }

        //The function to create a player
    	public void createPlayer() throws Exception {
            System.out.println("Welcome adventurer, may i ask what your name is?");
            String name = bufferedReader.readLine();
            player = new Player(name);
    	} 
    	
        //Main function
    	public static void main(String[] argv) throws Exception {
            new Core();
        }

}

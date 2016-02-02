package src;

import static org.junit.Assert.*;

import org.junit.Test;

import player.Player;
import level.Room;
import item.Key;
import monster.*;

public class EventsTest {

	@Test
	public void fightMonsterTest() {
		//Creates the test room.
		Room testRoom = new Room(0, "testRoom","TestRoom");
		
		//Put the monster in the room.
		Beast testMonster = new Beast();		
		testRoom.setMonster(testMonster);
		
		assertSame("The monster in the room should be \"testMonster\"",testMonster,testRoom.getMonster());
		
		Player testPlayer = new Player("testPlayer");
		
		//Player and monster in room fight
		Events.fightMonster(testPlayer, testRoom);
		
		assertNull("The monster in the room should be dead", testRoom.getMonster());
	
		//Put dragon monster in room
		Dragon testDragon = new Dragon();
		testRoom.setMonster(testDragon);
		
		//Player and dragon in room fight
		Events.fightMonster(testPlayer, testRoom);
		assertFalse("Player should be dead", testPlayer.isAlive());
		

	}
	
	@Test
	public void unlockRoomTest(){
		//Creates the test room.
		Room testRoom = new Room(0,"testRoom","TestRoom");
		
		//Creates the test key and locks the test room with said key
		Key testKey = new Key();
		testRoom.setRoomLocked(testKey);
		
		assertSame("The key for the room should be \"testKey\" ", testKey, testRoom.getKey());
		assertTrue("Should be locked", testRoom.isRoomLocked());
		
		//Creates player and puts the key in players inventory
		Player testPlayer = new Player("testPlayer");
		//Player sets key in inventory
		testPlayer.pickUpItem(testKey);
		
		assertSame("The \"testKey\" should be in players inventory", testKey, testPlayer.getInventory()[0]);
		
		//Checks if player has key in inventory
		Events.unlockRoom(testPlayer, testRoom);
		
		assertFalse("Should be unlocked",testRoom.isRoomLocked());
		

		
	}

}

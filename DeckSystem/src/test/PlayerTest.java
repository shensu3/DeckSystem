/* @Author - Sushen Kumar Manchukanti
 * Title   - Deck system Card
 * Purpose - CustomInk Assignment 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import decklib.*;

//Testing all the methods in the Player class 
public class PlayerTest {
	
	public Player player = new Player("player");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		player.add(new Card("data",1));
		player.add(new Card("data",2));
		player.add(new Card("data",1));
	}

	@After
	public void tearDown() throws Exception {
		player.clear();
	}

	@Test
	public void nameTest() {
		assertEquals("player",player.name());
	}
	
	@Test(expected = Exception.class) 
	public void returnTest()
	{
		player.returnACard(0);
		assertEquals(player.remainingCards(),2);
		player.returnACard(0);
		player.returnACard(0);
		player.returnACard(0);
	}
	
	@Test
	public void totalTest()
	{
		assertEquals(4,player.score());
	}
	
	@Test(expected = Exception.class)
	public void compareTest()
	{
		assertEquals(player.compare(player.getCard(0),player.getCard(1)),-1);
		assertEquals(player.compare(player.getCard(1),player.getCard(0)),1);
		assertEquals(player.compare(player.getCard(0),player.getCard(2)),0);
		player.compare(player.getCard(0),null);
	}
	
	@Test
	public void clearTest()
	{
		player.clear();
		assertEquals(player.remainingCards(),0);
	}

}

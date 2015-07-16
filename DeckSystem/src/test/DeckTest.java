/* @Author - Sushen Kumar Manchukanti
 * Title   - Deck system Card
 * Purpose - CustomInk Assignment 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import decklib.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//Testing the functions in the Deck class
public class DeckTest {
	public Deck deck;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		deck=new Deck(11,12,13,14);
		deck.shuffle();
	}

	@After
	public void tearDown() throws Exception {
		deck.clear();
	}

	@Test
	public void remainingCardstest() 
	{
		assertEquals(deck.remainingCards(),52);
	}
	
	@Test 
	public void distributeTest()
	{
		Player player1 = new Player("player1");
		Player player2 = new Player("player2");
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		deck.distribute(players);
		assertEquals(deck.remainingCards(),0);
		assertEquals(player1.remainingCards(),26);
		assertEquals(player2.remainingCards(),26);
		deck.clear();
		player1.clear();
		player2.clear();
		deck.distribute(players);
		assertEquals(player1.remainingCards(),0);
		assertEquals(player2.remainingCards(),0);
	}
	@Test
	public void clearTest()
	{
		deck.clear();
		assertEquals(deck.remainingCards(),0);
	}
	
	@Test(expected = Exception.class)
	public void dealACardToPlayerTest()
	{
		Player player1 = new Player("player1");
		Player player2 = new Player("player2");
		deck.dealACardToPlayer(player1);
		deck.dealACardToPlayer(player2);
		assertEquals(deck.remainingCards(),50);
		assertEquals(player1.remainingCards(),1);
		assertEquals(player2.remainingCards(),1);
		deck.clear();
		deck.dealACardToPlayer(player1);
	}
	

}

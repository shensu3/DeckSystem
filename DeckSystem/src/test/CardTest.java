/* @Author - Sushen Kumar Manchukanti
 * Title   - Deck system Card
 * Purpose - CustomInk Assignment 
 */
package test;

import static org.junit.Assert.*;
import decklib.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//unit test for the Card class. Testing all the functions contained within it. 
public class CardTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String suit ="sample";
		int value = 0;
		Card card = new Card(suit,value);
		assertEquals("sample",card.getSuit());
		assertEquals(0,card.getValue());
	}

}

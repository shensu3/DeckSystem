package test;

import static org.junit.Assert.*;

import decklib.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import decklib.Helper;

public class HelperTest {
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
		sets set1 = Helper.getInstance();
		sets set2 = Helper.getInstance();
		assertEquals(set1,set2);
	}

}

/* @Author - Sushen Kumar Manchukanti
 * Title   - Deck system Card
 * Purpose - CustomInk Assignment 
 */
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//Test suite that runs all the unit tests

@RunWith(Suite.class)
@SuiteClasses({ CardTest.class, DeckTest.class, HelperTest.class,
		PlayerTest.class })
public class AllTests {
	
}

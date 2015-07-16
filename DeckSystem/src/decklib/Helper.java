/* @Author - Sushen Kumar Manchukanti
 * Title   - Deck system Card
 * Purpose - CustomInk Assignment 
 */
package decklib;

import java.util.ArrayList;

/*	helper class
 * 	implementing Singleton Pattern
 *	this class makes sure we have only one instance of sets object running. 
 *	so that it can be accessed by both the Deck object and Player object(s)
 */
public class Helper 
{
	//make sure theres only one instance
	private static sets set; 
	
	//making the constructor private to make sure this class doesn't get instantiated
	private Helper() 
	{	
	}
	
	//Just in case it is accessed by a number of threads at the same time
	public static synchronized sets getInstance()
	{
		if(set==null) //isn't created yet
		{
			set = new sets();
		}
		return set;
	}
}



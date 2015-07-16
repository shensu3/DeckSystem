/* @Author - Sushen Kumar Manchukanti
 * Title   - Deck system Card
 * Purpose - CustomInk Assignment 
 */
package decklib;

//Card class which defines card objects
public class Card 
{
	String suit;										//card object fields 	
	int value;											// suit and value
	
	//constructor to create a card with suit and value fields set
	public Card(String suit,int value)
	{
		this.suit=suit;
		this.value=value;
	}
	
	//getter method for suit
	public String getSuit()
	{
		return suit;
	}
	
	//getter method for value
	public int getValue()
	{
		return value;
	}

}

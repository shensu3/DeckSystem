/* @Author - Sushen Kumar Manchukanti
 * Title   - Deck system Card
 * Purpose - CustomInk Assignment 
 */
package decklib;

import java.util.ArrayList;

/*	player class has fields and methods for player objects
 */
public class Player 
{
	
	private ArrayList<Card> playerCards = new ArrayList<Card>();		//fields - arraylist of card objects &
	private String name;												//name of the player
	
	//assigning player name in the constructor
	public Player(String name)
	{
		this.name=name;
	}
	
	//get method for the name
	public String name()
	{
		return name;
	}
	
	//function returns card to the deck.
	public void returnACard(int index)
	{
		try
		{
			Helper.getInstance().deckSet.add((playerCards.remove(index))); 		//getting the singleton instance
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	//function displays the cards that the player has
	public void displayPlayerCards()
	{
		for(int i=0;i<playerCards.size();i++)
		{
			System.out.println(playerCards.get(i).suit+" "+playerCards.get(i).value);
		}
	}
	
	//function shows the remaining cards
	public int remainingCards()
	{
		return playerCards.size();
	}
	
	//function to caclulate score
	public int score()
	{
		int total=0;
		for(int i=0;i<playerCards.size();i++)
			total += playerCards.get(i).value;
		return total;	
	}
	
	//function to access a particular card
	public Card getCard(int index)
	{
		try
		{
		return playerCards.get(index);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* function that compares two cards
	 * I'm assuming that the players would be playing the game with each other
	 * so this would be where I'd put the compare function.
	 */
	public int compare(Card card1,Card card2)
	{
		try
		{
		if(card1.value>card2.value)
			return 1;
		else if(card1.value==card2.value)
			return 0;
		else
			return -1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	//function that adds a card from the deck to the player's cards
	public void add(Card card)
	{
		playerCards.add(card);
	}
	
	//clearing all the cards. could be useful when the game ends
	public void clear()
	{
		playerCards.clear();
	}
	
}

/* @Author - Sushen Kumar Manchukanti
 * Title   - Deck system Card
 * Purpose - CustomInk Assignment 
 */
package decklib;

import java.util.ArrayList;
import java.util.Random;

/*	Deck class whose object is the deck system.
 * 	I have used an ArrasyList to store the deck cards
 * 	As it is dynamic and also gives access to all the cards
 * 	instead of a stack/queue/hash 
 */
public class Deck 
{
	private final String suits[] ={"spade","heart","diamond","club"};	//suits don't change 
	private int faces[] =new int[4]; 							 		//4 cards King,Queen,Jack and Ace I'm letting the user set the score for these
	private sets set;													//set singleton object
	
	/*	Deck constructor takes 4 values the score of each of the face cards
	 * 	set by the user
	 */
	public Deck(int king,int queen, int jack, int ace)
	{
		faces[0]=king;								//assigning the values
		faces[1]=queen;								//
		faces[2]=jack;								//
		faces[3]=ace;								//
		
		set = Helper.getInstance();					//getting the singleton instance
		
		//Creating card objects and building the card set 
		for(int i=0;i<suits.length;i++)
		{
			for(int j=2;j<11;j++)
			{
				Card card = new Card(suits[i],j);
				set.deckSet.add(card);
			}
			for(int j=0;j<faces.length;j++)
			{
				Card card = new Card(suits[i],faces[j]);
				set.deckSet.add(card);
			}
		}
	}
	
	//Shuffling the cards using a shuffling algorithm (Fisher-Yates) using random function
	public void shuffle()
	{
		try
		{
			for(int i = set.deckSet.size()-1;i>=1;i--)
			{
				Card temp = set.deckSet.get(i);
				Random rand = new Random();
				int j = rand.nextInt(i);
				set.deckSet.set(i,set.deckSet.get(j));
				set.deckSet.set(j,temp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	//function that returns the remaining cards
	public int remainingCards()
	{
		return set.deckSet.size();
	}
	
	/*function that distributes the cards to all players
	 * the same way it is done in real life
	 * one card each person in a round robin fashion
	 * if the players list is null or if there are no players,
	 * the function returns false	 
	 */
	public Boolean distribute(ArrayList<Player> players)
	{
		if(players!=null && players.size()>0)
			{
				while(set.deckSet.size()>0)
				{
					for(int i=0;i<players.size();i++)
					{
					if(set.deckSet.size()==0)
						break;
					players.get(i).add(set.deckSet.remove(0));
					}
				}
			return true;
			}
		else
		{
			return false;
		}
	 }
	
	//Function that gives the first card in the deck to a player
	public void dealACardToPlayer(Player player)
	{
		try
		{
			player.add(set.deckSet.remove(0));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	//function that displays all the cards in the deck
	public void displayDeckCards()
	{
		for(int i=0;i<set.deckSet.size();i++)
		{
			System.out.println(set.deckSet.get(i).suit+" "+set.deckSet.get(i).value);
		}
	}
	
	//function that clears the deck. May be useful when the game ends?
	public void clear()
	{
		set.deckSet.clear();
	}
	
}

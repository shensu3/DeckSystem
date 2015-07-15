package decklib;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	private final String suits[] ={"spade","heart","diamond","club"}; 
	private final int faces[] ={11,12,13,14}; 							//j,q,k,A 
	private sets set;
	
	public void init()
	{
		set = Helper.getInstance();
		for(int i=0;i<suits.length;i++)
		{
			for(int j=2;j<15;j++)
			{
				Card card = new Card(suits[i],j);
				set.deckSet.add(card);
			}
		}
	}
	
	//Fisher–Yates shuffle
	public void shuffle() throws Exception
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
	
	public int remainingCards()
	{
		return set.deckSet.size();
	}
	
	public Boolean distribute(ArrayList<Player> players) throws Exception
	{
		try
		{
			while(set.deckSet.size()>=1)
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
		catch(Exception e)
		{
			for(int i=0;i<players.size();i++)
				players.get(i).clear();
			throw e;
		}
	}
	
	public Boolean dealACardToPlayer(Player player) throws Exception
	{
		try{
		if(set.deckSet.size()>=1)
			{
			player.add(set.deckSet.remove(0));
			return true;
			}
		else
			{
			return false;
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void displayDeckCards()
	{
		for(int i=0;i<set.deckSet.size();i++)
		{
			System.out.println(set.deckSet.get(i).suit+" "+set.deckSet.get(i).value);
		}
	}
	
	
	public static void main(String args[]) throws Exception
	{
		Deck deck = new Deck();
		deck.init();
		deck.shuffle();
		Player player1 = new Player("Arun");
		Player player2 = new Player("sushen");
		deck.displayDeckCards();
		System.out.println("deck remaining cards "+deck.remainingCards());
		deck.dealACardToPlayer(player1);
		deck.dealACardToPlayer(player2);
		System.out.println("player1 remaining cards "+player1.remainingCards());
		player1.returnACard(0);
		System.out.println("deck remaining cards "+deck.remainingCards());
		player2.displayPlayerCards();
		System.out.println(player2.score());
		System.out.println("\n\n");
		deck.displayDeckCards();
	}
}

package decklib;

import java.util.ArrayList;

public class Player 
{
	private ArrayList<Card> playerCards = new ArrayList<Card>();
	private String name;
	
	public Player(String name)
	{
		this.name=name;
	}
	
	public Boolean returnACard(int index)
	{
		if(playerCards.size()>=1)
		{
			Helper.getInstance().deckSet.add((playerCards.remove(index)));
			return true;
		}
		else
			return false;
	}
	
	public void displayPlayerCards()
	{
		for(int i=0;i<playerCards.size();i++)
		{
			System.out.println(playerCards.get(i).suit+" "+playerCards.get(i).value);
		}
	}
	
	public int remainingCards()
	{
		return playerCards.size();
	}
	
	public int score() throws Exception
	{
		try
		{
		int total=0;
		for(int i=0;i<playerCards.size();i++)
			total += playerCards.get(i).value;
		return total;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public void add(Card card)
	{
		playerCards.add(card);
	}
	
	public void clear()
	{
		playerCards.clear();
	}
	
}

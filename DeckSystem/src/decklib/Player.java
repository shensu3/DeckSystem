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
	
	public String name()
	{
		return name;
	}
	
	public void returnACard(int index)
	{
		try
		{
			Helper.getInstance().deckSet.add((playerCards.remove(index)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
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
	
	public int score()
	{
		int total=0;
		for(int i=0;i<playerCards.size();i++)
			total += playerCards.get(i).value;
		return total;	
	}
	
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
	
	public void add(Card card)
	{
		playerCards.add(card);
	}
	
	public void clear()
	{
		playerCards.clear();
	}
	
}

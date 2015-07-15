package decklib;

public class Card 
{
	String suit;
	int value;
	public Card(String suit,int value)
	{
		this.suit=suit;
		this.value=value;
	}
	public String getSuit()
	{
		return suit;
	}
	public int getValue()
	{
		return value;
	}

}

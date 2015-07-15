package decklib;

import java.util.ArrayList;

public class Helper 
{
	private static sets set;
	private Helper() //Making the constructor private
	{	
	}
	public static synchronized sets getInstance()
	{
		if(set==null)
		{
			set = new sets();
		}
		return set;
	}
}

class sets
{
	public ArrayList<Card> deckSet;
	//public ArrayList<Card> nonDeckSet;
	public sets()
	{
		deckSet = new ArrayList<Card>();
		//nonDeckSet = new ArrayList<Card>();
	}
}

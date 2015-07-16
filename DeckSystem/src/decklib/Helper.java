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



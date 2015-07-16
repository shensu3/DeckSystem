package decklib;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	private final String suits[] ={"spade","heart","diamond","club"}; 
	private int faces[] =new int[4]; 							//j,q,k,A 
	private sets set;
	
	public Deck(int king,int queen, int jack, int ace)
	{
		faces[0]=king;
		faces[1]=queen;
		faces[2]=jack;
		faces[3]=ace;
		
		set = Helper.getInstance();
		
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
	
	//Fisher–Yates shuffle
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
		}
	}
	
	public int remainingCards()
	{
		return set.deckSet.size();
	}
	
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
	
	public void displayDeckCards()
	{
		for(int i=0;i<set.deckSet.size();i++)
		{
			System.out.println(set.deckSet.get(i).suit+" "+set.deckSet.get(i).value);
		}
	}
	
	public void clear()
	{
		set.deckSet.clear();
	}
	
	
	public static void main(String args[]) 
	{
		Deck deck = new Deck(11,12,13,14);
		deck.shuffle();
		Player player1 = new Player("Arun");
		Player player2 = new Player("sushen");
		deck.displayDeckCards();
		System.out.println("deck remaining cards "+deck.remainingCards());
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(player1);
		playerList.add(player2);
		deck.distribute(playerList);
		System.out.println("player1 remaining cards "+player1.remainingCards());
		//player1.returnACard(0);
		System.out.println("deck remaining cards "+deck.remainingCards());
		player2.displayPlayerCards();
		System.out.println(player2.score());
		System.out.println("\n\n");
		deck.displayDeckCards();
	}
}

package card.player;

public class Player 
{
	private String name;
	private int    score = 0;
	
	public Player(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String toString()
	{
		return getName() + ": " + score;
	}
	
	public void incrementScore(int increase)
	{
		score = score + increase;
	}
}
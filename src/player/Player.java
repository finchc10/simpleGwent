package player;

public class Player 
{
	private String name;
	private String color;
	private int    score = 5;
	
	public Player(String name, String color)
	{
		this.name  = name;
		this.color = color;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
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
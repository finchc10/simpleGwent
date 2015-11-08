///**
// * @author Cory Finch
// */
//
//package player;
//
//import java.util.ArrayList;
//
//import algorithm.Node;
//import game.Game;
//import game.GameBoard;
//import card.Card;
//import card.CardReader;
//import card.Hand;
//
///**
// * Represents a participant in this game. There are only two players, blue and red. The red player is controlled by AI and blue
// * is controlled by a human player.
// */
//public class Player 
//{
//	// true for blue (human) false for red (AI)
//	private boolean color;
//	private int    score = 5;
//	private Hand   hand;
//	
//	public Player(boolean color)
//	{
//		this.color = color;
//		hand = CardReader.readHand(getColorString());
//	}
//		
//	public boolean getColor()
//	{
//		return color;
//	}
//	
//	public String getColorString()
//	{
//		if(color)
//		{
//			return "blue";
//		}
//		else
//		{
//			return "red";
//		}
//	}
//	
//	public int getScore()
//	{
//		return score;
//	}
//	
//	public String toString()
//	{
//		return getColor() + ": " + score;
//	}
//	
//	public void incrementScore(int increase)
//	{
//		score = score + increase;
//	}
//	
//	public Hand getHand()
//	{
//		return hand;
//	}
//	
//	public void playCard(GameBoard board)
//	{
//		if(color)
//		{
//			
//		}
//		else
//		{
//			// ai, use negamax
//		}
//	}
//	
//	private int negaMax(Game game, int depth, boolean color)
//	{
//		int factor = 1;
//		
//		if(color)
//		{
//			factor = -1;
//		}
//		
//		if(depth == 0 || game.getBoard().gameIsOver())
//		{
//			return factor * game.getBoard().heuristicValue();
//		}
//		else
//		{
//			int bestValue = Integer.MIN_VALUE;
//			int bestMove  = -1;
//			
//			Node n = new Node(game.getBoard(), game.getRedHand(), game.getBlueHand());
//			
//			ArrayList<Node> moves = new ArrayList<Node>();
//			
//			
//			
//			return -1;
//		}
//	}
//}
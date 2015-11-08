package algorithm;

import java.util.ArrayList;

import game.Game;

public class AI 
{
	public static void main(String args[])
	{
		Game g = new Game();
		g.playCard(true, 0, 0, 0);
		g.playCard(false, 0, 0, 1);
		g.playCard(true, 1, 0, 2);
		g.playCard(false, 1, 1, 0);
		g.playCard(true, 2, 1, 1);
//		System.out.println(g.toString());
		System.out.println(getNextMove(g));
	}
	
	public static int getNextMove(Game game)
	{
		int depth = game.getBoard().openSpaces();
		return negaMax(game, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static int negaMax(Game game, int depth, int alpha, int beta)
	{
		System.out.println(game.getBoard().toString());
		int factor = 1;
		boolean playersTurn = game.getWhoseTurn();
		
		//true if it's blue's turn
		if(playersTurn)
		{
			factor = -1;
		}
		
		if(depth == 0 || game.gameIsOver())
		{
			return factor * game.getBoard().heuristicValue();
		}
		else
		{
			int bestValue = Integer.MIN_VALUE;
			
			ArrayList<Game> children = game.generateChildren(playersTurn);
			
			for(Game g : children)
			{
				int value = -negaMax(g, depth - 1, -beta, -alpha);
				
				if(value > bestValue)
				{
					bestValue = value;
				}
				
				if(value > alpha)
				{
					alpha = value;
				}
				
				if(alpha >= beta)
				{
					break;
				}
			}
			
			return bestValue;
		}
	}
}

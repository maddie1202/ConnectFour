package codes;

public class Board 
{
	int[][] slots;
	int rows;
	int columns;
	
	public Board(int initialValues,int rows, int columns)
	{
		setRows(rows);
		setColumns(columns);
		
		slots = new int[rows][columns];
		
		for(int a = 0; a < rows; a++)
			for(int b = 0; b < columns; b++)
				setSlots(a,b,initialValues);
	}
	
	public void setSlots(int x, int y, int value)
	{
		slots[x][y] = value;
	}
	
	public int getSlots(int x, int y)
	{
		return slots[x][y];
	}
	
	public void setRows(int value)
	{
		rows = value;
	}
	
	public int getRows()
	{
		return rows;
	}
	
	public void setColumns(int value)
	{
		columns = value;
	}
	
	public int getColumns()
	{
		return columns;
	}
	
	//the following methods look for specific patterns in each possible direction and return true when these patters are found
	//They are given specific amount of specific pieces to look for in each of the possible four concecutive pieces
	
	public static boolean verticalConcecutive(Board copy, Player player, Player opponent,int playerTargetPieces, int opponentTargetPieces,int AITargetPlayerPieces,int AITargetOpponentPieces)
	{	
		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int playerPiece = 0;
		int AIPlayerPiece = 0;
		int AIOpponentPiece = 0;
		
		for (int row = 0; row < 3; row++)
			for (int column = 0; column < copy.getColumns(); column++)
			{
				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					if(copy.getSlots(row+concecutive, column) == opponent.getToken())
						opponentPiece++;
					else if(copy.getSlots(row+concecutive, column) == player.getToken())
						playerPiece++;
					else if(copy.getSlots(row+concecutive,column) == player.getAIToken())
						AIPlayerPiece++;
					else if(copy.getSlots(row+concecutive,column) == opponent.getAIToken())
						AIOpponentPiece++;
				}
				
				
				if(opponentPiece == opponentTargetPieces && playerPiece == playerTargetPieces && AIPlayerPiece == AITargetPlayerPieces && AIOpponentPiece == AITargetOpponentPieces)
					return true;
				
				opponentPiece = 0;
				playerPiece = 0;
				AIPlayerPiece = 0;
				AIOpponentPiece = 0;
			}	
	
		return false;
		
	}
	
	public static boolean horizontalConcecutive(Board copy, Player player, Player opponent,int playerTargetPieces, int opponentTargetPieces,int AITargetPlayerPieces,int AITargetOpponentPieces)
	{

		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int playerPiece = 0;
		int AIPlayerPiece = 0;
		int AIOpponentPiece = 0;
		
		for (int row = 0; row < copy.getRows(); row++)
			for (int column = 0; column < 4; column++)
			{

				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					if(copy.getSlots(row, column+concecutive) == opponent.getToken())
						opponentPiece++;
					else if(copy.getSlots(row, column+concecutive) == player.getToken())
						playerPiece++;
					else if(copy.getSlots(row,column+concecutive) == player.getAIToken())
						AIPlayerPiece++;
					else if(copy.getSlots(row,column+concecutive) == opponent.getAIToken())
						AIOpponentPiece++;
				}
	
				if(opponentPiece == opponentTargetPieces && playerPiece == playerTargetPieces && AIPlayerPiece == AITargetPlayerPieces && AIOpponentPiece == AITargetOpponentPieces)
					return true;
				
				opponentPiece = 0;
				playerPiece = 0;
				AIPlayerPiece = 0;
				AIOpponentPiece = 0;	
			}	
		
		return false;
					
	}
	
	public static boolean diagonalLeftToRightConcecutive(Board copy, Player player, Player opponent,int playerTargetPieces, int opponentTargetPieces,int AITargetPlayerPieces,int AITargetOpponentPieces)
	{

		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int playerPiece = 0;
		int AIPlayerPiece = 0;
		int AIOpponentPiece = 0;

		for (int row = 0; row < 3; row++)
			for (int column = 0; column < 4; column++)
			{	

				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					if(copy.getSlots(row+concecutive, column+concecutive) == opponent.getToken())
						opponentPiece++;
					else if(copy.getSlots(row+concecutive, column+concecutive) == player.getToken())
						playerPiece++;
					else if(copy.getSlots(row+concecutive, column+concecutive) == player.getAIToken())
						AIPlayerPiece++;
					else if(copy.getSlots(row+concecutive, column+concecutive) == opponent.getAIToken())
						AIOpponentPiece++;
				}
		
				if(opponentPiece == opponentTargetPieces && playerPiece == playerTargetPieces && AIPlayerPiece == AITargetPlayerPieces && AIOpponentPiece == AITargetOpponentPieces)
					return true;
				
				opponentPiece = 0;
				playerPiece = 0;
				AIPlayerPiece = 0;
				AIOpponentPiece = 0;
				
			}	
		
		return false;
					
	}
	
	public static boolean diagonalRightToLeftConcecutive(Board copy, Player player, Player opponent,int playerTargetPieces, int opponentTargetPieces,int AITargetPlayerPieces,int AITargetOpponentPieces)
	{

		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int playerPiece = 0;
		int AIPlayerPiece = 0;
		int AIOpponentPiece = 0;
		
		for (int row = 0; row < 3; row++)
			for (int column = copy.getColumns()-1; column >= 3; column--)
			{
				
				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					if(copy.getSlots(row+concecutive, column-concecutive) == opponent.getToken())
						opponentPiece++;
					else if(copy.getSlots(row+concecutive, column-concecutive) == player.getToken())
						playerPiece++;
					else if(copy.getSlots(row+concecutive, column-concecutive) == player.getAIToken())
						AIPlayerPiece++;
					else if(copy.getSlots(row+concecutive, column-concecutive) == opponent.getAIToken())
						AIOpponentPiece++;
				}

				if(opponentPiece == opponentTargetPieces && playerPiece == playerTargetPieces && AIPlayerPiece == AITargetPlayerPieces && AIOpponentPiece == AITargetOpponentPieces)
					return true;
				
				opponentPiece = 0;
				playerPiece = 0;
				AIPlayerPiece = 0;
				AIOpponentPiece = 0;
				
			}	
		
		return false;
					
	}
	
	//This method is separate from the rest because it looks beyond the 4 consecutive patterns
	//It doesn't go through the pattern method for the same reason
	//It is called directly from the Player class
	//It looks for 3 opponent pieces and for the player AI pieces in the row below the consecutive 4 pattern
	//It is present to prevent the AI from placing a piece that will allow for for the opponent to stack their pieces on top and win
	
	public static boolean canOpponentWinNextTurn (Board copy, Player player, Player opponent)
	{
		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int openPiece = 0;
		
		for (int row = 1; row < copy.getRows(); row++) //Checking horizontal patterns
			for (int column = 0; column < 4; column++)
			{
				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					
					if(copy.getSlots(row, column+concecutive) == opponent.getToken())
						opponentPiece++;
					else if(copy.getSlots(row-1, column+concecutive) == player.getAIToken())
						openPiece++;
				}
						
				if(opponentPiece == 3 && openPiece == 1)
					return true;
				
				opponentPiece = 0;
				openPiece = 0;
				
			}
		
		for (int row = 0; row < 3; row++) //Checking diagonal left to right patterns
			for (int column = 0; column < 4; column++)
			{	
				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					if(copy.getSlots(row+concecutive, column+concecutive) == opponent.getToken())
						opponentPiece++;
					
					try
					{
						if(copy.getSlots(row+concecutive-1, column+concecutive) == player.getAIToken())
							openPiece++;
					}
					
					catch (Exception e)
					{
						continue;
					}
					
				}

				
				if(opponentPiece == 3 && openPiece ==1)
					return true;
				
				opponentPiece = 0;
				openPiece = 0;
			}
		
		for (int row = 0; row < 3; row++) //Checking diagonal right to left patterns
			for (int column = copy.getColumns()-1; column >= 3; column--)
			{	
				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					if(copy.getSlots(row+concecutive, column-concecutive) == opponent.getToken())
						opponentPiece++;
					try
					{
						if(copy.getSlots(row+concecutive-1, column-concecutive) == player.getAIToken())
							openPiece++;
					}
					
					catch (Exception e)
					{
						continue;
					}
					
				}
				
				if(opponentPiece == 3 && openPiece ==1)
					return true;
				
				opponentPiece = 0;
				openPiece = 0;
			}
		
		return false;
	}
	
	//This method just calls the methods that analyze the patterns. It is present for organizational purposes
	
	public static boolean pattern (Board copy, Player player, Player opponent,int playerPieces, int opponentPieces,int AIPlayerPieces,int AIOpponentPieces)
	{
		if(Board.verticalConcecutive(copy,player,opponent,playerPieces,opponentPieces,AIPlayerPieces,AIOpponentPieces))
			return true;
		
		if(Board.horizontalConcecutive(copy,player,opponent,playerPieces,opponentPieces,AIPlayerPieces,AIOpponentPieces))
			return true;
		
		if(Board.diagonalLeftToRightConcecutive(copy,player,opponent,playerPieces,opponentPieces,AIPlayerPieces,AIOpponentPieces))
			return true;
		
		if(Board.diagonalRightToLeftConcecutive(copy,player,opponent,playerPieces,opponentPieces,AIPlayerPieces,AIOpponentPieces))
			return true;
		
		return false;
	}
}

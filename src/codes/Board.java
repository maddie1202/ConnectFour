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
	
	public static boolean verticalConcecutive(Board copy, Player player, Player opponent,int playerTargetPieces, int opponentTargetPieces,int AITargetPlayerPieces,int AITargetOpponentPieces,int targetOpenPieces)
	{	
		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int playerPiece = 0;
		int AIPlayerPiece = 0;
		int AIOpponentPiece = 0;
		int openPiece = 0;
		
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
					//else if(Game.row(copy, column) == row+concecutive)
						//openPiece++;
				}
				
				
				if(opponentPiece == opponentTargetPieces && playerPiece == playerTargetPieces && AIPlayerPiece == AITargetPlayerPieces && AIOpponentPiece == AITargetOpponentPieces && openPiece == targetOpenPieces)
					return true;
				
				opponentPiece = 0;
				playerPiece = 0;
				AIPlayerPiece = 0;
				AIOpponentPiece = 0;
				openPiece = 0;
			}	
	
		return false;
		
	}
	
	public static boolean horizontalConcecutive(Board copy, Player player, Player opponent,int playerTargetPieces, int opponentTargetPieces,int AITargetPlayerPieces,int AITargetOpponentPieces,int targetOpenPieces)
	{

		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int playerPiece = 0;
		int AIPlayerPiece = 0;
		int AIOpponentPiece = 0;
		int openPiece = 0;
		
		//System.out.println("Horizontal Check!");
		
		for (int row = 0; row < copy.getRows(); row++)
			for (int column = 0; column < 4; column++)
			{

				//System.out.println("Row: " + row);
				//System.out.println("Column: " + column);
			
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
					//else if(Game.row(copy, column+concecutive) == row)
						//openPiece++;
					//System.out.println(row + " = " + Game.row(copy,column+concecutive));
				}
			
				/*
				System.out.println("Opponent Pieces: " + opponentPiece);
				System.out.println("Player Pieces: " + playerPiece);
				System.out.println("AI PLayer Pieces: " + AIPlayerPiece);
				System.out.println("AI Opponent Pieces: " + AIOpponentPiece);
				System.out.println("Open Pieces: " + openPiece);
				*/
						
				if(opponentPiece == opponentTargetPieces && playerPiece == playerTargetPieces && AIPlayerPiece == AITargetPlayerPieces && AIOpponentPiece == AITargetOpponentPieces && openPiece == targetOpenPieces)
					return true;
				
				opponentPiece = 0;
				playerPiece = 0;
				AIPlayerPiece = 0;
				AIOpponentPiece = 0;
				openPiece = 0;
				
			}	
		
		return false;
					
	}
	
	public static boolean diagonalLeftToRightConcecutive(Board copy, Player player, Player opponent,int playerTargetPieces, int opponentTargetPieces,int AITargetPlayerPieces,int AITargetOpponentPieces,int targetOpenPieces)
	{

		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int playerPiece = 0;
		int AIPlayerPiece = 0;
		int AIOpponentPiece = 0;
		int openPiece = 0;
		
		//System.out.println("Diagonal Left to Right Check!");
		
		for (int row = 0; row < 3; row++)
			for (int column = 0; column < 4; column++)
			{	
				//System.out.println("Row: " + row);
				//System.out.println("Column: " + column);
				
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
					//else if(Game.row(copy, column+concecutive) == row+concecutive)
						//openPiece++;
				}
				
				/*
				System.out.println("Opponent Pieces: " + opponentPiece);
				System.out.println("Player Pieces: " + playerPiece);
				System.out.println("AI PLayer Pieces: " + AIPlayerPiece);
				System.out.println("AI Opponent Pieces: " + AIOpponentPiece);
				System.out.println("Open Pieces: " + openPiece);
				*/
				
				if(opponentPiece == opponentTargetPieces && playerPiece == playerTargetPieces && AIPlayerPiece == AITargetPlayerPieces && AIOpponentPiece == AITargetOpponentPieces && openPiece == targetOpenPieces)
					return true;
				
				opponentPiece = 0;
				playerPiece = 0;
				AIPlayerPiece = 0;
				AIOpponentPiece = 0;
				openPiece = 0;
				
			}	
		
		return false;
					
	}
	
	public static boolean diagonalRightToLeftConcecutive(Board copy, Player player, Player opponent,int playerTargetPieces, int opponentTargetPieces,int AITargetPlayerPieces,int AITargetOpponentPieces,int targetOpenPieces)
	{

		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int playerPiece = 0;
		int AIPlayerPiece = 0;
		int AIOpponentPiece = 0;
		int openPiece = 0;
		
		//System.out.println("Diagonal Right to Left Check!");
		
		for (int row = 0; row < 3; row++)
			for (int column = copy.getColumns()-1; column >= 3; column--)
			{
				//System.out.println("Row: " + row);
				//System.out.println("Column: " + column);
				
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
					//else if(Game.row(copy, column-concecutive) == row+concecutive)
						//openPiece++;
				}
				
				/*
				System.out.println("Opponent Pieces: " + opponentPiece);
				System.out.println("Player Pieces: " + playerPiece);
				System.out.println("AI PLayer Pieces: " + AIPlayerPiece);
				System.out.println("AI Opponent Pieces: " + AIOpponentPiece);
				System.out.println("Open Pieces: " + openPiece);
				*/

				if(opponentPiece == opponentTargetPieces && playerPiece == playerTargetPieces && AIPlayerPiece == AITargetPlayerPieces && AIOpponentPiece == AITargetOpponentPieces && openPiece == targetOpenPieces)
					return true;
				
				opponentPiece = 0;
				playerPiece = 0;
				AIPlayerPiece = 0;
				AIOpponentPiece = 0;
				openPiece = 0;
				
			}	
		
		return false;
					
	}
	
	public static boolean canOpponentWinNextTurn (Board copy, Player player, Player opponent)
	{
		int numberOfConcecutivePieces = 4;
		int opponentPiece= 0;
		int openPiece = 0;
		
		for (int row = 1; row < copy.getRows(); row++)
			for (int column = 0; column < 4; column++)
			{
				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					
					if(copy.getSlots(row, column+concecutive) == opponent.getToken())
						opponentPiece++;
					else if(copy.getSlots(row-1, column+concecutive) == player.getAIToken())
						openPiece++;
				}
				
				//System.out.println("Opponent Piece: " + opponentPiece);
				//System.out.println("Open Piece: " + openPiece);
						
				if(opponentPiece == 3 && openPiece == 1)
					return true;
				
				opponentPiece = 0;
				openPiece = 0;
				
			}
		
		for (int row = 1; row < 3; row++)
			for (int column = 0; column < 4; column++)
			{	
				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					if(copy.getSlots(row+concecutive, column+concecutive) == opponent.getToken())
						opponentPiece++;
					else if(copy.getSlots(row+concecutive-1, column+concecutive) == player.getAIToken())
						openPiece++;
				}

				
				if(opponentPiece == 3 && openPiece ==1)
					return true;
				
				opponentPiece = 0;
				openPiece = 0;
			}
		
		for (int row = 1; row < 3; row++)
			for (int column = copy.getColumns()-1; column >= 3; column--)
			{	
				for(int concecutive = 0; concecutive < numberOfConcecutivePieces; concecutive++)
				{
					if(copy.getSlots(row+concecutive, column-concecutive) == opponent.getToken())
						opponentPiece++;
					else if(copy.getSlots(row+concecutive-1, column-concecutive) == player.getAIToken())
						openPiece++;
				}

				
				if(opponentPiece == 3 && openPiece ==1)
					return true;
				
				opponentPiece = 0;
				openPiece = 0;
			}
		
		return false;
	}
	
	public static boolean pattern (Board copy, Player player, Player opponent,int playerPieces, int opponentPieces,int AIPlayerPieces,int AIOpponentPieces, int openPieces)
	{
		if(Board.verticalConcecutive(copy,player,opponent,playerPieces,opponentPieces,AIPlayerPieces,AIOpponentPieces,openPieces))
			return true;
		
		if(Board.horizontalConcecutive(copy,player,opponent,playerPieces,opponentPieces,AIPlayerPieces,AIOpponentPieces,openPieces))
			return true;
		
		if(Board.diagonalLeftToRightConcecutive(copy,player,opponent,playerPieces,opponentPieces,AIPlayerPieces,AIOpponentPieces,openPieces))
			return true;
		
		if(Board.diagonalRightToLeftConcecutive(copy,player,opponent,playerPieces,opponentPieces,AIPlayerPieces,AIOpponentPieces,openPieces))
			return true;
		
		return false;
	}
}

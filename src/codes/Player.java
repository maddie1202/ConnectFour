package codes;

import java.util.Scanner;

public class Player 
{
	int token;
	int AItoken;
	boolean isHuman;
	
	public Player(int token, boolean isHuman)
	{
		setToken(token);
		setIsHuman(isHuman);
	}
	
	public void setToken(int playerToken)
	{
		token = playerToken;
	}
	
	public int getToken()
	{
		return token;
	}
	
	public void setAIToken(int token)
	{
		AItoken = token;
	}
	
	public int getAIToken()
	{
		return AItoken;
	}
	
	public void setIsHuman(boolean setIsHuman)
	{
		isHuman = setIsHuman;
	}
	
	public boolean getIsHuman()
	{
		return isHuman;
	}
	
	public static int errorTrap (int min, int max)
	{
		Scanner input = new Scanner(System.in); // Create scanner
		
		boolean inputSucess; // Boolean for error trap
		int number = 0;
	
		do
		{
			inputSucess = true; //Reset the boolean to assume the user isn't an idiot and will enter the correct data
		
			//Scanner input = new Scanner(System.in);
				
			try
			{
				number = input.nextInt();
			}
				
			catch (Exception e) //If an error occurs in the try statement, catch all exceptions
			{
				input.nextLine(); //Clear the stream of the user entered data
				inputSucess = false; //Set 'inputSucess' to false so the program will loop back to the prompt
			}
				
			if (number < min || number > max || inputSucess == false) //Test if the data is in the correct range
			{
				Graphics.displayMessage("Invalid data, try again."); //Informs stupid user that they entered the wrong data
			}
				
		}while (number < min || number > max || inputSucess == false); //Loop back to the prompt if data is incorrect
		
		return number;
	}
	
	public static int randomNumberGenerator (int min, int max)
	{
		int number = (int) (Math.random() * (max - min + 1) + min); //Create random number
		return number;
	}
	
	public static int highestNumber(int[] manta)
	{
		int highesNumber = manta[0];//start the higher number at [0] to have something to compare to
		
		for (int a = 0; a < manta.length; a++)
		{
			if (manta[a] > highesNumber)
				highesNumber = manta[a]; //if [a] is larger than the previous highest number, then change it to the highest number
		}
		
		return highesNumber;
	}
	
	public static int indexOfHighestNumber(int[] manta)
	{
		int highestNumber = -100;//start the higher number at [0] to have something to compare to
		int highestIndex = 0;
		
		for (int a = 0; a < manta.length; a++)
		{
			if (manta[a] > highestNumber)
			{
				highestNumber = manta[a];
				highestIndex = a;
			}
				 //if [a] is larger than the previous highest number, then change it to the highest number
		}
		
		return highestIndex;
	}
	
	public static int duplicateHighestNumber(int[] scores)
	{
		int highestNumber = highestNumber(scores);
		int count = 0;
		
		for (int a = 0; a < scores.length; a++)
			if(scores[a] == highestNumber)
				count++;
		
		return count;
	}
	
	public static int[] possibleMoves(int[] scores, int numberOfPossibleMoves)
	{
		int[] possibleMoves = new int [numberOfPossibleMoves];
		int highestNumber = highestNumber(scores);
		
		int counter = 0;
		
		for(int a = 0; a < scores.length; a++)
			if(scores[a] == highestNumber)
			{
				possibleMoves[counter] = a;
				counter++;
			}
		
		/*
		System.out.println("Possible Moves: ");
		
		for(int a = 0; a < possibleMoves.length; a++)
			System.out.print(possibleMoves[a] + " ");
		
		System.out.println();
		*/
						
		return possibleMoves;
	}
	
	public static int bestMove(int[] scores)
	{
		int bestMoves = duplicateHighestNumber(scores);
		//System.out.println("Best moves: " + bestMoves);
		int bestMove = 0;
		int random;
		
		if(bestMoves == 1)
			bestMove = indexOfHighestNumber(scores);
		
		else
		{
			random = randomNumberGenerator(0,bestMoves-1);
			//System.out.println("Random: " + random);
			int[] possibleMoves = possibleMoves(scores,bestMoves);
			bestMove = possibleMoves[random];
		}
			
			
		return bestMove;
			
	}
	
	public static Board copyBoard(Board original)
	{
		Board copy = new Board (0,original.getRows(), original.getColumns());
		
		for (int a = 0; a < copy.getRows(); a++)
			for (int b = 0; b < copy.getColumns(); b++)
				copy.setSlots(a, b, original.getSlots(a, b));
			
		return copy;
	}
	
	public static boolean canWinThisTurn(Board copy,Player player,Player opponent)
	{
		int playerPieces = 3;
		int opponentPieces = 0;
		int AIPlayerPieces = 1;
		int AIOpponentPieces = 0;
		int openPieces = 0;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces,openPieces))
			return true;
		
		return false;
			
	}
	
	public static boolean canBlockOpponentWin(Board copy, Player player, Player opponent)
	{
		int playerPieces = 0;
		int opponentPieces = 3;
		int AIPlayerPieces = 1;
		int AIOpponentPieces = 0;
		int openPieces = 0;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces,openPieces))
			return true;
		
		return false;
	}
	
	
	public static boolean canOpponentWinNextTurn(Board copy, Player player, Player opponent)
	{
		int playerPieces = 0;
		int opponentPieces = 3;
		int AIPlayerPieces = 0;
		int AIOpponentPieces = 0;
		int openPieces = 1;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces,openPieces))
			return true;
		
		return false;
	}
	
	public static boolean canBlockOpponentPattern(Board copy,Player player, Player opponent)
	{
		int playerPieces = 0;
		int opponentPieces = 2;
		int AIPlayerPieces = 1;
		int AIOpponentPieces = 0;
		int openPieces = 0;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces,openPieces))
			return true;
		
		return false;
	}

	public static boolean canStartPattern(Board copy,Player player, Player opponent)
	{
		int playerPieces = 2;
		int opponentPieces = 0;
		int AIPlayerPieces = 1;
		int AIOpponentPieces = 0;
		int openPieces = 0;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces,openPieces))
			return true;
		
		return false;
	}
	
	public static int evaluateMove(Board copy,int column, Player player, Player opponent)
	{
		if(canWinThisTurn(copy,player,opponent))
			return 10;
		if(canBlockOpponentWin(copy,player,opponent))
			return  9;
		if(Board.canOpponentWinNextTurn(copy,player,opponent))
			return -9;
		if(canBlockOpponentPattern(copy,player,opponent))
			return 4;
		if(canStartPattern(copy,player,opponent))
			return 3;
		else
			return 0;
	}
	
	public static int getMoveAI (Board slots, Player player, Player opponent)
	{
		Board copy = new Board (0,slots.getRows(),slots.getColumns());
		
		int [] scores = new int [copy.getColumns()];
		
		for (int column = 0; column < copy.getColumns(); column++)
		{
			if(Game.row(slots, column) == -1)//if the column is full
			{
				scores[column] = -11;
				continue;
			}
				
			copy = copyBoard(slots);
			copy.setSlots(Game.row(copy, column), column, player.getAIToken());
			//Graphics.displaySlots(copy);
			scores[column] = evaluateMove(copy,column,player,opponent);
			//System.out.println("Row: " + Game.row(copy,column) + " Column: " + column + " Value: " + copy.getSlots(Game.row(copy,column), column));
		}
		
		System.out.println();
		System.out.print("Scores: ");
		
		for(int a = 0; a < scores.length; a++)
			System.out.print(scores[a] + " ");
		
		System.out.println();
			
		return bestMove(scores);
	}
	
	public static int getMoveHuman(Board slots)
	{
		int column;
		int row;
		
		do
		{
			column = errorTrap(1,7) - 1;
			row = Game.row(slots,column);
			
			if(row == -1)
				Graphics.displayMessage("This column is full, pick another one.");
			
		}while(row == -1);
		
		return column;
	}
}

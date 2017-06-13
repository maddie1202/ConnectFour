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
	
	public static int indexOfHighestNumber(int[] manta) //Returns the index of the highest number
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
	
	public static int duplicateHighestNumber(int[] scores) //Returns the number of duplicate highest numbers
	{
		int highestNumber = highestNumber(scores);
		int count = 0;
		
		for (int a = 0; a < scores.length; a++)
			if(scores[a] == highestNumber)
				count++;
		
		return count;
	}
	
	public static int[] possibleMoves(int[] scores, int numberOfPossibleMoves) // returns an array of the indexes of the best moves
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
		int bestMoves = duplicateHighestNumber(scores); //Calculates the number of best moves (if there are duplicates in the scores array)
		//System.out.println("Best moves: " + bestMoves);
		int bestMove = 0;
		int random;
		
		if(bestMoves == 1) //If there's only one best move, return the highest number
			bestMove = indexOfHighestNumber(scores);
		
		else //If there's more than one best move, chose one randomly 
		{
			random = randomNumberGenerator(0,bestMoves-1);
			//System.out.println("Random: " + random);
			int[] possibleMoves = possibleMoves(scores,bestMoves);
			bestMove = possibleMoves[random];
		}
			
			
		return bestMove;
			
	}
	
	public static Board copyBoard(Board original) //Creates a copy of the given board
	//Is also used for reseting the copied board
	{
		Board copy = new Board (0,original.getRows(), original.getColumns());
		
		for (int a = 0; a < copy.getRows(); a++)
			for (int b = 0; b < copy.getColumns(); b++)
				copy.setSlots(a, b, original.getSlots(a, b));
			
		return copy;
	}
	
	//The following methods look for patterns in the board, and returns true if they find them
	
	public static boolean canWinThisTurn(Board copy,Player player,Player opponent)
	{
		int playerPieces = 3;
		int opponentPieces = 0;
		int AIPlayerPieces = 1;
		int AIOpponentPieces = 0;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces))
			return true;
		
		return false;
			
	}
	
	public static boolean canBlockOpponentWin(Board copy, Player player, Player opponent)
	{
		int playerPieces = 0;
		int opponentPieces = 3;
		int AIPlayerPieces = 1;
		int AIOpponentPieces = 0;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces))
			return true;
		
		return false;
	}
	
	public static boolean canBlockOpponentPattern(Board copy,Player player, Player opponent)
	{
		int playerPieces = 0;
		int opponentPieces = 2;
		int AIPlayerPieces = 1;
		int AIOpponentPieces = 0;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces))
			return true;
		
		return false;
	}

	public static boolean canStartPattern(Board copy,Player player, Player opponent)
	{
		int playerPieces = 2;
		int opponentPieces = 0;
		int AIPlayerPieces = 1;
		int AIOpponentPieces = 0;
		
		if(Board.pattern(copy, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces))
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
				scores[column] = -10;
				continue;
			}
				
			copy = copyBoard(slots);  //Reset the copied board
			copy.setSlots(Game.row(copy, column), column, player.getAIToken()); //Place AI piece in the current column
			//Graphics.displaySlots(copy);
			scores[column] = evaluateMove(copy,column,player,opponent); //Give current column a score to compare with other possible columns
		}
		
		System.out.println();
		System.out.print("Scores: ");
		
		for(int a = 0; a < scores.length; a++)
			System.out.print(scores[a] + " ");
		
		System.out.println();
			
		return bestMove(scores); //Returns the highest score(the best possible move)
		//If there are two moves with the same score, it choses randomly
	}
	
	public static int getMoveHuman(Board slots)
	{
		int column;
		int row;
		
		do
		{
			column = errorTrap(1,7) - 1; // -1 because the board array starts at 0 and ends at 6 and it's easier for the user to understand 1 to 7
			row = Game.row(slots,column);
			
			if(row == -1) //meaning the column is full
				Graphics.displayMessage("This column is full, pick another one.");
			
		}while(row == -1);//Try again if the row is full
		
		return column;
	}
}

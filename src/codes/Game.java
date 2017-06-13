package codes;

import java.util.Scanner;

public class Game 
{
	static int difficulty;
	
	public static int getDifficulty()
	{
		return difficulty;
	}
	
	public static void setDifficulty (int setDifficulty)
	{
		difficulty = setDifficulty;
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
				
			if (number < min || number > max || inputSucess == false) //Test if the data is in the correct rang
			{
				Graphics.displayMessage("Invalid data, try agin."); //Informs stupid user that they entered the wrong data
			}
				
		}while (number < min || number > max || inputSucess == false); //Loop back to the prompt if data is incorrect
		
		return number;
	}
	
	public static boolean isGameTied(Board slots)
	{
		for(int a = 0; a < slots.getRows(); a++)
			for(int b = 0; b < slots.getColumns(); b++)
				if(slots.getSlots(a, b) == 0)
					return false;
		
		return true;
	}
	
	public static boolean isGameWon(Board slots,Player player, Player opponent)
	{
		int playerPieces = 4;
		int opponentPieces = 0;
		int AIPlayerPieces = 0;
		int AIOpponentPieces = 0;
		int openPieces = 0;
		
		
		if(Board.pattern(slots, player, opponent, playerPieces, opponentPieces, AIPlayerPieces, AIOpponentPieces,openPieces))
			return true;
				
		return false;
	}
	
	public static int row (Board slots, int column)
	{
		for(int a = 0; a < slots.getRows(); a++)
			if(slots.getSlots(a,column) == 0)
				return a;
	
		return -1;
	}
	
	public static int changeTurn (int currentTurn)
	{
		if(currentTurn == 1)
			return 2;
		
		else 
			return 1;
	}
	
	public static void playGame()
	{
		int player1Token = 1;
		int player2Token = 2;
		int rows = 6;
		int columns = 7;
		
		Player player1 = new Player(player1Token,true);
		Player player2 = new Player(player2Token,true);
		
		player1.setAIToken(3);
		player2.setAIToken(4);
		
		int playerTurn = 1;
		int column = 0;
		int row = 0;
		
		int playAgain = 1;
		int playerMode = 1;
		
		do
		{
			Board slots = new Board(0,rows,columns);
			
			Graphics.displayMessage("Enter 1 for 1 player or, 2 for 2 player: ");
			playerMode = errorTrap(1,2);
			
			if(playerMode == 1)
			{
				player1.setIsHuman(true);
				player2.setIsHuman(false);
			}
			
			if(playerMode == 2)
			{
				player1.setIsHuman(true);
				player2.setIsHuman(true);
			}
			
			do
			{
				if(playerTurn == 1)
					Graphics.displayMessage("Player 1's turn.");
				
				else
					Graphics.displayMessage("Player 2's turn.");
				
				Graphics.displaySlots(slots);

				if(playerTurn == 1)
				{
					if(player1.isHuman)
						column = Player.getMoveHuman(slots);
					
					else
						column = Player.getMoveAI(slots,player1,player2);
					
					row = row(slots,column);
					
					slots.setSlots(row,column,player1.getToken());
					
				}
					
				else if (playerTurn == 2)
				{
					if(player2.isHuman)
						column = Player.getMoveHuman(slots);
					
					else
						column = Player.getMoveAI(slots,player2,player1);
					
					row = row(slots,column);
					
					slots.setSlots(row,column,player2.getToken());
					
				}

				playerTurn = changeTurn(playerTurn);
							
			}while(!isGameWon(slots, player1,player2) && !isGameWon(slots,player2,player1) && !isGameTied(slots));
			
			Graphics.displaySlots(slots);
			
			if(isGameWon(slots, player1,player2))
				Graphics.displayMessage("Player 1 won!");
			
			else if (isGameWon(slots,player2,player1))
				Graphics.displayMessage("Player 2 won!");
			
			else if (isGameTied(slots))
				Graphics.displayMessage("Tie game.");
			
			Graphics.displayMessage("Do you want to play again? (1 for yes, 2 for no) ");
			playAgain = errorTrap(1,2);
			
		}while(playAgain ==1);

	}
}

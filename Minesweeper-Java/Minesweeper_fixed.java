import java.util.Scanner;

public class Minesweeper_fixed {

	static final int GAME_EXIT = 1;
	static final int GAME_CONTINUE = 2;
	static final int GAME_RESTART = 3;
	static final int GAME_LOST = 4;
	static final int GAME_WON = 5;

	private static MineField field;
	private static Ranking rank;	

	/* Print rankings, print gameinfo and continue the game until
	 * user inputs to exit the game */
	public static void main(String[] args) {
		rank=new Ranking();
		mainMessage();
		while(gameCountinue() != GAME_EXIT);
		System.out.println("\nThank you for playing :) Have a nice day!");
	}	

	/* Contiune the game. Take input from user, and call a method to 
	 * parse the input. As long as the return for the action is not
	 * exit or restart, contine to take inputs.
	 */
	private static int gameCountinue() {
		field = new MineField();
		int result = 0;
		int game_status = GAME_CONTINUE;

		Scanner in = null;
		String input = null;
		Boolean game;


		while(game_status == GAME_CONTINUE) {
			field.show();
			System.out.print("\nPlease enter your move(row col): ");
			in = new Scanner(System.in);
			input = in.nextLine();

			game_status = checkInput(input, result);
		}

		return game_status;
	}

	/* Check the input from user, and call correspoing methods */
	private static int checkInput(String input, int result) {
		if (input.equals("top")) rank.show();
		else if (input.equals("restart")) {
			return endRound(result, GAME_RESTART);
		}
		else if (input.equals("exit")) {
			return endRound(result, GAME_EXIT);
		}
		else if (field.legalMoveString(input)) { 
			return legalMove(result);
		}
		else if (field.getBoom()) {
			return endRound(result, GAME_LOST);
		}
		return GAME_CONTINUE;
	}

	/* Do a legal move */
	private static int legalMove (int result) {
		result++;
		if(result == 35) {
			return endRound(result, GAME_WON);
		}
		return GAME_CONTINUE;
	}

	/* Method to end the round 
	 * Take in results to write to write as a record,
	 * and code to return the game state 
	 */
	public static int endRound(int result, int code) {
		if(code == GAME_LOST) {
			System.out.println("\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
		} else if (code == GAME_WON) {
			System.out.println("Congratulations you WON the game!");
		}
		rank.recordName(result);
		return code;
	}
	
	/* Print info strings, with instructions for the game */
	private static void mainMessage(){
		System.out.println("Welcome to Minesweeper!");
		System.out.println("To play just input some coordinates and try not to step ont mine :)");
		System.out.println("Usefull commands:");
		System.out.println("restart- Starts a new game.");
		System.out.println("exit- Quits the game.");
		System.out.println("top- Reveals the top scoreboard.");
		System.out.println("Have Fun !");
	}
}

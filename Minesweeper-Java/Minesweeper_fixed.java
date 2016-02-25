import java.util.Scanner;

public class Minesweeper {

	private static MineField field;
	private static Ranking rank;	
	public static void main(String[] args) {
		rank=new Ranking();
		mainMessage();
		while(gameCountinue());
		System.out.println("\nThank you for playing :) Have a nice day!");
	}	
	private static boolean gameCountinue() {
		field = new MineField();
		int result = 0;
		while (true) {

			field.show();
			System.out.print("\nPlease enter your move(row col): ");
			Scanner in = new Scanner(System.in);
			String input = in.nextLine();

			if (input.equals("top")) {
				rank.show();
				continue;
			}
			if (input.equals("restart")) {
				rank.recordName(result);
				return true;
			}
			if (input.equals("exit")) {
				rank.recordName(result);
				return false;
			}
			if (field.legalMoveString(input)) {
				result++;
				if (result == 35) {
					System.out.println("Congratulations you WON the game!");
					{
						rank.recordName(result);
						return true;
					}
				}
				continue;
			}
//			if(input.equals("exit")){
//				rank.recordName(result);
//				return false;
//			}
//			if(field.legalMoveString(input)){
//				result++;
//				if(result==35){
//					System.out.println("Congratulations you WON the game!");
//					rank.recordName(result);
//					return true;
//				}
//				continue;
//			}
			else if (field.getBoom()) {
					return boom();
				}
		}
    }

	private static boolean boom() { 
		System.out.println("\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
		rank.recordName(result);
		return true;
	}

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

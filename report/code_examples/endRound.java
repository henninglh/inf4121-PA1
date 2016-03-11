public static int endRound(int result, int code) {
	if(code == GAME_LOST) {
		System.out.println("\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
	} else if (code == GAME_WON) {
		System.out.println("Congratulations you WON the game!");
	}
	rank.recordName(result);
	return code;
}


public static int endRound(int result, int code) {
	if(code == GAME_LOST) {
		System.out.println("\nBoooooooooooooooooooooooooo!...");
	} else if (code == GAME_WON) {
		System.out.println("Congratulations you WON the game!");
	}
	rank.recordName(result);
	return code;
}


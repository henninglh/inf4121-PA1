static final int GAME_EXIT = 1;
static final int GAME_CONTINUE = 2;
static final int GAME_RESTART = 3;
static final int GAME_LOST = 4;
static final int GAME_WON = 5;

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



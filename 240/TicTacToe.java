import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class TicTacToe {
	static Scanner in;
	static String[] board;
	static String turn;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		startBoard();

		System.out.println("Let's Play Tic Tac Toe.");
		printBoard();
		System.out.println("Your turn. Pick a space:");
		
		playGame();

	}
	
	static void playGame() {
		String gameEnd = null;
		while (gameEnd == null) {
			int numInput;
			try {
				if (turn.equals("O")) {
					double randomDouble = Math.random();
					randomDouble = randomDouble * 9 + 1;
					numInput = (int) randomDouble;
					if (!(numInput > 0 && numInput <= 9)) {
						throw new InputMismatchException();
					}
				}
				else {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					throw new InputMismatchException();
				}
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid space! Enter any number to try again.");
				in.next();
				System.out.println("Your turn. Pick a space:");
				continue;
			}
			if (board[numInput-1].equals(String.valueOf(numInput))) {
				board[numInput-1] = turn;
				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
				printBoard();
				gameEnd = evaluateWin();
			} else {
				System.out.println("That space's been picked! Try again.");
				continue;
			}
		}
		if (gameEnd.equalsIgnoreCase("draw")) {
			System.out.println("You both lose! Try again next time.");
		} else {
			System.out.println(gameEnd);
		}
	}
	
	static void startBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}
	
	static void printBoard() {
		System.out.println("*---*---*---*");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("*------+---*");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("*---+---+---*");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("*---*---*---*");
	}

	static String evaluateWin() {
		for (int i = 0; i < 8; i++) {
			String line = null;
			switch (i) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				if (i == 0) {
					return "X's win! 1-2-3 horizontal win.";
				}
				if (i == 1) {
					return "X's win! 3-5-6 horizontal win.";
				}
				if (i == 2) {
					return "X's win! 7-8-9 horizontal win.";
				}
				if (i == 3) {
					return "X's win! 1-4-7 vertical win.";
				}
				if (i == 4) {
					return "X's win! 2-5-8 vertical win.";
				}
				if (i == 5) {
					return "X's win! 3-6-9 vertical win.";
				}
				if (i == 6) {
					return "X's win! 1-5-9 diagonal win.";
				}
				if (i == 7) {
					return "X's win! 3-5-7 diagonal win.";
				}
			} else if (line.equals("OOO")) {
				if (i == 0) {
					return "O's win! 1-2-3 horizontal win.";
				}
				if (i == 1) {
					return "O's win! 3-5-6 horizontal win.";
				}
				if (i == 2) {
					return "O's win! 7-8-9 horizontal win.";
				}
				if (i == 3) {
					return "O's win! 1-4-7 vertical win.";
				}
				if (i == 4) {
					return "O's win! 2-5-8 vertical win.";
				}
				if (i == 5) {
					return "O's win! 3-6-9 vertical win.";
				}
				if (i == 6) {
					return "O's win! 1-5-9 diagonal win.";
				}
				if (i == 7) {
					return "O's win! 3-5-7 diagonal win.";
				}
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println(turn + "'s turn. Choose a space for your " + turn);
		return null;
	}
}
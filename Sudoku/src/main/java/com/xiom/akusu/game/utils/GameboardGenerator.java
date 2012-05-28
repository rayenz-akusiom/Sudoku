package com.xiom.akusu.game.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xiom.akusu.enums.DifficultyLevel;
import com.xiom.akusu.game.Gameboard;

public class GameboardGenerator {

	public static Gameboard generate(DifficultyLevel difficulty) {

		Gameboard generatedBoard = new Gameboard();

		generatedBoard.setDifficulty(difficulty);
		generatedBoard.setSolution(generateSolution());
		generatedBoard.setCurrentBoard(generatedBoard.getSolution());
		// generatedBoard.setCurrentBoard(pruneSolutionForDifficulty(generatedBoard.getSolution(),
		// difficulty));

		return generatedBoard;
	}

	private static int[][] pruneSolutionForDifficulty(int[][] board, DifficultyLevel difficulty) {
		int toRemove = 9 * 9 - difficulty.getSpotsToFill();

		Random randomGenerator = new Random();

		for (; toRemove > 0; toRemove--) {
			int x = randomGenerator.nextInt(9);
			int y = randomGenerator.nextInt(9);

			if (board[x][y] != 0) {
				board[x][y] = 0;
			} else {
				toRemove++;
			}
		}

		return board;
	}

	private static int[][] generateSolution() {

		// int[][] board = generateDefaultSolution();

		return generateBoard();
	}

	private static int[][] generateBoard() {
		List<List<Integer>> xSet = new ArrayList<List<Integer>>();
		List<List<Integer>> ySet = new ArrayList<List<Integer>>();
		List<List<Integer>> quadrantSet = new ArrayList<List<Integer>>();
		int[][] board = new int[9][9];

		for (int s = 0; s < 9; s++) {
			List<Integer> xSingleSet = new ArrayList<Integer>();
			List<Integer> ySingleSet = new ArrayList<Integer>();
			List<Integer> quadrantSingleSet = new ArrayList<Integer>();

			for (int i = 1; i <= 9; i++) {
				xSingleSet.add(Integer.valueOf(i));
				ySingleSet.add(Integer.valueOf(i));
				quadrantSingleSet.add(Integer.valueOf(i));
			}

			xSet.add(xSingleSet);
			ySet.add(ySingleSet);
			quadrantSet.add(quadrantSingleSet);
		}

		Random randomGenerator = new Random();
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				int quadrant = x % 3 + y / 3;

				board[x][y] = 0;
				while (board[x][y] == 0) {
					int i = randomGenerator.nextInt(xSet.get(x).size());
					Integer value = xSet.get(x).get(i);

					if (xSet.get(x).contains(value) && ySet.get(y).contains(value) && quadrantSet.get(quadrant).contains(value)) {
						// Remove from lists
						xSet.get(x).remove(value);
						ySet.get(y).remove(value);
						quadrantSet.get(quadrant).remove(value);

						// Set the value
						board[x][y] = value.intValue();

						System.out.println("Successfully placed: " + value);
					} else {
						System.out.println("Placement failed for: " + value);
					}
				}
			}
		}

		return board;
	}

	private static int[][] generateDefaultSolution() {

		int[][] board = new int[9][9];

		for (int x = 0; x < 9; x++) {

			int offset = x % 3 + (2 * (x % 3)) + x / 3;

			for (int y = 0; y < 9; y++) {
				board[x][y] = offsetValue(y, offset);
			}
		}

		return board;
	}

	private static int offsetValue(int value, int offset) {
		return value - offset + 1 + (value < offset ? 9 : 0);
	}
}

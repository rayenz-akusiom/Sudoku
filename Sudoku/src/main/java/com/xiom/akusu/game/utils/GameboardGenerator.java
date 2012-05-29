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

		for (; toRemove > 0; toRemove--)
		{
			int x = randomGenerator.nextInt(9);
			int y = randomGenerator.nextInt(9);

			if (board[x][y] != 0)
			{
				board[x][y] = 0;
			} else
			{
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
		List<List<Integer>> xSet = initializeSet();
		List<List<Integer>> ySet = initializeSet();
		List<List<Integer>> quadrantSet = initializeSet();
		List<List<Integer>> occupiedQuadrantSet = initializeSet();
		int[][] board = new int[9][9];

		Random randomGenerator = new Random();
		// For each number (1 - 9)
		for (Integer number = 1; number <= 9; number++)
		{
			// For each quadrant
			for (int q = 0; q < 9; q++)
			{
				List<Integer> occQ = new ArrayList<Integer>(occupiedQuadrantSet.get(q));

				boolean placed = false;
				while (!placed)
				{
					// Generate number (0-8) representing a space in the quadrant
					int q_index = randomGenerator.nextInt(occQ.size());
					Integer q_index_value = occQ.get(q_index);

					// Determine the x/y values and initialize the board space
					int xR = ((q / 3) * 3) + ((q_index - 1) / 3);
					int yR = ((q % 3) * 3) + ((q_index - 1) % 3);
					System.out.println(q + " " + q_index_value + " " + occQ.size());
					System.out.println("x=" + xR + ", y=" + yR);

					// Determine the valid numbers
					List<List<Integer>> intersections = new ArrayList<List<Integer>>();
					intersections.add(new ArrayList<Integer>(xSet.get(xR)));
					intersections.add(new ArrayList<Integer>(ySet.get(yR)));
					intersections.add(new ArrayList<Integer>(quadrantSet.get(q)));
					List<Integer> intersection = determineIntersection(intersections);
					System.out.println("Intersection: " + intersection);

					// Validate space
					if (intersection.contains(number))
					{
						// Update the board
						board[xR][yR] = number.intValue();
						occupiedQuadrantSet.get(q).remove(q_index);
						placed = true;

						// Update the placement values
						xSet.get(xR).remove(number);
						ySet.get(yR).remove(number);
						quadrantSet.get(q).remove(number);
					} else
					{
						occQ.remove(q_index);
					}

					// Output results
					System.out.println("Results so far:");
					Gameboard outBoard = new Gameboard();
					outBoard.setCurrentBoard(board);
					outBoard.print();

				}
			}
		}

		return board;
	}

	private static List<List<Integer>> initializeSet() {

		List<List<Integer>> toReturn = new ArrayList<List<Integer>>();

		for (int j = 0; j < 9; j++)
		{
			List<Integer> singleSet = new ArrayList<Integer>();
			for (Integer i = 1; i <= 9; i++)
			{
				singleSet.add(i);
			}
			toReturn.add(singleSet);
		}

		return toReturn;
	}

	private static List<Integer> determineIntersection(List<List<Integer>> intersections) {
		if (intersections.size() == 0)
		{
			return null;
		}

		List<Integer> intersection = intersections.get(0);
		for (int i = 0; i < intersections.size(); i++)
		{
			for (int s = 0; s < intersection.size(); s++)
			{
				if (!intersections.get(i).contains(intersection.get(s)))
				{
					intersection.remove(s);
					s--;
				}
			}
		}

		return intersection;
	}

	private static int[][] generateDefaultSolution() {

		int[][] board = new int[9][9];

		for (int x = 0; x < 9; x++)
		{

			int offset = x % 3 + (2 * (x % 3)) + x / 3;

			for (int y = 0; y < 9; y++)
			{
				board[x][y] = offsetValue(y, offset);
			}
		}

		return board;
	}

	private static int offsetValue(int value, int offset) {
		return value - offset + 1 + (value < offset ? 9 : 0);
	}
}

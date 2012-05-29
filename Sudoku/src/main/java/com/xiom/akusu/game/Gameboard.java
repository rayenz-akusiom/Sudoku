package com.xiom.akusu.game;

import com.xiom.akusu.enums.DifficultyLevel;

public class Gameboard {

	private static final int EMPTY_SPACE = 0;
	private static final int TOTAL_SPACES = 9 * 9;

	private int[][] solution;
	private int[][] currentBoard;
	private int spacesInvalid;

	public void setSolution(int[][] solution) {
		this.solution = solution;
	}

	public int[][] getSolution() {
		return solution;
	}

	public void setCurrentBoard(int[][] currentBoard) {
		this.currentBoard = currentBoard;
	}

	public int[][] getCurrentBoard() {
		return currentBoard;
	}

	public boolean isCompleted() {
		return spacesInvalid == 0;
	}

	public void setDifficulty(DifficultyLevel difficulty) {
		spacesInvalid = TOTAL_SPACES - difficulty.getSpotsToFill();
	}

	public boolean move(int xMove, int yMove, int value) {
		if (currentBoard[xMove][yMove] == EMPTY_SPACE)
		{

			if (validateMove(xMove, yMove, value))
			{
				currentBoard[xMove][yMove] = value;
				spacesInvalid--;

				return true;
			}
		}

		return false;
	}

	private boolean validateMove(int xMove, int yMove, int value) {
		return validateX(xMove, value) && validateY(yMove, value) && validateQuadrant(xMove, yMove, value);
	}

	private boolean validateQuadrant(int xMove, int yMove, int value) {
		// Determine quadrant
		int xQuadrant = xMove / 3;
		int yQuadrant = yMove / 3;

		for (int x = xQuadrant * 3; x < (xQuadrant * 3) + 3; x++)
		{
			for (int y = yQuadrant * 3; y < (yQuadrant * 3) + 3; y++)
			{
				if (currentBoard[x][y] == value)
				{
					return false;
				}
			}
		}

		return true;
	}

	private boolean validateY(int yMove, int value) {
		for (int x = 0; x < 9; x++)
		{
			if (currentBoard[x][yMove] == value)
			{
				return false;
			}
		}

		return true;
	}

	private boolean validateX(int xMove, int value) {
		for (int y = 0; y < 9; y++)
		{
			if (currentBoard[xMove][y] == value)
			{
				return false;
			}
		}

		return true;
	}

	public void print() {

		for (int x = 0; x < 9; x++)
		{
			if (x % 3 == 0)
			{
				System.out.println("------------");
			}

			for (int y = 0; y < 9; y++)
			{
				if (y % 3 == 0)
				{
					System.out.print("|");
				}
				System.out.print(currentBoard[x][y]);
			}

			System.out.println();
		}

	}
}
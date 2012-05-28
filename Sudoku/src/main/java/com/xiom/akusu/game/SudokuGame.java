package com.xiom.akusu.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.xiom.akusu.game.utils.GameboardGenerator;
import com.xiom.akusu.options.utils.SudokuOptions;

public class SudokuGame {

	private SudokuOptions options;

	public SudokuGame(SudokuOptions options) {
		this.options = options;
	}

	public void run() {
		// Generate a new board
		Gameboard board = GameboardGenerator.generate(options.getDifficulty());
		board.print();

		// Check for win
		while (!board.isCompleted()) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// Prompt player for move
			int xMove = requestInfo(br, "Please enter the x coordinate: ");
			int yMove = requestInfo(br, "Please enter the y coordinate: ");
			int value = requestInfo(br, "Please enter the new value: ");

			// Make move
			if (!board.move(xMove - 1, yMove - 1, value)) {
				System.out.println("I'm sorry, but that space has already been taken or that move is not valid.");
			}

			// Output board
			board.print();
		}

	}

	private int requestInfo(BufferedReader br, String message) {

		int info = 0;
		while (info == 0) {
			try {
				System.out.print(message);
				info = Integer.valueOf(br.readLine());
			} catch (Exception e) {
				System.out.println("I'm sorry, but that's invalid.");
			}

			if (info > 9 || info < 1) {
				System.out.println("I'm sorry, but that's invalid.");
				info = 0;
			}
		}

		return info;
	}
}

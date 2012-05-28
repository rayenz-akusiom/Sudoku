package com.xiom.akusu.main;

import com.xiom.akusu.game.SudokuGame;
import com.xiom.akusu.options.utils.SudokuOptions;

public class Sudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Parse passed arguments
		SudokuOptions options = new SudokuOptions(args);

		SudokuGame game = new SudokuGame(options);

		game.run();
	}

}

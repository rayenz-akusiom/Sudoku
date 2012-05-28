package com.xiom.akusu.game.utils;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.xiom.akusu.SudokuCommonTest;
import com.xiom.akusu.game.Gameboard;

public class GameBoardGeneratorTest extends SudokuCommonTest {

	@Test
	public void DefaultBoardGenerateTest() {
		Gameboard board = GameboardGenerator.generate(DEFAULT_DIFFICULTY);

		assertNotNull(board.getSolution());
		assertNotNull(board.getCurrentBoard());
	}

}
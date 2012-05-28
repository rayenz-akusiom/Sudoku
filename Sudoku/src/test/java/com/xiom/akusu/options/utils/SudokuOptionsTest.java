package com.xiom.akusu.options.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.xiom.akusu.SudokuCommonTest;
import com.xiom.akusu.options.utils.SudokuOptions;

public class SudokuOptionsTest extends SudokuCommonTest {

	@Test
	public void setOptionsTest() {

		SudokuOptions options = new SudokuOptions(DIFFICULTY_TEST_OPTIONS);

		assertEquals(TEST_DIFFICULTY, options.getDifficulty());
	}

	@Test
	public void testDefaultDifficulty() {
		SudokuOptions options = new SudokuOptions(TEST_OPTIONS);

		assertEquals(DEFAULT_DIFFICULTY, options.getDifficulty());
	}

}

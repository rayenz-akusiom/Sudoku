package com.xiom.akusu;

import com.xiom.akusu.enums.DifficultyLevel;
import com.xiom.akusu.options.utils.OptionsProcessor;

public class SudokuCommonTest {

	protected static final String SPEC3 = "spec3";
	protected static final String ARG3 = "arg3";
	protected static final String ARG2 = "arg2";
	protected static final String SPEC2 = "spec2";
	protected static final String SPEC1 = "spec1";
	protected static final String ARG1 = "arg1";

	protected static final String[] ARG1_RESULTS = { SPEC1, SPEC2 };
	protected static final String[] ARG2_RESULTS = null;
	protected static final String[] ARG3_RESULTS = { SPEC3 };

	protected static OptionsProcessor optionsProcessor = new OptionsProcessor();

	protected static String[] TEST_OPTIONS = { "-" + ARG1, SPEC1, SPEC2, "-" + ARG2, "-" + ARG3, SPEC3 };

	protected static String[] DIFFICULTY_TEST_OPTIONS = { "-diff", "expert" };
	protected static DifficultyLevel TEST_DIFFICULTY = DifficultyLevel.EXPERT;
	protected static DifficultyLevel DEFAULT_DIFFICULTY = DifficultyLevel.EASY;

}

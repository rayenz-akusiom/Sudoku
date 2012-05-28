package com.xiom.akusu.options.utils;

import com.xiom.akusu.enums.DifficultyLevel;
import com.xiom.akusu.enums.GameOption;

public class SudokuOptions extends Options {

	private static final DifficultyLevel DEFAULT_DIFFICULTY = DifficultyLevel.EASY;
	private DifficultyLevel difficulty = DEFAULT_DIFFICULTY;

	public SudokuOptions(String[] args) {
		super(args);

		setDifficultyFromOptions();
	}

	private void setDifficultyFromOptions() {
		String[] difficultyOpt = getGameOptionValue(GameOption.DIFFICULTY);
		if (difficultyOpt != null && difficultyOpt.length > 0) {
			difficulty = DifficultyLevel.getEnum(difficultyOpt[0]);
		} else {
			difficulty = DEFAULT_DIFFICULTY;
		}
	}

	public void setDifficulty(DifficultyLevel difficulty) {
		this.difficulty = difficulty;
	}

	public DifficultyLevel getDifficulty() {
		return difficulty;
	}

}

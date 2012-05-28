package com.xiom.akusu.enums;

public enum DifficultyLevel {
	EASY(35, "Easy"), INTERMEDIATE(30, "Intermediate"), EXPERT(28, "Expert"), EVIL(26, "Evil");

	private int spotsToFill = 0;
	private String name = "";

	DifficultyLevel(int spotsToFill, String name) {
		this.spotsToFill = spotsToFill;
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public int getSpotsToFill() {
		return this.spotsToFill;
	}

	public static DifficultyLevel getEnum(String searchValue) {
		for (DifficultyLevel c : DifficultyLevel.values()) {
			if (c.toString().equalsIgnoreCase(searchValue)) {
				return c;
			}
		}

		return EASY;
	}
}

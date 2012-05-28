package com.xiom.akusu.enums;

public enum GameOption {
	DIFFICULTY("Difficulty", "Diff");

	private String fullName = "";
	private String shortName = "";

	GameOption(String fullName, String shortName) {
		this.fullName = fullName;
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public boolean equals(String toCheck) {
		return fullName.equalsIgnoreCase(toCheck) || shortName.equalsIgnoreCase(toCheck);
	}
}

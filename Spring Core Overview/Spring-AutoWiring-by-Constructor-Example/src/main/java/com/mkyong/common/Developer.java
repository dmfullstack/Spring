package com.mkyong.common;

public class Developer {
	private Language language1;

	public Developer(Language language) {
		this.language1 = language;
	}

	@Override
	public String toString() {
		return "Developer [language=" + language1 + "]";
	}

}
package org.jturn.model;


abstract class BaseContestant extends EntityObject implements ContestantInterface {

	private final int seed;
	private final String firstName; 
	private final String surName;

	public BaseContestant(int seed, String firstName, String surName) {
		this.seed = seed;
		this.firstName = firstName;
		this.surName = surName;
	}

	@Override
	public int getSeed() {
		return seed;
	}

	@Override
	public String getName() {
		return firstName + " " + surName;
	}

	@Override
	public String getShortName() {
		return surName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseContestant [seed=").append(seed)
		.append(", firstName=").append(firstName).append(", surName=")
		.append(surName).append("]");
		return builder.toString();
	}
}
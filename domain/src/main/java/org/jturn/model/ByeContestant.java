package org.jturn.model;

public class ByeContestant extends BaseContestant {

	public ByeContestant(int seed) {
		super(seed, "", "");
	}

	@Override
	public boolean isBye() {
		return true;
	}
}
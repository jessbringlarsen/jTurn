package org.jturn.tournament.elimination;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Iterator;

class EliminationRankIterator implements Iterator<Integer> {

	private int indexCounter;
	private final int[] rankArray;

	public EliminationRankIterator(int[] rankArray) {
		checkArgument(rankArray != null, "array cannot be null");
		checkArgument(rankArray.length > 0, "array size must be greater than zero");
		
		this.indexCounter = 0;
		this.rankArray = rankArray;
	}

	@Override
	public boolean hasNext() {
		return (rankArray != null) &&
			(rankArray.length != indexCounter);
	}

	@Override
	public Integer next() {
		return rankArray[indexCounter++];
	}

	@Override
	public void remove() {
	}
}

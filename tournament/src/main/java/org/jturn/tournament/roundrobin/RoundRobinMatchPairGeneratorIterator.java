package org.jturn.tournament.roundrobin;

import java.util.ArrayList;
import java.util.Iterator;

import org.jturn.util.Pair;

/**
 * Responsible for for constructing pairs of matches to be played in a roundrobin tournament.
 * <p> 
 * 
 * @author jbl
 *
 */
public class RoundRobinMatchPairGeneratorIterator implements Iterator<ArrayList<Pair<Integer, Integer>>> {

	RoundRobinMatchPairGenerator roundRobinMatchPairGenerator; 
	            
	public RoundRobinMatchPairGeneratorIterator(int numberOfPlayers) {
		roundRobinMatchPairGenerator = new RoundRobinMatchPairGenerator(numberOfPlayers);
	}
	
	@Override
	public boolean hasNext() {
		return roundRobinMatchPairGenerator.hasMoreRounds();
	}

	@Override
	public ArrayList<Pair<Integer, Integer>> next() {
		return roundRobinMatchPairGenerator.nextRound();
	}
	
	@Override
	public void remove() {
		throw new RuntimeException("Not implemented!");
	}
}

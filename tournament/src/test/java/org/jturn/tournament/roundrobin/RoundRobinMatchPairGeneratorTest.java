package org.jturn.tournament.roundrobin;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;

import org.jturn.util.Pair;
import org.junit.Assert;
import org.junit.Test;

public class RoundRobinMatchPairGeneratorTest {

	private int[] expectedTwo = {1,2};
	private int[] expectedFour = {1,4,2,3, 1,3,4,2, 1,2,3,4};
	private int[] expectedSix= {1,6,2,5,3,4, 1,5,6,4,2,3, 1,4,5,3,6,2, 1,3,4,2,5,6, 1,2,3,6,4,5};
	
	@Test
	public void testTwo() {
		testGenerator(2, expectedTwo);
	}
	
	@Test
	public void testFour() {
		testGenerator(4, expectedFour);
	}
	
	@Test
	public void testSix() {
		testGenerator(6, expectedSix);
	}
	
	private void testGenerator(int numberOfPlayers, int[] expectedArray) {
		RoundRobinMatchPairGeneratorIterator generator = new RoundRobinMatchPairGeneratorIterator(numberOfPlayers);
		
		int expectedIndex=-1; 
		while(generator.hasNext()) {
			ArrayList<Pair<Integer, Integer>> round = generator.next();
			for(int i=0; i<numberOfPlayers/2; i++) {
				Assert.assertThat(round.get(i).getFirst(), is(expectedArray[++expectedIndex]));
				Assert.assertThat(round.get(i).getSecond(), is(expectedArray[++expectedIndex]));
			}
		}
	}
}
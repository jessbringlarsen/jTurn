package org.jturn.tournament.elimination;


import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.jturn.model.CategoryParticipant;
import org.jturn.tournament.elimination.SingleEliminationHelper;
import org.jturn.tournament.seed.Elimination;
import org.junit.Test;

/**
 * Test the SingleEliminationHelper class that calculate number of bye contestants in a
 * tournament.
 *
 * @author jbl
 *
 */
public class SingleEliminationHelperTest extends SingleEliminationBaseTest {

	@Test
	public void doDrawTest() {
		// Only unseeded participants
		Map<Integer, CategoryParticipant> res =
			SingleEliminationHelper.getParticipants(new HashMap<Integer, CategoryParticipant>(),
					getUnseededParticipants());

		Elimination seeding = new Elimination(0);
		int noOfBye = seeding.noOfBye(getUnseededParticipants().size());
		Assert.assertEquals(getUnseededParticipants().size() + noOfBye, res.size());
	}

	@Test
	public void doDrawTest2() {
		// Only Seeded participants
		Map<Integer, CategoryParticipant> res =
			SingleEliminationHelper.getParticipants(getSeededParticipants(), Collections.EMPTY_LIST);

		Elimination seeding = new Elimination(0);
		int noOfBye = seeding.noOfBye(getUnseededParticipants().size());
		Assert.assertEquals(getUnseededParticipants().size() + noOfBye, res.size());
	}

	@Test
	public void doDrawTest3() {
		final int noOfSeededParticipants = 3;
		// Mixed seeded and unseeded participants
		Map<Integer, CategoryParticipant> seeded = new HashMap<Integer, CategoryParticipant>();
		List<CategoryParticipant> unseeded = getUnseededParticipants();

		// Create three seeded participants
		Iterator<CategoryParticipant> iterator = unseeded.iterator();
		for(int i=1; i<=noOfSeededParticipants; i++) {
			CategoryParticipant participant = iterator.next();
			participant.setSeed(i);
			seeded.put(i, participant);
			iterator.remove();
		}

		Map<Integer, CategoryParticipant> res = SingleEliminationHelper.getParticipants(seeded, unseeded);

		// compare number of participants to result
		Elimination seeding = new Elimination(0);
		int noOfBye = seeding.noOfBye(seeded.size() + unseeded.size());
		Assert.assertEquals(seeded.size() + unseeded.size() + noOfBye, res.size());

		// Check that the first three map entries are seeded
		for(int i=1; i<=noOfSeededParticipants; i++) {
			Assert.assertEquals(i, res.get(i).getSeed());
		}
	}
}

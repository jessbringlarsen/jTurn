package org.jturn.tournament.elimination;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jturn.data.dao.mockup.MockupDaoFactory;
import org.jturn.model.CategoryParticipant;
import org.junit.BeforeClass;

import com.db4o.collections.ArrayMap4;

public class SingleEliminationBaseTest {
	private static List<CategoryParticipant> participants;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		participants =  new MockupDaoFactory().getCategoryParticipantDao().getAll();
	}

	protected Map<Integer, CategoryParticipant> getSeededParticipants() {
		Map<Integer, CategoryParticipant> seedMap = new ArrayMap4<Integer, CategoryParticipant>();
		int i = 1;
		for (Iterator<CategoryParticipant> iterator = participants.iterator(); iterator.hasNext();) {
			CategoryParticipant participant = iterator.next();
			participant.setSeed(i);
			seedMap.put(i, participant);
			i++;
		}
		return seedMap;
	}

	protected List<CategoryParticipant> getUnseededParticipants() {
		return participants;
	}
}

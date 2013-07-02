package org.jturn.tournament.elimination;

import junit.framework.Assert;

import org.jturn.data.dao.mockup.MockupDaoFactory;
import org.jturn.model.Category;
import org.junit.Before;
import org.junit.Test;

/**
 * Test that the correct MatchGroups have been constructed.
 *
 * @author jbl
 *
 */
public class SingleEliminationTest extends SingleEliminationBaseTest {

	private Category category;
	private SingleEliminationFacade singleElimination;

	@Before
	public void setUp() {
		category = new MockupDaoFactory().getCategoryDao().getById("1", false);
		singleElimination = new SingleEliminationFacade(new MockupDaoFactory());
	}

	@Test
	public void doDrawTest() {
		category.setSeededParticipants(getSeededParticipants());
		Category result = singleElimination.doDraw(category);

		Assert.assertNotNull(result);
		Assert.assertEquals(16, result.getMatchGroups().size());
	}

	@Test
	public void doNullDrawTest() {
		Category result = singleElimination.doDraw(category);

		Assert.assertNotNull(result);
	}
}
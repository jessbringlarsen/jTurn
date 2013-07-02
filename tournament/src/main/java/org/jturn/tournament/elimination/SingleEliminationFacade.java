package org.jturn.tournament.elimination;

import java.util.Iterator;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

/**
 * Represents a single elimination tournament.
 *
 * @author jbl
 *
 */
public class SingleEliminationFacade {

	/**
	 *
	 * @param daoFactory the daoFactory to be used. Could be mockup.
	 */
	public SingleEliminationFacade(IDaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	private static Tournament tournament = null;

	@Override
	public Tournament getCurrentTournament() {

		// TODO
		if(tournament == null) {
			tournament = new Tournament("ØM");
		}
		return tournament;
	}

	@Override
	public Category doDraw(Category category) {

		// Build up the single elimination three
		Map<Integer, CategoryParticipant> participants =
			SingleEliminationHelper.getParticipants(category.getSeededParticipants(), category.getUnseededParticipants());
		Elimination seeding = new Elimination();
		Iterator<Integer> seedingsIterator = seeding.standardSeeding(participants.size());

		// Create MatchGroup objects and place em in a map
		while (seedingsIterator.hasNext()) {

			CategoryParticipant home = participants.get(seedingsIterator.next());
			CategoryParticipant away = participants.get(seedingsIterator.next());

			int matchNo = getCurrentTournament().getNextMatchNo();
			Match match = new Match(matchNo, home, away);

			MatchGroup matchGroup = new MatchGroup(category, match);
			category.addMatchGroup(matchGroup);
		}
		return daoFactory.getCategoryDao().save(category);
	}

	/**
	 * <p>
	 * Get matches not played for the specified category
	 * </p>
	 */
	@Override
	public List<MatchGroup> getUnPlayedMatchs(Category category) {
		return daoFactory.getMatchGroupDao().getUnPlayedMatchGroups(category);
	}

	/**
	 * <p>
	 * Get finished matches for the specified category
	 * </p>
	 */
	@Override
	public List<MatchGroup> getPlayedMatchs(Category category) {
		return daoFactory.getMatchGroupDao().getPlayedMatchGroups();
	}

	@Override
	public List<ContestantInterface> getResults(Category category) {
		// TODO Auto-generated method stub
		return null;
	}
}
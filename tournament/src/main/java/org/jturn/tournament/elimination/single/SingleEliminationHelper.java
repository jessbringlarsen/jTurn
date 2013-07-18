package org.jturn.tournament.elimination.single;


class SingleEliminationHelper {

//	/**
//	 * 
//	 * This methods takes seeded and unseeded participants and constructs a Map
//	 * ordered by seed including bye contestants.
//	 *
//	 * @param seededParticipants -
//	 *            mandatory and must be <> null. The seedings must obey: n=1, n++, n++...nm
//	 * @param unseededParticipants -
//	 *            mandatory and must be <> null
//	 * @return
//	 */
//	static Map<Integer, CategoryParticipant> getParticipants(Map<Integer, CategoryParticipant> seededParticipants,
//			Collection<CategoryParticipant> unseededParticipants) {
//
//		Map<Integer, CategoryParticipant> ret = new HashMap<Integer, CategoryParticipant>();
//
//		// Get number of bye contestants
//		Elimination seeding = new Elimination();
//		int noOfParticipants = seededParticipants.size()
//				+ unseededParticipants.size();
//
//		if (noOfParticipants != 0) {
//			int noOfBye = seeding.noOfBye(noOfParticipants);
//
//			// Fill a collection with Bye objects
//			List<ContestantInterface> byes = new ArrayList<ContestantInterface>(
//					noOfBye);
//			ContestantInterface[] byeArray = new ByeContestant[noOfBye];
//			Arrays.fill(byeArray, new ByeContestant());
//			byes.addAll(Arrays.asList(byeArray));
//
//			Iterator<CategoryParticipant> unseededIterator = unseededParticipants.iterator();
//			Iterator<ContestantInterface> byeIterator = byes.iterator();
//
//			/**
//			 * Construct a map of participants in the following order:
//			 * - sedded go first
//			 * - non seeded
//			 * - bye
//			 */
//			int i = 1;
//			if(!seededParticipants.isEmpty()) {
//				ret.putAll(seededParticipants);
//				i = ret.size();
//				i++;
//			}
//
//			for (; unseededIterator.hasNext(); i++) {
//				ret.put(i, unseededIterator.next());
//			}
//
//			for (; byeIterator.hasNext(); i++) {
//				ret.put(i, new CategoryParticipant(byeIterator.next()));
//			}
//		}
//		return ret;
//	}
}

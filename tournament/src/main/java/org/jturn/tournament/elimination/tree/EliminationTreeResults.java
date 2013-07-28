package org.jturn.tournament.elimination.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jturn.model.Match;
import org.jturn.model.MatchResultInterface;

public class EliminationTreeResults {

	private Map<Integer, Match> matches = new HashMap<>();

	void addMatch(Integer matchNo, Match match) {
		matches.put(matchNo, match);
	}
	
	void addResult(Integer matchNo, List<MatchResultInterface> result) {
		if(matches.containsKey(matchNo)) {
			// report
		} else {
			Match match = matches.get(matchNo);
			match.addResult(result);
		}
	}
}
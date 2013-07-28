package org.jturn.config;

import org.jturn.model.Match;
import org.jturn.model.MatchResultInterface;

/**
 * Responsible for upholding the rules in a points and games based scoring game. 
 *
 */
public class PointsAndGames {

	private final int pointsNeededToWin;
	private final int gamesNeededToWin;
	private final int minPointDifferenceToWin;

	public PointsAndGames(int pointsNeededToWin, int gamesNeededToWin, int minPointDifferenceToWin) {
		this.pointsNeededToWin = pointsNeededToWin;
		this.gamesNeededToWin = gamesNeededToWin;
		this.minPointDifferenceToWin = minPointDifferenceToWin;
	}
	
	public void getWinner(Match match) {
		
	}
	
	public void isDone(Match match) {
		
	}
	
	public boolean isValidResult(MatchResultInterface result) {
		hasBothLost(result);
		isScoreDifferenceCorrect(result);
		isScoreDifferenceCorrectTieBreak(result);
		return false;
	}
	
	private boolean hasBothLost(MatchResultInterface result) {
		if(result.getResultA() < pointsNeededToWin && result.getResultB() < pointsNeededToWin) {
			return true;
		}
		return false;
	}
	
	private boolean isScoreDifferenceCorrect(MatchResultInterface result) {
		if(result.getResultA() == pointsNeededToWin || result.getResultB() == pointsNeededToWin) {
			
			int maxLooserPoints = pointsNeededToWin - minPointDifferenceToWin;
			if(result.getResultA() == pointsNeededToWin) {
				return maxLooserPoints >= result.getResultB();
			}
			
			if(result.getResultB() == pointsNeededToWin) {
				return maxLooserPoints >= result.getResultA();
			}
		}
		return true;
	}
	
	private boolean isScoreDifferenceCorrectTieBreak(MatchResultInterface result) {
		if(result.getResultA() > pointsNeededToWin && result.getResultB() > pointsNeededToWin) {
			
			if(result.getResultA() > result.getResultB()) {
				int difference = result.getResultA() - result.getResultB();
				return difference != minPointDifferenceToWin;
			}
			
			if(result.getResultB() > result.getResultA()) {
				int difference = result.getResultB() - result.getResultA();
				return difference != minPointDifferenceToWin;
			}
		}
		return true;
	}
	
	public boolean isDraw() {
		return false;
	}
}

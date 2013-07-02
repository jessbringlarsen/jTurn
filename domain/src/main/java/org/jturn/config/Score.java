package org.jturn.config;

public class Score {

	private final int pointsNeededToWin;
	private final int gamesNeeddedToWin;
	private final boolean canEndDraw;
	
	public Score(int pointsNeededToWin, int gamesNeeddedToWin, boolean canEndDraw) {
		this.pointsNeededToWin = pointsNeededToWin;
		this.gamesNeeddedToWin = gamesNeeddedToWin;
		this.canEndDraw = canEndDraw;
	}

	public int getPointsNeededToWin() {
		return pointsNeededToWin;
	}

	public int getGamesNeeddedToWin() {
		return gamesNeeddedToWin;
	}

	public boolean isCanEndAsTie() {
		return canEndDraw;
	}
}

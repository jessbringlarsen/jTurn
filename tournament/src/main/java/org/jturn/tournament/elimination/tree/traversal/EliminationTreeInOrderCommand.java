package org.jturn.tournament.elimination.tree.traversal;

import org.jturn.tournament.elimination.tree.EliminationTreeMatchNode;

public interface EliminationTreeInOrderCommand {
	boolean doCommand(EliminationTreeMatchNode node);
}

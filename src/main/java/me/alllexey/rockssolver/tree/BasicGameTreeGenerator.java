package me.alllexey.rockssolver.tree;

import jdk.dynalink.linker.LinkerServices;
import me.alllexey.rockssolver.GameRules;
import me.alllexey.rockssolver.moves.Move;

import java.util.List;

public class BasicGameTreeGenerator implements GameTreeGenerator {

    private GameRules rules;

    // height of the tree
    private int maxDepth;

    public BasicGameTreeGenerator(GameRules rules, int maxDepth) {
        this.rules = rules;
        this.maxDepth = maxDepth;
    }

    @Override
    public GameTreeNode generateGameTree(int[] piles) {
        GameTreeNode head = new GameTreeNode();
        deeper(0, head, piles);
        return head;
    }

    public void deeper(int currentDepth, GameTreeNode node, int[] piles) {
        // first, check current game state
        RelativeWinner winner = check(piles);
        if (winner != null) {
            node.setEnded(true);
            AbsoluteWinner absoluteWinner = (currentDepth + (winner == RelativeWinner.LAST ? 1 : 0)) % 2 == 0
                    ? AbsoluteWinner.FIRST
                    : AbsoluteWinner.SECOND;
            node.setWinner(absoluteWinner);
            return; // game has ended
        }

        if (currentDepth >= maxDepth) return; // dont go deeper

        List<Move> moves = rules.getMoveGenerator().getPossibleMoves(piles);
        for (Move move : moves) {
            GameTreeNode child = new GameTreeNode();
            deeper(currentDepth + 1, child, move.make(piles));
            node.getNodes().add(child);
        }
    }

    public RelativeWinner check(int[] piles) {
        boolean isEnded = rules.getGameEndChecker().isEnded(piles);
        return isEnded
                ? (rules.getWinnerDeterminer().wasLastMoveWinning(piles) ? RelativeWinner.LAST : RelativeWinner.OTHER)
                : null;
    }


    public GameRules getRules() {
        return rules;
    }

    public void setRules(GameRules rules) {
        this.rules = rules;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
}

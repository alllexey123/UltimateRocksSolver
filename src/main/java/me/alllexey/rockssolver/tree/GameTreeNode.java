package me.alllexey.rockssolver.tree;

import java.util.List;
import java.util.stream.Stream;

public class GameTreeNode {

    private boolean isEnded;

    private AbsoluteWinner winner; // null if not ended

    private List<GameTreeNode> nodes;

    public GameTreeNode(boolean isEnded, AbsoluteWinner winner, List<GameTreeNode> nodes) {
        this.isEnded = isEnded;
        this.winner = winner;
        this.nodes = nodes;
    }

    public Stream<GameTreeNode> nodes() {
        return nodes.stream();
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void setEnded(boolean ended) {
        isEnded = ended;
    }

    public AbsoluteWinner getWinner() {
        return winner;
    }

    public void setWinner(AbsoluteWinner winner) {
        this.winner = winner;
    }

    public List<GameTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<GameTreeNode> nodes) {
        this.nodes = nodes;
    }
}

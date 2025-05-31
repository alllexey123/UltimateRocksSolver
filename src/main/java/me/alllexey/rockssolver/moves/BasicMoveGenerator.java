package me.alllexey.rockssolver.moves;

import java.util.List;

public class BasicMoveGenerator implements MoveGenerator {

    private List<Move> moves;

    public BasicMoveGenerator(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public List<Move> getPossibleMoves(int[] piles) {
        return moves.stream().filter(m -> m.isPossible(piles)).toList();
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}

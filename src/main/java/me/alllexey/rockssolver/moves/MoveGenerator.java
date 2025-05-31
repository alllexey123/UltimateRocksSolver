package me.alllexey.rockssolver.moves;

import java.util.List;

public interface MoveGenerator {

    List<Move> getPossibleMoves(int[] piles);

}

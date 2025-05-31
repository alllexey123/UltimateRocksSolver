package me.alllexey.rockssolver.moves;

public interface Move {

    int[] make(int[] piles);

    boolean isPossible(int[] piles);
}

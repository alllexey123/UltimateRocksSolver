package me.alllexey.rockssolver.moves;

public interface Move {

    void make(int[] piles);

    boolean isPossible(int[] piles);
}

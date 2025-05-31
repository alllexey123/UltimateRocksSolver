package me.alllexey.rockssolver.end;

public interface GameEndChecker {

    boolean isEnded(int[] piles);

    default int sum(int[] piles) {
        int r = 0;
        for (int i = 0; i < piles.length; i++) {
            r += piles[i];
        }
        return r;
    }
}

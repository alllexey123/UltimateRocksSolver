package me.alllexey.rockssolver.end;

public class SumUpperBoundChecker implements GameEndChecker {

    // at this sum (and greater) the game will end
    private int targetSum;

    public SumUpperBoundChecker(int targetSum) {
        this.targetSum = targetSum;
    }

    @Override
    public boolean isEnded(int[] piles) {
        return sum(piles) >= targetSum;
    }
}

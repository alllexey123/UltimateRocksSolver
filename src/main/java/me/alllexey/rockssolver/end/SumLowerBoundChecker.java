package me.alllexey.rockssolver.end;

public class SumLowerBoundChecker implements GameEndChecker {

    // at this sum (and lower) the game will end
    private int targetSum;

    public SumLowerBoundChecker(int targetSum) {
        this.targetSum = targetSum;
    }

    @Override
    public boolean isEnded(int[] piles) {
        return sum(piles) <= targetSum;
    }
}

package me.alllexey.rockssolver.end;

public class SumExactChecker implements GameEndChecker {

    // at this sum (exactly) the game will end
    private int targetSum;

    public SumExactChecker(int targetSum) {
        this.targetSum = targetSum;
    }

    @Override
    public boolean isEnded(int[] piles) {
        return sum(piles) == targetSum;
    }
}

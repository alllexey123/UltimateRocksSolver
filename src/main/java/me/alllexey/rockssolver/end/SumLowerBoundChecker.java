package me.alllexey.rockssolver.end;

import me.alllexey.rockssolver.util.Utils;

public class SumLowerBoundChecker implements GameEndChecker {

    // at this sum (and lower) the game will end
    private int targetSum;

    public SumLowerBoundChecker(int targetSum) {
        this.targetSum = targetSum;
    }

    @Override
    public boolean isEnded(int[] piles) {
        return Utils.sum(piles) <= targetSum;
    }

    public int getTargetSum() {
        return targetSum;
    }

    public void setTargetSum(int targetSum) {
        this.targetSum = targetSum;
    }
}

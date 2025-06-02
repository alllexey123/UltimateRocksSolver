package me.alllexey.rockssolver.moves;

import java.util.List;
import java.util.stream.IntStream;

public class SubMove implements Move {

    public static List<SubMove> any(int val, int sz) {
        return IntStream.range(0, sz).mapToObj(i -> specific(val, i)).toList();
    }

    public static SubMove specific(int val, int idx) {
        return new SubMove(val, idx);
    }

    private final int val;
    private final int pileIdx;

    public SubMove(int val, int pileIdx) {
        this.val = val;
        this.pileIdx = pileIdx;
    }

    @Override
    public void make(int[] piles) {
        piles[pileIdx] -= val;
    }

    @Override
    public boolean isPossible(int[] piles) {
        return piles[pileIdx] >= val;
    }

    public int getPileIdx() {
        return pileIdx;
    }

    public int getVal() {
        return val;
    }
}

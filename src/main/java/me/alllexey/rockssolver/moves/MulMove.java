package me.alllexey.rockssolver.moves;

import java.util.List;
import java.util.stream.IntStream;

public class MulMove implements Move {

    public static List<MulMove> any(int val, int sz) {
        return IntStream.range(0, sz).mapToObj(i -> specific(val, i)).toList();
    }

    public static MulMove specific(int val, int idx) {
        return new MulMove(val, idx);
    }


    private final int val;
    private final int pileIdx;

    public MulMove(int val, int pileIdx) {
        this.val = val;
        this.pileIdx = pileIdx;
    }

    @Override
    public void make(int[] piles) {
        piles[pileIdx] *= val;
    }

    @Override
    public boolean isPossible(int[] piles) {
        return true;
    }

    public int getPileIdx() {
        return pileIdx;
    }

    public int getVal() {
        return val;
    }
}

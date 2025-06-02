package me.alllexey.rockssolver.moves;

import java.util.List;
import java.util.stream.IntStream;

public class DivMove implements Move {

    public static List<DivMove> any(int val, int sz) {
        return IntStream.range(0, sz).mapToObj(i -> specific(val, i)).toList();
    }

    public static List<DivMove> anyDivisible(int val, int sz) {
        return IntStream.range(0, sz).mapToObj(i -> specificDivisible(val, i)).toList();
    }

    public static DivMove specific(int val, int idx) {
        return new DivMove(val, false, idx);
    }

    public static DivMove specificDivisible(int val, int idx) {
        return new DivMove(val, true, idx);
    }

    private final int val;
    private final boolean ifDivisible;
    private final int pileIdx;

    public DivMove(int val, boolean onlyIfDivisible, int pileIdx) {
        this.val = val;
        this.ifDivisible = onlyIfDivisible;
        this.pileIdx = pileIdx;
    }

    @Override
    public void make(int[] piles) {
        piles[pileIdx] /= val;
    }

    @Override
    public boolean isPossible(int[] piles) {
        return !ifDivisible || piles[pileIdx] % val == 0;
    }

    public int getPileIdx() {
        return pileIdx;
    }

    public int getVal() {
        return val;
    }
}

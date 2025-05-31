package me.alllexey.rockssolver.piles;

import java.util.HashMap;
import java.util.Map;

public class BasicPileGenerator implements PileGenerator {

    private int minS;
    private int maxS;
    private int[] otherPiles;

    public BasicPileGenerator(int minS, int maxS, int[] otherPiles) {
        this.minS = minS;
        this.maxS = maxS;
        this.otherPiles = otherPiles;
    }

    @Override
    public Map<Integer, int[]> getInitialPileCombinations() {
        HashMap<Integer, int[]> combs = new HashMap<>();
        for (int S = minS; S <= maxS; S++) {
            int sz = otherPiles.length + 1;
            int[] piles = new int[sz];
            System.arraycopy(otherPiles, 0, piles, 0, sz - 1);
            piles[sz - 1] = S;
            combs.put(S, piles);
        }
        return combs;
    }

    public int getMinS() {
        return minS;
    }

    public void setMinS(int minS) {
        this.minS = minS;
    }

    public int getMaxS() {
        return maxS;
    }

    public void setMaxS(int maxS) {
        this.maxS = maxS;
    }

    public int[] getOtherPiles() {
        return otherPiles;
    }

    public void setOtherPiles(int[] otherPiles) {
        this.otherPiles = otherPiles;
    }
}

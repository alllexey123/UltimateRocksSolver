package me.alllexey.rockssolver.piles;

import java.util.List;
import java.util.Map;

public interface PileGenerator {

    // [S -> piles]
    Map<Integer, int[]> getInitialPileCombinations();
}

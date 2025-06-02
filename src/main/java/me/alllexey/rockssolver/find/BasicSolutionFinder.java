package me.alllexey.rockssolver.find;

import me.alllexey.rockssolver.piles.PileGenerator;
import me.alllexey.rockssolver.tree.GameTreeGenerator;
import me.alllexey.rockssolver.tree.GameTreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicSolutionFinder implements SolutionFinder {

    public static final HashMap<String, TreeVerifier> gameTreeVerifiers = new HashMap<>();

    static {
        N19Verifiers.registerVerifiers();
        N20Verifiers.registerVerifiers();
        N21Verifiers.registerVerifiers();
    }

    public static void register(TreeVerifier treeVerifier) {
        gameTreeVerifiers.put(treeVerifier.getType(), treeVerifier);
    }

    private final PileGenerator pileGenerator;

    private final GameTreeGenerator treeGenerator;

    private final TreeVerifier treeVerifier;

    public BasicSolutionFinder(PileGenerator pileGenerator, GameTreeGenerator treeGenerator, String questionType) {
        this.pileGenerator = pileGenerator;
        this.treeGenerator = treeGenerator;
        treeVerifier = gameTreeVerifiers.get(questionType);
        if (treeVerifier == null) {
            throw new UnknownQuestionTypeException(questionType);
        }
    }

    public BasicSolutionFinder(PileGenerator pileGenerator, GameTreeGenerator treeGenerator, TreeVerifier treeVerifier) {
        this.pileGenerator = pileGenerator;
        this.treeGenerator = treeGenerator;
        this.treeVerifier = treeVerifier;
    }

    @Override
    public List<Integer> findSolutions() {
        Map<Integer, int[]> combs = pileGenerator.getInitialPileCombinations();
        return combs.entrySet()
                .stream()
                .filter(e -> checkPiles(e.getValue()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public boolean checkPiles(int[] piles) {
        GameTreeNode head = treeGenerator.generateGameTree(piles);
        return treeVerifier.verify(head);
    }
}

package me.alllexey.rockssolver.find;

import me.alllexey.rockssolver.tree.AbsoluteWinner;

public class N20Verifiers {

    public static void registerVerifiers() {
        BasicSolutionFinder.register(n20_1);

    }

    public static TreeVerifier n20_1 = new TreeVerifier(
            "n20_1",
            """
                    у Пети есть выигрышная стратегия, причём одновременно выполняются два условия:
                    − Петя не может выиграть за один ход;
                    − Петя может выиграть своим вторым ходом независимо от того, как будет ходить Ваня.
                    """,
            head ->
                    head.nodes().noneMatch(
                            a -> a.getWinner() == AbsoluteWinner.FIRST
                    ) && head.nodes().anyMatch(
                            a -> a.nodes().allMatch(
                                    b -> b.nodes().anyMatch(
                                            c -> c.getWinner() == AbsoluteWinner.FIRST
                                    )
                            )
                    )
    );

}

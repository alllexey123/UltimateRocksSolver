package me.alllexey.rockssolver.find;

import me.alllexey.rockssolver.tree.AbsoluteWinner;

public class N21Verifiers {


    public static void registerVerifiers() {
        BasicSolutionFinder.register(n21_1);

    }

    public static TreeVerifier n21_1 = new TreeVerifier(
            "n21_1",
            """
                    одновременно выполняются два условия:
                    – у Вани есть выигрышная стратегия, позволяющая ему выиграть первым или вторым ходом при любой игре Пети;
                    – у Вани нет стратегии, которая позволит ему гарантированно выиграть первым ходом.
                    """,
            head ->
                    !head.nodes().allMatch(
                            a -> a.nodes().anyMatch(
                                    b -> b.getWinner() == AbsoluteWinner.SECOND
                            )
                    ) && head.nodes().allMatch(
                            a -> a.nodes().anyMatch(
                                    b -> b.getWinner() == AbsoluteWinner.SECOND
                            )
                                    || a.nodes().anyMatch(
                                    b -> b.nodes().allMatch(
                                            c -> c.nodes().anyMatch(
                                                    d -> d.getWinner() == AbsoluteWinner.SECOND
                                            )
                                    )
                            )
                    )
    );
}

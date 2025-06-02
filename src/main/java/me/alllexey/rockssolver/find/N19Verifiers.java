package me.alllexey.rockssolver.find;

import me.alllexey.rockssolver.tree.AbsoluteWinner;

public class N19Verifiers {

    public static void registerVerifiers() {
        BasicSolutionFinder.register(n19_1);
        BasicSolutionFinder.register(n19_2);
    }

    public static TreeVerifier n19_1 = new TreeVerifier(
            "n19_1",
            "Петя не может выиграть за один ход, но при любом ходе Пети Ваня может выиграть своим первым ходом.",
            head -> head.nodes().allMatch(
                    a -> a.nodes().anyMatch(
                            b -> b.getWinner() == AbsoluteWinner.SECOND
                    )
            )
    );

    public static TreeVerifier n19_2 = new TreeVerifier(
            "n19_2",
            "Ваня выиграл своим первым ходом после неудачного первого хода Пети.",
            head -> head.nodes().anyMatch(
                    a -> a.nodes().anyMatch(
                            b -> b.getWinner() == AbsoluteWinner.SECOND
                    )
            )
    );
}

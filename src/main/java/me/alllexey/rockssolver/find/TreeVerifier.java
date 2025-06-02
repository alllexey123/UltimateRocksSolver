package me.alllexey.rockssolver.find;

import me.alllexey.rockssolver.tree.GameTreeNode;

import java.util.function.Predicate;

public class TreeVerifier {

    private final String type;

    private final String desc;

    private final Predicate<GameTreeNode> verifier;

    public TreeVerifier(String type, String desc, Predicate<GameTreeNode> verifier) {
        this.type = type;
        this.desc = desc;
        this.verifier = verifier;
    }

    public boolean verify(GameTreeNode head) {
        return verifier.test(head);
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public Predicate<GameTreeNode> getVerifier() {
        return verifier;
    }
}

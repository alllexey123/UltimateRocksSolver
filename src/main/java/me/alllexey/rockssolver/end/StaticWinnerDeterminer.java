package me.alllexey.rockssolver.end;

public class StaticWinnerDeterminer implements WinnerDeterminer {

    private boolean value;

    public StaticWinnerDeterminer(boolean value) {
        this.value = value;
    }

    @Override
    public boolean wasLastMoveWinning(int[] piles) {
        return value;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

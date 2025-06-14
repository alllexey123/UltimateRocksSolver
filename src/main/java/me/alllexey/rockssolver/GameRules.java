package me.alllexey.rockssolver;

import me.alllexey.rockssolver.end.GameEndChecker;
import me.alllexey.rockssolver.end.WinnerDeterminer;
import me.alllexey.rockssolver.moves.MoveGenerator;
import me.alllexey.rockssolver.piles.PileGenerator;

public class GameRules {

    private MoveGenerator moveGenerator;

    private PileGenerator pileGenerator;

    private GameEndChecker gameEndChecker;

    private WinnerDeterminer winnerDeterminer;


    public GameRules(MoveGenerator moveGenerator, PileGenerator pileGenerator, GameEndChecker gameEndChecker, WinnerDeterminer winnerDeterminer) {
        this.moveGenerator = moveGenerator;
        this.pileGenerator = pileGenerator;
        this.gameEndChecker = gameEndChecker;
        this.winnerDeterminer = winnerDeterminer;
    }

    public GameRules() {
    }

    public MoveGenerator getMoveGenerator() {
        return moveGenerator;
    }

    public void setMoveGenerator(MoveGenerator moveGenerator) {
        this.moveGenerator = moveGenerator;
    }

    public PileGenerator getPileGenerator() {
        return pileGenerator;
    }

    public void setPileGenerator(PileGenerator pileGenerator) {
        this.pileGenerator = pileGenerator;
    }

    public GameEndChecker getGameEndChecker() {
        return gameEndChecker;
    }

    public void setGameEndChecker(GameEndChecker gameEndChecker) {
        this.gameEndChecker = gameEndChecker;
    }

    public WinnerDeterminer getWinnerDeterminer() {
        return winnerDeterminer;
    }

    public void setWinnerDeterminer(WinnerDeterminer winnerDeterminer) {
        this.winnerDeterminer = winnerDeterminer;
    }
}

package me.alllexey.rockssolver.find;

import me.alllexey.rockssolver.GameRules;

import java.util.List;

public interface SolutionFinder {

    List<Integer> findAllSValues(GameRules gameRules);
}

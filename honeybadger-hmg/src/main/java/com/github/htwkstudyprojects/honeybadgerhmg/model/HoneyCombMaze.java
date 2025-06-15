package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoneyCombMaze {

    private List<HoneyComb> honeyCombs;
    private final int wantedCombCount;

    private HoneyCombMaze(int wantedCombCount) {
        this.wantedCombCount = wantedCombCount;
        this.honeyCombs = new ArrayList<>();
    }


    static public HoneyCombMaze generateHoneyCombMaze(int wantedCombCount){
        // TODO: implement real generation
        return new HoneyCombMaze(wantedCombCount);
    }

    public boolean addHoneyComb(HoneyComb honeyComb) {
        if (honeyCombs.size() >= wantedCombCount) {
            return false;
        }
        if (honeyCombs.contains(honeyComb)) {
            return false;
        }
        return honeyCombs.add(honeyComb);
    }

    public Optional<HoneyComb> getHoneyCombById(int id) {
        for (HoneyComb honeyComb : honeyCombs) {
            if (honeyComb != null && honeyComb.getId() == id) {
                return Optional.of(honeyComb);
            }
        }
        return Optional.empty();
    }


    public int size() {
        return honeyCombs.size();
    }

    public List<HoneyComb> getHoneyCombs() {
        return honeyCombs;
    }
}

package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoneyCombMaze {

    private List<HoneyComb> honeyCombs;
    private final int rang;
    private final int[] calculateElementsforEachRow;

    private HoneyCombMaze(int rang) {
        this.honeyCombs = new ArrayList<>();
        this.rang = rang;
        this.calculateElementsforEachRow = calculateElementsforEachRow();
    }


    static public HoneyCombMaze generateHoneyCombMaze(int rang, int edgeLength){
        
        // TODO: implement real generation
        HoneyCombMaze honeyCombMaze = new HoneyCombMaze(rang);
        honeyCombMaze.generateHoneyCombStructure(edgeLength,honeyCombMaze.calculateElementsforEachRow);
        return honeyCombMaze;
    }

    private int[] calculateElementsforEachRow(){
        int[] rows = new int[this.rang*2+1];

        int j = this.rang + 1;
        for(int i = 0; i < rows.length; i++){
            rows[i] = j;
            if(i > rows.length/2) j--;
            else j++;
        }

        return rows;
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

    

    @Override
    public String toString() {
        return "HoneyCombMaze [honeyCombs=" + honeyCombs + "]";
    }

    private void generateHoneyCombStructure(int edgeLength, int[]rows){
        Point currentCenterPoint = new Point(0, 0);
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < rows[i]; j++){
                HoneyComb currentHoneyComb = new HoneyComb();
                currentHoneyComb.calculateDefiningEgdes(currentCenterPoint, edgeLength);
                double newX = currentCenterPoint.getX() + 
                    2 * (currentHoneyComb.getDefiningEdges()[Directions.RIGHT.getIndex()].getStartPoint().getX() - currentCenterPoint.getX());
                currentCenterPoint.setX(newX);

                this.honeyCombs.add(currentHoneyComb);
            }
        }
    }
}

package com.github.htwkstudyprojects.honeybadgerhmg.model;

public class HoneyComb {
    private static int idCounter = 0;

    private final int id;
    private Edge[] definingEdges;
    private HoneyComb[] neighborHoneyCombs;

    public HoneyComb(){
        this.id = idCounter;
        idCounter++;

        definingEdges = new Edge[6];
        neighborHoneyCombs = new HoneyComb[6];
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HoneyComb other = (HoneyComb) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public int getId() {
        return id;
    }

    public Edge[] getDefiningEdges() {
        return definingEdges;
    }

    public void setDefiningEdges(Edge[] definingEdges) {
        this.definingEdges = definingEdges;
    }

    public HoneyComb[] getNeighborHoneyCombs() {
        return neighborHoneyCombs;
    }

    public void setNeighborHoneyCombs(HoneyComb[] neighborHoneyCombs) {
        this.neighborHoneyCombs = neighborHoneyCombs;
    }

}

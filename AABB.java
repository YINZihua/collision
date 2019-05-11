package com.pact45.escapeart.openGL.collision;

public class AABB {
    private Vector max;
    private Vector min;

    private Figure3D figure;

    public AABB(Vector minPoint, Vector maxPoint){
        min = minPoint;
        max = maxPoint;
    }

    public AABB(Figure3D figure){
        this.figure = figure;
        Vector[] extremums = figure.getExtremums();
        min = new Vector(extremums[0].x, extremums[2].y, extremums[4].z);
        max = new Vector(extremums[1].x, extremums[3].y, extremums[5].z);
    }
    public boolean includes(Vector point){
        return ((max.superiorTo(point))&&(min.inferiorTo(point)))?true:false;
    }
    public boolean includes(AABB aabbBox){
        boolean included = true;
        if(!this.includes(aabbBox.getMinPoint())) included = false;
        if(!this.includes(aabbBox.getMaxPoint())) included = false;
        return included;
    }
//    public boolean includes(OBB obbBox){
//        boolean included = true;
//        for(Vector sommet: obbBox.getSommets()){
//            if(!this.includes(sommet)){
//                included = false;
//            }
//        }
//        return included;
//    }
    public boolean includes(Figure3D figure){
        return includes(figure.getAabbBox());
    }
    public Vector getMinPoint(){
        return min;
    }
    public void setMinPoint(Vector min){
        this.min = min;
    }
    public Vector getMaxPoint(){
        return max;
    }
    public void setMaxPoint(Vector max){
        this.max = max;
    }
}
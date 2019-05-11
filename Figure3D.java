package com.pact45.escapeart.openGL.collision;

import com.pact45.escapeart.drawTriangulation.Triangle;

import java.util.ArrayList;

public class Figure3D {
    private ArrayList<Triangle> figureTriangle;
    private ArrayList<Vector> sommets = new ArrayList<Vector>();
    private Vector[] extremums;

    private AABB aabbBox;

    public Figure3D(ArrayList<Triangle> figureTriangle){
        this.figureTriangle = figureTriangle;
        this.figureToSommets();
        this.calcExtremums();
        this.figureToAABB();

    }

    private void figureToSommets(){
        for(Triangle triangle : figureTriangle){
            if(!sommets.contains(triangle.getA()))sommets.add(triangle.getA());
            if(!sommets.contains(triangle.getB()))sommets.add(triangle.getB());
            if(!sommets.contains(triangle.getC()))sommets.add(triangle.getC());
        }
    }

    public ArrayList<Vector> getSommets(){
        return sommets;
    }

//    private void figureToOBB(){
//        obbBox = new OBB(this);
//    }

    private void figureToAABB(){
        aabbBox = new AABB(this);
    }

//    public OBB getObbBox(){
//        return this.obbBox;
//    }

    public AABB getAabbBox(){
        return aabbBox;
    }


    private void calcExtremums(){
        Vector maximumX = new Vector(0.0f,0.0f,0.0f);
        Vector minimumX = new Vector(0.0f,0.0f,0.0f);
        Vector maximumY = new Vector(0.0f,0.0f,0.0f);
        Vector minimumY = new Vector(0.0f,0.0f,0.0f);
        Vector maximumZ = new Vector(0.0f,0.0f,0.0f);
        Vector minimumZ = new Vector(0.0f,0.0f,0.0f);
        float maxX = Float.NEGATIVE_INFINITY;
        float minX = Float.POSITIVE_INFINITY;
        float maxY = Float.NEGATIVE_INFINITY;
        float minY = Float.POSITIVE_INFINITY;
        float maxZ = Float.NEGATIVE_INFINITY;
        float minZ = Float.POSITIVE_INFINITY;
        for(Vector sommet : sommets){
            if(sommet.x > maxX)maximumX = sommet;
            if(sommet.x < minX)minimumX = sommet;
            if(sommet.y > maxY)maximumY = sommet;
            if(sommet.y < minY)minimumY = sommet;
            if(sommet.z > maxZ)maximumZ = sommet;
            if(sommet.z < minZ)minimumZ = sommet;
        }
        extremums = new Vector[]{minimumX, maximumX, minimumY, maximumY, minimumZ, maximumZ};
    }

    public Vector[] getExtremums(){
        return extremums;
    }

}
package com.pact45.escapeart.openGL.collision;


import java.util.ArrayList;

public class OBB { //Oriented Bounding Box
    private Vector mCenter;
    private Vector mAxes[] = new Vector[3];

    private Figure3D figure;

    public OBB(Figure3D figure){
        this.figure = figure;
        calcCenter();
        calcAxes();
    }

    public Vector[] getSommets(){
        Vector[] mySommets = new Vector[8];

        mySommets[0]=mCenter.add(mAxes[0].add(mAxes[1].add(mAxes[2])));
        mySommets[1]=mCenter.add(mAxes[0].add(mAxes[1].dif(mAxes[2])));
        mySommets[2]=mCenter.add(mAxes[0].dif(mAxes[1].add(mAxes[2])));
        mySommets[3]=mCenter.add(mAxes[0].dif(mAxes[1].dif(mAxes[2])));
        mySommets[4]=mCenter.dif(mAxes[0].add(mAxes[1].add(mAxes[2])));
        mySommets[5]=mCenter.dif(mAxes[0].add(mAxes[1].dif(mAxes[2])));
        mySommets[6]=mCenter.dif(mAxes[0].dif(mAxes[1].add(mAxes[2])));
        mySommets[7]=mCenter.dif(mAxes[0].dif(mAxes[1].dif(mAxes[2])));

        return mySommets;
    }


    public void calcCenter(){
        ArrayList<Vector> sommets = figure.getSommets();
        float x=0.0f, y=0.0f, z=0.0f;
        for(Vector vector : sommets){
            x += vector.x;
            y += vector.y;
            z += vector.z;
        }
        x = x/(3*sommets.size());
        y = y/(3*sommets.size());
        z = z/(3*sommets.size());
        mCenter = new Vector(x,y,z);
    }

    public void calcAxes(){
        ArrayList<Vector> sommets = figure.getSommets();

        float moyenX = (float)sommets.stream().parallel().mapToDouble(d->d.x).sum()/sommets.size();
        float moyenY = (float)sommets.stream().parallel().mapToDouble(d->d.y).sum()/sommets.size();
        float moyenZ = (float)sommets.stream().parallel().mapToDouble(d->d.z).sum()/sommets.size();

        float covarianceXX = (float)sommets.stream().parallel().mapToDouble(d->d.x*d.x).sum()/sommets.size() - moyenX*moyenX;
        float covarianceXY = (float)sommets.stream().parallel().mapToDouble(d->d.x*d.y).sum()/sommets.size() - moyenX*moyenX;
        float covarianceXZ = (float)sommets.stream().parallel().mapToDouble(d->d.x*d.z).sum()/sommets.size() - moyenX*moyenX;
        float covarianceYY = (float)sommets.stream().parallel().mapToDouble(d->d.y*d.y).sum()/sommets.size() - moyenX*moyenX;
        float covarianceYZ = (float)sommets.stream().parallel().mapToDouble(d->d.y*d.z).sum()/sommets.size() - moyenX*moyenX;
        float covarianceZZ = (float)sommets.stream().parallel().mapToDouble(d->d.z*d.z).sum()/sommets.size() - moyenX*moyenX;



        mAxes[0] = new Vector(0.0f,0.0f,0.0f);
        mAxes[1] = new Vector(0.0f,0.0f,0.0f);
        mAxes[2] = new Vector(0.0f,0.0f,0.0f);
    }

    public boolean hasCollisionWith(Figure3D figure){
        return false;
    }
}
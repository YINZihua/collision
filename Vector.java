package com.pact45.escapeart.openGL.collision;

import com.pact45.escapeart.drawTriangulation.*;

public class Vector {
        protected float x;
        protected float y;
        protected float z;

        public Vector(float x, float y, float z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public float getX(){
            return this.x;
        }
        public float getY(){
            return this.y;
        }
        public float getZ(){
            return this.z;
        }

        public float normSquare(){
            return x*x+y*y+z*z;
        }

        public boolean inferiorTo(Vector point){
            return ((this.getX()<=point.getX())&&(this.getY()<=point.getY())&&(this.getZ()<=point.getZ()))?true:false;
        }
        public boolean superiorTo(Vector point){
            return ((this.getX()>=point.getX())&&(this.getY()>=point.getY())&&(this.getZ()>=point.getZ()))?true:false;
        }
        public Vector add(Vector vec){
            return new Vector(this.getX()+vec.getX(), this.getY()+vec.getY(), this.getZ()+vec.getZ());
        }
    //difference : this - vec
        public Vector dif(Vector vec){
            return new Vector(this.getX()-vec.getX(), this.getY()-vec.getY(), this.getZ()-vec.getZ());
        }
    //multiplication
        public Vector mul(float mul){
            return new Vector(this.getX()*mul, this.getY()*mul, this.getZ()*mul);
        }
    //produit scalaire
        public float produitScalaireWith(Vector vec){
            return this.x*vec.x + this.y*vec.y + this.z*vec.z;
        }
    //moyen entre ce point et le point pris en argument
        public Vector moy(Vector vec){
            return new Vector((this.getX()+vec.getX())/2, (this.getY()+vec.getY())/2, (this.getZ()+vec.getZ())/2);
        }
    //decalage
        public Vector decalX(float xDecal){
            return new Vector(this.getX()+xDecal, this.getY(), this.getZ());
        }
        public Vector decalY(float yDecal){
            return new Vector(this.getX(), this.getY()+yDecal, this.getZ());
        }
        public Vector decalZ(float zDecal){
            return new Vector(this.getX(), this.getY(), this.getZ()+zDecal);
        }
    //projection component
        public Vector componentOnto(Vector vec){
            return vec.mul(this.produitScalaireWith(vec)/(vec.normSquare()));
        }

}

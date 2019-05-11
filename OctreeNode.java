package com.pact45.escapeart.openGL.collision;

public class OctreeNode extends AABB{
    //variable :
        //information du noeud
            private static int counter = 0;
            private int index;
            private int depth;
        //boite AABB correspondant
            // private AABB aabbBox;
        //noeud pere
            private OctreeNode father;

        //noeud enfants
            private OctreeNode topLeftFront = null;
            private OctreeNode topLeftBack = null;
            private OctreeNode topRightFront = null;
            private OctreeNode topRightBack = null;
            private OctreeNode bottomLeftFront = null;
            private OctreeNode bottomLeftBack = null;
            private OctreeNode bottomRightFront = null;
            private OctreeNode bottomRightBack = null;
        //noeud geometrique de l'objet dans cette boite AABB
        //si ce noeud n'est pas un noeud feuille, ce tableau est vide
            private Object mesh[];

    //methodes :
//        public OctreeNode(Vector minPoint, Vector maxPoint, OctreeNode father){
//            super(minPoint, maxPoint);
//            this.father = father;
//            this.index = counter++;
//        }

        public OctreeNode(Vector minPoint, Vector maxPoint, OctreeNode father, int depth){
            super(minPoint, maxPoint);
            this.father = father;
            this.index = counter++;
            this.depth = depth;
        }

        //l'indice
            public int getIndex(){
                return this.index;
            }

        //la profondeur 
            public void setDepth(int depth){
                this.depth = depth;
            }
            public int getDepth(){
                return this.depth;
            }

        //etablissement de la boite AABB correspondant
            public void setAABB(Vector minPoint, Vector maxPoint){
                setMinPoint(minPoint);
                setMaxPoint(maxPoint);
            }
        //retourner les coordonnees extremes de la boite AABB
            public Vector getMinPoint(){
                return getMinPoint();
            }
            public Vector getMaxPoint(){
                return getMaxPoint();
            }
            public Vector getCenter(){
                return getMaxPoint().moy(getMinPoint());
            }
        //retourner la moitie des tailles
            public float getHalfSizeX(){
                return (getMaxPoint().getX() - getMinPoint().getX())/2.0f;
            }
            public float getHalfSizeY(){
                return (getMaxPoint().getY() - getMinPoint().getY())/2.0f;
            }
            public float getHalfSizeZ(){
                return (getMaxPoint().getZ() - getMinPoint().getZ())/2.0f;
            }

            public float getSizeX(){
                return (getMaxPoint().getX() - getMinPoint().getX());
            }
            public float getSizeY(){
                return (getMaxPoint().getY() - getMinPoint().getY());
            }
            public float getSizeZ(){
                return (getMaxPoint().getZ() - getMinPoint().getZ());
            }

        //retourner le noeud pere
            public OctreeNode getFather(){
                return father;
            }
        //retounrer un des noeuds enfants
            public OctreeNode getTopLeftFront(){
                return topLeftFront;
            }
            public OctreeNode getTopLeftBack(){
                return topLeftBack;
            }
            public OctreeNode getTopRightFront(){
                return topRightFront;
            }
            public OctreeNode getTopRightBack(){
                return topRightBack;
            }
            public OctreeNode getBottomLeftFront(){
                return bottomLeftFront;
            }
            public OctreeNode getBottomLeftBack(){
                return bottomLeftBack;
            }
            public OctreeNode getBottomRightFront(){
                return bottomRightFront;
            }
            public OctreeNode getBottomRightBack(){
                return bottomRightBack;
            }

            public void createChild(){
                Vector center = this.getCenter();
                
                float xHalf = getHalfSizeX();
                float yHalf = getHalfSizeY();
                float zHalf = getHalfSizeZ();

                topLeftFront        = new OctreeNode(getMinPoint().add(new Vector(0.0f, 0.0f, zHalf)), center.add(new Vector(0.0f, 0.0f, zHalf)),this,      this.depth+1);
                topLeftBack         = new OctreeNode(getMinPoint().add(new Vector(0.0f, yHalf,zHalf)), center.add(new Vector(0.0f, yHalf,zHalf)),this,            this.depth+1);
                topRightFront       = new OctreeNode(getMinPoint().add(new Vector(xHalf,0.0f, zHalf)), center.add(new Vector(xHalf,0.0f, zHalf)),this,             this.depth+1);
                topRightBack        = new OctreeNode(getMinPoint().add(new Vector(xHalf,yHalf,zHalf)), center.add(new Vector(xHalf,yHalf,zHalf)),this,                  this.depth+1);
                bottomLeftFront     = new OctreeNode(getMinPoint().add(new Vector(0.0f, 0.0f, 0.0f)),  center.add(new Vector(0.0f, 0.0f, 0.0f)), this,  this.depth+1);
                bottomLeftBack      = new OctreeNode(getMinPoint().add(new Vector(0.0f, yHalf,0.0f)),  center.add(new Vector(0.0f, yHalf,0.0f)), this,      this.depth+1);
                bottomRightFront    = new OctreeNode(getMinPoint().add(new Vector(xHalf,0.0f, 0.0f)),  center.add(new Vector(xHalf,0.0f, 0.0f)), this,      this.depth+1);
                bottomRightBack     = new OctreeNode(getMinPoint().add(new Vector(xHalf,yHalf,0.0f)),  center.add(new Vector(xHalf,yHalf,0.0f)), this,              this.depth+1);
            }
}
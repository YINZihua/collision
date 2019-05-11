package com.pact45.escapeart.openGL.collision;

public class Octree {
    private OctreeNode root;
    private int maxDepth = 20;

    public Octree(Vector minPoint, Vector maxPoint){
         root = new OctreeNode(minPoint, maxPoint,null, 0);
    }

    //creer l'octree
        //creer cette octree a partir de la racine
            public void createOctree(){
                this.createOctree(this.root, maxDepth);
            }
        //creer les sous-octree
            public void createOctree(OctreeNode root, int maxdepth){
                //limiter la profondeur de l'octree
                    maxdepth--;
                //si on n'aboutit pas a la profondeur plus grande autorisee
                    if(maxdepth>=0){
                        root.createChild();
                        createOctree(root.getTopLeftFront(),maxdepth);
                        createOctree(root.getTopLeftBack(),maxdepth);
                        createOctree(root.getTopRightFront(),maxdepth);
                        createOctree(root.getTopRightBack(),maxdepth);
                        createOctree(root.getBottomLeftFront(),maxdepth);
                        createOctree(root.getBottomLeftBack(),maxdepth);
                        createOctree(root.getBottomRightFront(),maxdepth);
                        createOctree(root.getBottomRightBack(),maxdepth);
                    }
            }



    public int cal(int num){
        int result = 1;
        if(num == 1)
            result = -1;
        else {
            for(int i = 1; i< num; i++){
                result = 2*result;
            }
        }
        return result;
    }

    public OctreeNode root(){
        return root;
    }


//    private int maxdepth = 0;
//    private int times = 0;
//    private static float xMin = 0, xMax = 0, yMin = 0, yMax = 0, zMin = 0, zMax = 0;
//    private int tmaxdepth = 0;

    //ecart maximum entre le point et le centre du noeud
    private float txm = 1, tym = 1, tzm = 1;

    public OctreeNode find(OctreeNode p, Vector point){
        if (!root.includes(point)){//x > xMax || x<xMin || y>yMax || y<yMin || z>zMax || z < zMin){
            //ce node est en dehors de l'octree
            return null;
        }

        OctreeNode node = null;

        if ((p.getSizeX()<2.0f)&&(p.getSizeY()<2.0f)&&(p.getSizeZ()<2.0f)&&
                (new OctreeNode(p.getMinPoint().decalX( txm).decalY( tym).decalZ( tzm),
                                p.getMaxPoint().decalX(-txm).decalY(-tym).decalZ(-tzm),
                            null,-1)).includes(point)){
            node = p;//find it !
        }
        else if (p.getBottomLeftBack().includes(point)){
            node = find(p.getBottomLeftBack(),point);
        }
        else if (p.getTopLeftBack().includes(point)){
            node = find(p.getTopLeftBack(), point);
        }
        else if (p.getBottomRightBack().includes(point)){
            node = find(p.getBottomRightBack(), point);
        }
        else if (p.getTopRightBack().includes(point)){
            node = find(p.getTopRightBack(), point);
        }
        else if (p.getBottomLeftFront().includes(point)){
            node = find(p.getBottomLeftFront(), point);
        }
        else if (p.getTopLeftFront().includes(point)){
            node = find(p.getTopLeftFront(), point);
        }
        else if (p.getBottomRightFront().includes(point)){
            node = find(p.getBottomRightFront(), point);
        }
        else if (p.getTopRightFront().includes(point)){
            node = find(p.getTopRightFront(), point);
        }
        else if (!p.includes(point)){
            node = find(p.getFather(), point);
        }
        return node;
    }

    public OctreeNode find(OctreeNode p, OBB obbBox){
        if (!root.includes(obbBox)){//x > xMax || x<xMin || y>yMax || y<yMin || z>zMax || z < zMin){
            //ce node est en dehors de l'octree
            return null;
        }

        OctreeNode node = null;

        if ((p.getSizeX()<2.0f)&&(p.getSizeY()<2.0f)&&(p.getSizeZ()<2.0f)&&
                (new OctreeNode(p.getMinPoint().decalX( txm).decalY( tym).decalZ( tzm),
                        p.getMaxPoint().decalX(-txm).decalY(-tym).decalZ(-tzm),
                        null,-1)).includes(obbBox)){
            node = p;//find it !
        }
        else if (p.getBottomLeftBack().includes(obbBox)){
            node = find(p.getBottomLeftBack(),obbBox);
        }
        else if (p.getTopLeftBack().includes(obbBox)){
            node = find(p.getTopLeftBack(), obbBox);
        }
        else if (p.getBottomRightBack().includes(obbBox)){
            node = find(p.getBottomRightBack(), obbBox);
        }
        else if (p.getTopRightBack().includes(obbBox)){
            node = find(p.getTopRightBack(), obbBox);
        }
        else if (p.getBottomLeftFront().includes(obbBox)){
            node = find(p.getBottomLeftFront(), obbBox);
        }
        else if (p.getTopLeftFront().includes(obbBox)){
            node = find(p.getTopLeftFront(), obbBox);
        }
        else if (p.getBottomRightFront().includes(obbBox)){
            node = find(p.getBottomRightFront(), obbBox);
        }
        else if (p.getTopRightFront().includes(obbBox)){
            node = find(p.getTopRightFront(), obbBox);
        }
        else if (!p.includes(obbBox)){
            node = find(p.getFather(), obbBox);
        }
        return node;
    }
}

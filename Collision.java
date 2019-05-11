package com.pact45.escapeart.openGL.collision;


public class Collision {
    private Octree octree;
    private OBB obb;

    private boolean hasCollisionIndicator = false;
    private Vector spotCollision;

    private OctreeNode collisionOctreeNode;

    private int maxDepth = 20;

    public Collision(){
        collisionOctreeNode = octree.root();
    }

    public void collisionTest(Figure3D figure){
        collisionOctreeNode = octree.find(collisionOctreeNode, figure);
        if(collisionOctreeNode != null){
            hasCollisionIndicator = object.hasCollisionWith(figure3D in collisionOctreeNode);
        }
    }

    public boolean hasCollision(){
        return this.hasCollisionIndicator;
    }
}
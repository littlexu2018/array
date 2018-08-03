package com.imooc.bstree;

public class BSTTest {


    public static void main(String[] args) {
        BinarySearchTree<Integer> bsTree =new BinarySearchTree();
        int[] nums ={1,2,3,4,5,6,7,8};
        for(int i:nums){
            bsTree.insert(i);
        }
        bsTree.preOrder();
    }
}

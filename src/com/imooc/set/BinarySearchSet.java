package com.imooc.set;

import com.imooc.bstree.BinarySearchTree;

/**
 * 二分搜索树集合
 * @param <E>
 */
public class BinarySearchSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bsTree;

    public BinarySearchSet(){
        bsTree = new BinarySearchTree<E>();
    }

    @Override
    public void add(E e) {
        bsTree.insert(e);
    }

    @Override
    public void remove(E e) {
        bsTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bsTree.contains(e);
    }

    @Override
    public int getSize() {
        return bsTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bsTree.isEmpty();
    }
}

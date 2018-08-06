package com.imooc.map;

import com.imooc.array.MyArray;

/**
 * @Author peterlee
 * @Date 2018/8/3 下午8:58
 * @Describtion : 数据类型（堆）
 */
public class MaxHeap<E extends Comparable<E>> {

    private MyArray<E> data;

    public MaxHeap(){
        data =new MyArray<E>();
    }
    public MaxHeap(int capacity){
        data =new MyArray<E>(capacity);
    }

    /**
     * 返回堆中元素的数量
     * @return
     */
    public int getSize(){
        return data.getSize();
    }

    /**
     * 判断非空
     * @return
     */
    public boolean isEmpty(){
       return data.isEmpty();
    }

    /**
     * 返回完全基于二叉树数组中，一个索引所在的元素 的父亲元素的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if (index == 0 )
            throw new IllegalArgumentException(" index Illegal ");
        return (index-1)/2;
    }

    /**
     * 返回 一个完全二叉树，基于index的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index*2+1;
    }

    /**
     * 返回 一个完全二叉树，基于index又孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index*2+2;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    /**
     * 返回最大的元素
     * @return
     */
    public E findMax(){
        if (data.getSize()==0)
            throw new IllegalArgumentException(" can not findMax");
        return data.get(0);
    }

    /**
     *  元素上浮
     * @param k
     */
    private void siftUp(int k) {
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            //更换两个索引对应的元素
            data.swap(k,parent(k));
            k =parent(k);
        }
    }

}

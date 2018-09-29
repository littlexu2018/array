package com.imooc.queue;

import java.util.Arrays;

/**
 * @Author peterLee
 * @Date 2018/9/29 上午11:03
 * @Describtion : 优先队列的实现，基于二叉堆，
 *              最大堆的堆顶是整个堆中的最大元素（✅）
 *              最小堆的堆顶是整个堆中的最小元素
 */
public class PriorityQueue {

    private int[] array;
    private int size;

    public PriorityQueue(){
        //队列初始长度32
        array =new int[32];
    }

    /**
     * 入队
     * @param key 入队元素
     */
    private void enQueue(int key){
        //队列长度超出范围，扩容
        if (size>=array.length){
            resize();
        }
        array[size++] =key;
        //元素上浮
        upAdjust();
    }

    /**
     * 出队
     * @return
     */
    private int deQueue(){
        if (size<=0){
            throw new IllegalArgumentException(" the queue is empty");
        }
        //获取堆顶元素
        int head =array[0];
        array[0] =array[--size];
        downAdjust();
        return head;
    }

    /**
     * 元素上浮调整
     */
    private void upAdjust() {
        int childIndex =size -1;
        int parentIndex =childIndex/2;
        //temp 保留插入的叶子节点值，用于最后的赋值
        int temp =array[childIndex];
        while (childIndex>0 && temp>array[parentIndex]){
            //无需真正交换，单向赋值即可
            array[childIndex] =array[parentIndex];
            childIndex =parentIndex;
            parentIndex =parentIndex/2;
        }
        array[childIndex] =temp;
    }

    /**
     * 元素下浮调整
     */
    private void downAdjust(){
        //temp保存父节点值，用于最后的赋值
        int parentIndex =0;
        int temp =array[parentIndex];
        int childIndex =1;
        while (childIndex < size){
            //如果有右孩子，且右孩子大于左孩子，则定位到右孩子
            if (childIndex+1<size && array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值，直接跳出
            if(temp >= array[childIndex]){
                break;
            }
            //无需真正交换，单向赋值即可
            array[parentIndex] =array[childIndex];
            parentIndex =childIndex;
            childIndex = 2 * childIndex+1;
        }
        array[parentIndex] = temp;
    }

    /**
     *  容量调整
     */
    private void resize() {
        //队列容量翻倍
        int newSize =this.size * 2;
        this.array = Arrays.copyOf(this.array,newSize);
    }


    public static void main(String[] args) {
        PriorityQueue priorityQueue =new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(4);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(8);
        priorityQueue.enQueue(1);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(0);
        System.out.printf("出队元素：%d%n", priorityQueue.deQueue());
        System.out.printf("出队元素：%d%n", priorityQueue.deQueue());

    }

}

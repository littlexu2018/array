package com.imooc.queue;

/**
 * 队列：interface
 */
public interface Queue<E> {

    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();

}

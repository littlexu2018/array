package com.imooc.stack;

/**
 * 栈：interface
 * @param <E>
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop(); //从栈中取出最后一个值。并返回
    E peek();

}

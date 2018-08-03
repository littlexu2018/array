package com.imooc.stack;

import com.imooc.linkedList.MyLinkedList;

public class LinkedListStack<E> implements Stack<E>  {

    private MyLinkedList linkedList;

    public LinkedListStack(){
        linkedList = new MyLinkedList();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return (E) linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return (E) linkedList.getFrist();
    }

    @Override
    public String toString() {
        StringBuilder res =new StringBuilder();
        res.append("Stack:top ");
        res.append(linkedList);
        return res.toString();
    }
}

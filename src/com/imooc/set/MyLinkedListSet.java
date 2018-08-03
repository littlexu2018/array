package com.imooc.set;

import com.imooc.linkedList.MyLinkedList;

public class MyLinkedListSet<E> implements Set<E> {

    private MyLinkedList<E> list;

    public MyLinkedListSet(){
        list = new MyLinkedList<E>();
    }

    @Override
    public void add(E e) {
        if (!list.constants(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.constants(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

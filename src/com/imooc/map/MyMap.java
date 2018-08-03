package com.imooc.map;

/**
 * 自定义映射数据结构
 */
public interface MyMap<K,V> {

    void add(K key,V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key,V value);

    int getSize();

    boolean isEmpty();

}

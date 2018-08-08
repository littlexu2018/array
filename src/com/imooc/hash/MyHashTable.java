package com.imooc.hash;


import java.security.Key;
import java.util.TreeMap;

/**
 * @Author peterlee
 * @Date 2018/8/8 下午2:01
 * @Describtion : HashTable
 * {@link TreeMap} 红黑树
 */
public class MyHashTable<K,V> {
    private static final int upperTol =10;
    private static final int lowerTol =2;
    private static final int initCapacity =7;

    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    public MyHashTable(int M){
        this.M=M;
        size=0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] =new TreeMap<>();
        }
    }

    public MyHashTable(){
        this(initCapacity);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff)& M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        TreeMap<K,V> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            size++;
            if (size >= upperTol*M){
                resize(2*M);
            }
        }
        map.put(key,value);
    }

    public V remove(K key){
        TreeMap<K,V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)){
            ret = map.remove(key);
            size --;
            if (size < lowerTol*M && (M/2) >= initCapacity){
                resize(M/2);
            }
        }
        return ret;
    }

    private void resize(int newM){
        TreeMap<K,V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i <newM ; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM =M;
        this.M = newM;
        for (int i =0;i<oldM;i++){
            TreeMap<K,V> map =hashtable[i];
            for (K k:map.keySet()) {
                newHashTable[hash(k)].put(k,map.get(k));
            }
        }
        this.hashtable = newHashTable;
    }

    public void set(K key,V value){
        TreeMap<K,V> map = hashtable[hash(key)];
        if (!map.containsKey(key)){
           throw new IllegalArgumentException(key +" is not exist ");
        }
        map.put(key,value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

}

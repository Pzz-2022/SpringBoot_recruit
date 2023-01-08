package com.pzz.utils;

public class Entry<K, V> {
    public Entry<K, V> pre;
    public Entry<K, V> next;
    public K key;
    public V value;

    public Entry() {
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}

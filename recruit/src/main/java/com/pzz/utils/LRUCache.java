package com.pzz.utils;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    public Entry<K, V> head, tail;
    public int capacity;
    public int size;
    Map<K, Entry<K, V>> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        initLinkedList();
        size = 0;
    }

    public void put(K key, V value) {
        Entry<K, V> node = cache.get(key);

        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        // node不存在的情况 则将最后一个节点删除
        if (size == capacity) {
            Entry<K, V> lastNode = tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }

        // 加入头节点
        Entry<K, V> newNode = new Entry<>();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        cache.put(key, newNode);
        size++;
    }

    public V get(K key) {
        Entry<K, V> node = cache.get(key);

        if (node == null) {
            return null;
        }
        // 存在就移动节点
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Entry<K, V> node) {
        deleteNode(node);
        addNode(node);
    }

    private void addNode(Entry<K, V> node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void deleteNode(Entry<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void initLinkedList() {
        head = new Entry<K, V>();
        tail = new Entry<K, V>();

        head.next = tail;
        tail.pre = head;

        cache = new HashMap<>(capacity + 2);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "head=" + head +
                ", tail=" + tail +
                ", capacity=" + capacity +
                ", size=" + size +
                ", cache=" + cache +
                '}';
    }
}


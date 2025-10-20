package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int size = 0;
    private final int capacity = 10;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setKeys(Object[] keys) {
        this.keys = keys;
    }

    public Object[] getKeys() {
        return keys;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    public Object[] getValues() {
        return values;
    }

    public int getCapacity() {
        return capacity;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                return i;
            } else if (key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            values[index] = value;
        } else if (size == capacity) {
            throw new RuntimeException("Storage is full");
        } else {
            keys[size] = key;
            values[size] = value;
            size = size + 1;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        if (index == -1) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }
}

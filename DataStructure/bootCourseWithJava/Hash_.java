package DataStructure.bootCourseWithJava;

import java.security.Key;
import java.util.LinkedList;

public class Hash_<K, V> {
    class HashElement<K, V> implements Comparable<HashElement<K, V>> {
        K key;
        V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>) this.key).compareTo(o.key));
        }
    }

    int numElements, tableSize;
    double maxLoadFactor;
    LinkedList<HashElement<K, V>>[] harray;

    public Hash_(int tableSize) {
        this.tableSize = tableSize;
        harray = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
        // 연결 리스트 체이닝
        for (int i = 0; i < tableSize; i++) {
            harray[i] = new LinkedList<HashElement<K, V>>();
        }
        maxLoadFactor = 0.75;
        numElements = 0;
    }

    public boolean add(K key, V value) {
        if (loadFactor() > maxLoadFactor) {
            resize(tableSize * 2);
        }

        HashElement<K, V> he = new HashElement<K, V>(key, value);

        int hashval = key.hashCode();
        hashval = hashval & 0x7FFFFFFF;
        hashval = hashval % tableSize;

        harray[hashval].add(he);
        numElements++;

        return true;
    }

    public boolean remove(K key, V value) {
        HashElement<K, V> he = new HashElement<K, V>(key, value);

        int hashval = key.hashCode();
        hashval = hashval & 0x7FFFFFFF;
        hashval = hashval % tableSize;

        harray[hashval].remove(he);
        numElements--;

        return true;
    }

    public V getValue(K key) {
        int hashval = key.hashCode() & 0x7FFFFFFF % tableSize;
        for (HashElement<K, V> he : harray[hashval]) {
            if (((Comparable<K>) key).compareTo(he.key) == 0) {
                return he.value;
            }
        }
        return null;
    }

    public double loadFactor() {
        if (numElements == 0) {
            return 0;
        }
        return numElements / tableSize;
    }

    public void resize(int newSize) {
        LinkedList<HashElement<K, V>>[] newArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[newSize];

        for (int i = 0; i < newSize; i++) {
            newArray[i] = new LinkedList<>();
        }

        for (LinkedList<HashElement<K, V>> hashElements : harray) {
            for (HashElement<K, V> hashElement : hashElements) {
                K key = hashElement.key;
                V value = hashElement.value;
                HashElement<K, V> he = new HashElement<>(key, value);
                int hashVal = (key.hashCode() & 0x7FFFFFFF) % newSize;
                newArray[hashVal].add(he);
            }
        }

        harray = newArray;
        tableSize = newSize;
    }
}

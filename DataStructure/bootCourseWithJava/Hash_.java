package DataStructure.bootCourseWithJava;

public class Hash_ {
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
    LinkedList_<HashElement<K, V>>[] harray;
}

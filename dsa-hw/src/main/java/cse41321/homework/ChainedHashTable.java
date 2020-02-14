// ChainedHashTable.java
package cse41321.homework;

import cse41321.containers.*;
import cse41321.exceptions.DuplicateKeyException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChainedHashTable<K, V> {
    // Table of buckets
    public SinglyLinkedList<KeyValuePair<K, V>>[] table;

    private int size;
    private double maxLoadFactor;
    private double resizeMultiplier;
    public static int numBuckets;

    public ChainedHashTable() {
        this(numBuckets);  // A prime number of buckets
    }

    @SuppressWarnings("unchecked")
    public ChainedHashTable(int buckets) {
        // Create table of empty buckets
        table = new SinglyLinkedList[buckets];
        for (int i = 0; i < table.length; ++i) {
            table[i] = new SinglyLinkedList<KeyValuePair<K, V>>();
        }

        size = 0;
    }

    // Constructor overloaded for homework assignment
    public ChainedHashTable(int numBuckets, double maxLoadFactor, double resizeMultiplier) {
        this.numBuckets = numBuckets;
        this.maxLoadFactor = maxLoadFactor;
        this.resizeMultiplier = resizeMultiplier;

        // Create table of empty buckets
        table = new SinglyLinkedList[numBuckets];
        for (int i = 0; i < table.length; ++i) {
            table[i] = new SinglyLinkedList<KeyValuePair<K, V>>();
        }

        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void insert(K key, V value) throws
            IllegalArgumentException,
            DuplicateKeyException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
        if (contains(key)) {
            throw new DuplicateKeyException();
        }
        /**
         * If load factor exceeds max load factor, the hash table is resized:
         *  1. Create linked list and store key value pair of original table into it
         *  2. Multiply the number of buckets in current table by the resize multiplier
         *  3. Create a temporary new table with the new number of buckets
         *  4. Rehash each key value pair into the new table
         *  5. Set current table to new table
         */
        if ((double)size / numBuckets > maxLoadFactor) {
            // Create linked list of type KeyValuePair to store each pair of old table
            SinglyLinkedList<KeyValuePair<K,V>> pair = new SinglyLinkedList<>();
            // Get iterator of old table's keys to reference key values
            Iterable<K> keys = this.keys();

            // Iterate through each KeyPairValue of the old table and store them in the list we just created
            for(K k : keys) {
                pair.insertHead(new KeyValuePair<K,V>(k, this.lookup(k)));
            }

            // Multiply number of buckets by the resize multiplier
            numBuckets *= resizeMultiplier;
            // Create a temporary new table with the updated number of buckets
            SinglyLinkedList<KeyValuePair<K, V>>[] newTable = new SinglyLinkedList[numBuckets];
            // Initialize the table's elements
            for (int i = 0; i < newTable.length; ++i) {
                newTable[i] = new SinglyLinkedList<KeyValuePair<K, V>>();
            }

            // Get first element in pair list for iteration purposes
            SinglyLinkedList<KeyValuePair<K,V>>.Element kvpElem = pair.getHead();
            // Rehash each KeyPairValue of old table into new table
            while(kvpElem != null) {
                getBucket(kvpElem.getData().getKey(), newTable).insertHead(new KeyValuePair<>(kvpElem.getData().getKey(), kvpElem.getData().getValue()));
                kvpElem = kvpElem.getNext();
            }

            // Update the old table to the new table
            table = newTable;

        }
        getBucket(key, table).insertHead(new KeyValuePair<K, V>(key, value));
        ++size;
    }

    public V remove(K key) throws
            IllegalArgumentException,
            NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        // If empty bucket
        SinglyLinkedList<KeyValuePair<K, V>> bucket = getBucket(key, table);
        if (bucket.isEmpty()) {
            throw new NoSuchElementException();
        }

        // If at head of bucket
        SinglyLinkedList<KeyValuePair<K, V>>.Element elem = bucket.getHead();
        if (key.equals(elem.getData().getKey())) {
            --size;
            return bucket.removeHead().getValue();
        }

        // Scan rest of bucket
        SinglyLinkedList<KeyValuePair<K, V>>.Element prev = elem;
        elem = elem.getNext();
        while (elem != null) {
            if (key.equals(elem.getData().getKey())) {
                --size;
                return bucket.removeAfter(prev).getValue();
            }
            prev = elem;
            elem = elem.getNext();
        }

        throw new NoSuchElementException();
    }

    public V lookup(K key) throws
            IllegalArgumentException,
            NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        // Scan bucket for key
        SinglyLinkedList<KeyValuePair<K, V>>.Element elem =
                getBucket(key, table).getHead();
        while (elem != null) {
            if (key.equals(elem.getData().getKey())) {
                return elem.getData().getValue();
            }
            elem = elem.getNext();
        }

        throw new NoSuchElementException();
    }

    public boolean contains(K key) {
        try {
            lookup(key);
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (NoSuchElementException ex) {
            return false;
        }

        return true;
    }

    private SinglyLinkedList<KeyValuePair<K, V>> getBucket(K key, SinglyLinkedList<KeyValuePair<K, V>>[] table) {
        // Multiplication method
        final double A = (Math.sqrt(5) - 1) / 2;
        return table[(int)Math.floor(table.length * (int)A * key.hashCode())];


        // Division method
        //return table[Math.abs(key.hashCode()) % table.length];
    }

    public void insert(V i) {
    }

    private class KeysIterator implements Iterator<K> {
        private int remaining;  // Number of keys remaining to iterate
        private int bucket;     // Bucket we're iterating
        private SinglyLinkedList<KeyValuePair<K, V>>.Element elem;
                                // Position in bucket we're iterating

        public KeysIterator() {
            remaining = ChainedHashTable.this.size;
            bucket = 0;
            elem = ChainedHashTable.this.table[bucket].getHead();
        }

        public boolean hasNext() {
            return remaining > 0;
        }

        public K next() {
            if (hasNext()) {
                // If we've hit end of bucket, move to next non-empty bucket
                while (elem == null) {
                    elem = ChainedHashTable.this.table[++bucket].getHead();
                }

                // Get key
                K key = elem.getData().getKey();

                // Move to next element and decrement entries remaining
                elem = elem.getNext();
                --remaining;

                return key;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public Iterable<K> keys() {
        return new Iterable<K>() {
            public Iterator<K> iterator() {
                return new KeysIterator();
            }
        };
    }
}

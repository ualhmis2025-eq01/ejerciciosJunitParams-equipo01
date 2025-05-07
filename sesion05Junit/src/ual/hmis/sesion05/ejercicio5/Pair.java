package ual.hmis.sesion05.ejercicio5;

import java.util.Objects;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    
    @Override
    public boolean equals(Object obj) {
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return Objects.equals(key, pair.key);
    }
}


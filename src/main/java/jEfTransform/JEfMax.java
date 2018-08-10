package jEfTransform;

import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfListNullException;
import jEfExceptions.jEfQueueEmptyException;
import jEfExceptions.jEfSetIsNullException;

import java.util.*;

public class JEfMax<T extends Number, K extends Number> {

    private static boolean comparison(Number a, Number b)
    {
        return a.doubleValue() - b.doubleValue() < 0;
    }

    public static <T> T maxList(List<T> list) throws JEfListNullException{

        if(list == null || list.size() == 0) throw new JEfListNullException();
        T max = list.get(0);

        for (int i=1; i<list.size(); i++){
            if(!comparison((Number)list.get(i),(Number)max)){
                max = list.get(i);
            }
        }
        return max;
    }

    public static <T> T maxArray(T[] array) throws JEfArrayNullException{

        if(array == null || array.length == 0) throw new JEfArrayNullException();
        T max = array[0];

        for (int i=1; i<array.length; i++){
            if(!comparison((Number)array[i],(Number)max)){
                max = array[i];
            }
        }
        return max;
    }

    public static <T> T maxQueue(Queue<T> queue){

        if ( queue == null || queue.size() == 0 ) throw new jEfQueueEmptyException("Queue is empty");

        Queue<T> tempQueue = queue;

        T max = tempQueue.peek();

        while(!tempQueue.isEmpty()) {
            T variable = tempQueue.poll();
            if ( !comparison((Number)variable, (Number)max)) {
                max = variable;
            }
        }
        return max;
    }

    public static <T> T maxHashSet(HashSet<T> set){

        if ( set == null || set.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        Set<T> tempSet = set;

        T max = tempSet.iterator().next();

        for(T key : tempSet) {
            if ( !comparison((Number)key, (Number)max)) {
                max = key;
            }
        }
        return max;
    }

    public static <K, T> T maxHashMapByValue(HashMap<K,T> map){

        if( map.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        Map.Entry<K,T> entry = map.entrySet().iterator().next();

        T max = entry.getValue();

        for (Map.Entry<K,T> tempEntry : map.entrySet()) {
            T value = tempEntry.getValue();
            if ( !comparison((Number)value, (Number)max)) {
                max = value;
            }
        }
        return max;
    }

    public static <K, T> K maxHashMapByKey(HashMap<K,T> map){

        if( map.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        K max = map.keySet().stream().findFirst().get();

        for (Map.Entry<K,T> entry : map.entrySet()) {
            K key = entry.getKey();
            if ( !comparison((Number)key, (Number)max)) {
                max = key;
            }
        }
        return max;
    }

    public static <K, T> T maxHashTableByValue(Hashtable<K, T> hashTable){

        if( hashTable.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        Map.Entry<K,T> entry = hashTable.entrySet().iterator().next();

        T max = entry.getValue();

        for (Map.Entry<K,T> tempEntry : hashTable.entrySet()) {
            T value = tempEntry.getValue();
            if ( !comparison((Number)value, (Number)max)) {
                max = value;
            }
        }
        return max;
    }

    public static <K, T> K maxHashTableByKey(Hashtable<K, T> hashTable){

        if( hashTable.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        K max = hashTable.keySet().stream().findFirst().get();

        for (Map.Entry<K,T> entry : hashTable.entrySet()) {
            K key = entry.getKey();
            if ( !comparison((Number)key, (Number)max)) {
                max = key;
            }
        }
        return max;
    }
}

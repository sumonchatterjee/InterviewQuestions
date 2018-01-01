package newquestioninleetcode;

import java.util.*;

/**
 * Created by sumon.chatterjee on 20/12/17.
 * Generics details
 */
public class TestingCode<T> {
    T obj;

    public static void main(String[] args) {
        Collection<String>m= new LinkedHashSet<>();
        m.add("hello");
        m.add("sumon");

       /* for (String s : m) {
            System.out.println(s);
        }*/

        /*Iterator<String>c=m.iterator();
        while(c.hasNext()) {
            System.out.println(c.next());
        }
        */


      Pair<Integer,String> pairs= new Pair<>(1,"opo");

    }

    void add(T obj){this.obj=obj;}


    private T getDetail(){
        return obj;
    }


    public static < E > void printArray(E[] elements) {
        for ( E element : elements){
            System.out.println(element );
        }
        System.out.println();
    }


    public <U extends Number> void inspect(U u){
        System.out.println("U: " + u.getClass().getName());
    }


    //generic methods and bounded type parameters
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }


    static class Pair<K,V>{

        K key;
        V value;

        Pair(K key, V value){
            this.key=key;
            this.value=value;

        }
    }
}

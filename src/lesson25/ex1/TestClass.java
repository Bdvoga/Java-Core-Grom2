package lesson25.ex1;

public class TestClass <T, K, V> {

    public T doSomething(T t) {
        System.out.println("1");
        //logic
        return t;
    }

    public K doSomething1(K k) {
        System.out.println("2");
        //logic1
        return k;
    }

    public V doSomething2(V v) {
        System.out.println("3");
        //logic2
        return v;
    }
}

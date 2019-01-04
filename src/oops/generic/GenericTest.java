package oops.generic;

public class GenericTest {

    public static void main(String[] args){

        //without generics
        //Store s = new Store();
        //s.setItem(45);
        //Integer item = (Integer) s.getItem();

        //we can change the parameter - compile time type check and error check
        //raw types Avoid It !!
        Store<String> stringStore = new Store<>(); // diamond operator
        stringStore.setItem("hello generics");
        String item = stringStore.getItem();
        System.out.println(stringStore);

        //hashtable example
        Hashtable<String,Integer> hashtable = new Hashtable<>("Hello World",55);
        System.out.println(hashtable);

        GenericMethod genericMethod = new GenericMethod();
        System.out.println(" Returned item is: "+ genericMethod.showItem("hello"));

        Integer[] intArr = {1,2,3,4};
        String[] names = {"ShahRukh", "Salman","Amir"};
        genericMethod.showArray(names);

    }
}

class Store<T>{

    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.toString();
    }

}

class Hashtable<K,V>{

    private K key;
    private V value;
    Hashtable(K key , V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key.toString() + "-   " + value.toString();
    }
}
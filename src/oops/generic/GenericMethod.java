package oops.generic;

public class GenericMethod {

 public <T> T showItem(T t){
     System.out.print("Item is :" + t);
     return t;
 }
 public <T> void showArray(T[] array){
    for(T item:array) {
        System.out.print(item.toString() + "->");
    }
 }

 public static <T extends Comparable<T>> T calculate(  T t1, T t2){
     if(t1.compareTo(t2)<0){
         return t1;
     }
     return t2;
 }
}


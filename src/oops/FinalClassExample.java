package oops;

import java.util.HashMap;
import java.util.Iterator;

public class FinalClassExample {

    private  int id = 0;
    private final String name;
    public final HashMap<String, String> myMap;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    //Accessor function for mutable object
    public HashMap<String,String> getMyMap() {
        return (HashMap<String, String>)myMap.clone();
    }

    public FinalClassExample(int i, String str, HashMap myMap) {
        this.id = i;
        this.name = str;
        HashMap<String,String> tempMap=new HashMap<String, String>();
        String key;
        Iterator<String> itr = myMap.keySet().iterator();
        while(itr.hasNext()){
            key=itr.next();
            tempMap.put(key, (String) myMap.get(key));
        }
        this.myMap=tempMap;
    }
    /**
     * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String,String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";
        String s1= new String("original");
        String s2 = new String ("original");

        int i=10;

        FinalClassExample ce = new FinalClassExample(i,s,h1);

        //Lets see whether its copy by field or reference
        System.out.println(s == ce.getName());
        System.out.println(s2.equals(s1));
        System.out.println(h1 == ce.getMyMap());
        //print the ce values
        System.out.println("ce id:"+ce.getId());
        System.out.println("ce name:"+ce.getName());
        System.out.println("ce testMap:"+ce.getMyMap());
        //change the local variable values
        i=20;
        s="modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:"+ce.getId());
        System.out.println("ce name after local variable change:"+ce.getName());
        System.out.println("ce testMap after local variable change:"+ce.getMyMap());

        HashMap<String, String> hmTest = ce.getMyMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:" + ce.getMyMap());

    }
}

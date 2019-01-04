package oops;

public class PrivateMethodOverrideOrNot {

    public static void main(String[] args){

        Parent p = new Parent();
        Parent p1 = new Child();
        Child c = new Child();
        p.m1();
        p1.m1();
        c.m1();
        System.out.println(((Child) p1).i);
        System.out.println(p.i);
        System.out.println(c.i);
    }
}

class Parent {
    int i = 10;
    public static void m1(){System.out.println("In-Parent");}
}
class Child extends Parent{
    int i = 20;
    public static void m1(){System.out.println("In-Child");}
}
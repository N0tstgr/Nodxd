package com.company;
abstract class Parent2{
    public Parent2(){
        System.out.println(" i am a constructor");

    }
    public void sayYes(){
        System.out.println("yes");
    }
    abstract public void greet();
    abstract public void greet2();
}

abstract class Child2 extends Parent2 {
    @Override
    public void greet() {
        System.out.println("  good morning ");
    }


    @Override
    public void greet2() {
        System.out.println("  good morning 2");
    }
}
abstract class Child3 extends Parent2{
public void  oi(){
    System.out.println("juxxy");
}
}
public class Not_vid53abstract {
    public static void main(String[] args) {
        
    }
}

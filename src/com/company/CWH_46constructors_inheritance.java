package com.company;

//import org.w3c.dom.ls.LSOutput;

class Base7{
    Base7(){
        System.out.println("hi i'm  vikash the trillionaire");
    }
    Base7(int x ){
        System.out.println("this is the thing  " + x);
    }

}

class Derived1 extends Base7{

    Derived1(){
//        super(9);
        System.out.println("vikash is gonna billionaire by this september");
    }
    Derived1(int x, int y){
        super(x);
        System.out.println("i am an intelligent guy with amount x billion dollars till sep 9 in 2025: "+ y);
    }

}

class ChildofDerived extends Derived1{
    ChildofDerived(){
        System.out.println(" I am a child child derived constructor");
    }
    ChildofDerived(int x, int y, int z){
        super(x, y);
        System.out.println("i am a child overloaded derived constructor : " + z);
    }
}
public class CWH_46constructors_inheritance {
    public static void main(String[] args) {
//Base7 a = new Base7();
//Derived1 c = new Derived1(4, 5);

//        ChildofDerived n = new ChildofDerived();
        ChildofDerived n = new ChildofDerived(5, 3, 7);

    }
}

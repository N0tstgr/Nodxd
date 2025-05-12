package com.company;

class A{
//    public int vikash(){
//        return 2;
//    }
    public void meth3(){
        System.out.println("this is public void");
    }

        }
        class B extends A{
    @Override
public void meth3() {
    System.out.println("this is public void b");
}
public void meth4(){
        System.out.println("i am  the public class of 4");
    }

        }

public class NOt_vid48_mthdovedig {
    public static void main(String[] args) {
        System.out.println();
A a = new A();
a.meth3();
B b = new B();
b.meth3();



    }
}

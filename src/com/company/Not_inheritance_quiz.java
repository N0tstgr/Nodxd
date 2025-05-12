package com.company;
class animal{
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

class Dog extends animal{
    int d;

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
public class Not_inheritance_quiz {
    public static void main(String[] args) {

        Dog g = new Dog();
        g.setA(4);
        g.getA();
        System.out.println(g.getA());


    }
}

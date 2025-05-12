package com.company;


class thisclass{
    int c;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

        thisclass(int c){
        this.c = c;
    }
}
class thatclass extends thisclass{
    thatclass(int o){
        super(o);
        System.out.println("hi this is the thing   " + o);
    }
}
public class Not_vid47_this {
    public static void main(String[] args) {
        thisclass n = new thisclass(2);
thatclass u = new thatclass(1);
n.setC(3);
        System.out.println(n.getC());

    }
}

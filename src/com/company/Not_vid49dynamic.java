package com.company;

class phone{

    public void showtime(){
        System.out.println("time is 8 am ");
    }
    public void on(){
        System.out.println("turning on Phone ");
    }
}
class smartphone extends phone{
    public void music(){
        System.out.println("playing the music");
    }

    public void on(){
        System.out.println("turning on smartphone");
    }
}

public class Not_vid49dynamic {
    public static void main(String[] args) {
//        node obj = new node();
//        nodejs nodobj = new nodejs();
//        obj.name();
        phone a = new smartphone();   //corect approach from super class to class
//        nodejs n = new node(); wrong approach towards the thing
a.on();
a.showtime();
//a.music();
    }
}

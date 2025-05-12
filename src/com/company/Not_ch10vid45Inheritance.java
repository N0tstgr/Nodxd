package com.company;
 class base{
int x;

     public  int getX(){
         return x;
     }
public void  setX(int n){
         this.x = n;
     }
     void printMe(){
    System.out.println("hi vikash here");
}
}

class Derived extends base{
int y;
public int getY(){
    return y;
}
public void setY(int a){
    this.y = a;
}




}
public class Not_ch10vid45Inheritance {
    public static void main(String[] args) {
//base b = new base()
        //creating an object of base class
base  b = new base();
b.setX(5);
b.getX();
        System.out.println(b.getX());

        //creating an object of derived class
        Derived d =  new Derived();
        d.setY(87);
        System.out.println(d.getY());
        d.setY(78);
      
        System.out.println(d.getY());
    }
}

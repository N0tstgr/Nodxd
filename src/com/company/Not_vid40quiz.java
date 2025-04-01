package com.company;
class Circle{
    private int  area;
    private int radius;

    public int getRadius(){
        return radius;}

public  void setRadius(int i) {
this.radius = i;
       }

public  int getArea(){
  return area; }
    public void setArea(int j){
        this.area = j;
    }
}
public class Not_vid40quiz {
    public static void main(String[] args) {
Circle Parameter = new Circle();
Parameter.setRadius(9);
Parameter.setArea(8);
        System.out.println(Parameter.getRadius());
        System.out.println(Parameter.getArea());
    }
}

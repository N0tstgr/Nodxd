package com.company;
class MyMain2Employee {
    private int Salary;
    private String name;

    public MyMain2Employee(int Salary, String hisname){
     this.Salary  = Salary;
      name = hisname;
    }
public int getSalary(){
        return Salary;

}
public   String getname(){
        return name;

    }



}
public class Not_construtrsovrldquiz {
    public static void main(String[] args) {
        MyMain2Employee kalua = new MyMain2Employee(5000, "vikash" );

        System.out.println(kalua.getSalary());
        System.out.println(kalua.getname());


    }
}

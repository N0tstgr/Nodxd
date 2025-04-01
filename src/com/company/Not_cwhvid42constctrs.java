package com.company;
class MyMainEmployee{
    public MyMainEmployee(){
        id = 87;
        name = "vikash";
    }

    public MyMainEmployee(int id , String  hisName){
        this.id = id;
        name = hisName;

    }
//    public MyMainEmployee(int id , String  hisName){
//        this.id = 1;
//        name = hisName;
//
//    }
    private int id;
    private String name;

    public String getName(){return name;
    }
    public void setName(String n){this.name = n;
    }
    public void setId(int i){this.id = i;
    }
    public int getId(){return id;
    }
}
public class Not_cwhvid42constctrs {
    public static void main(String[] args) {
        MyMainEmployee lnot = new MyMainEmployee(2 , "hi");
//        MyMainEmployee lnot = new MyMainEmployee( );
// lnot.setName("hi vikash the trillionaire");
        System.out.println(lnot.getName());
        System.out.println(lnot.getId());











    }
}






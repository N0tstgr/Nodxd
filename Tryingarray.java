
package com.company;

public class Tryingarray{
    public static void main(String[] args) {
        int[]marks = {98, 45, 79, 99, 80 , 989};
//        float[]marks = {98.1f, 45.6f, 79.98f, 99.00f, 80.3f};
//        String [] students = {"vikash", "luxxy", "zuxxy", "not", "stranger"};
//        System.out.println(students[4]);
        System.out.println(marks.length);
//        System.out.println(marks[2]);

        //displaying the Array (Naive way)
        System.out.println("Printing using naive method");
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        System.out.println(marks[3]);
        System.out.println(marks[4]);
        System.out.println(marks[5]);
        //displaying the Array (for loop)
        System.out.println("Printing using for loop");
        for(int i = 0; i<marks.length; i++){
            System.out.println(marks[i]);




        }
        //quizquick: Displaying the Array (for -each loop)

        System.out.println("In reverse order");
        for(int i = marks.length-1; i>=0; i--){
            System.out.println(marks[i]);
        }
        //Quick quiz : displaying the Array (for-each loop)
        System.out.println("Printing using for- each loop");
        for(int element: marks){
            System.out.println(element);
        }
    }
}


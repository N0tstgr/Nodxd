package com.company;

public class Not_ps6vid29Array {
    public static void main(String[] args) {
//ps 1
//        float sum  = 0;
//float[] marks  = {90.4f, 99f, 88, 99.4f, 33.7f, };

//sum += marks[0]+marks[1]+ marks[2]+ marks[3]+ marks[4];
//float[] numbers = new float[5];
//numbers[0] = 100.f;
//numbers[1] = 55.4f;
//numbers[2] = 44.3f;
//numbers[3] = 44.23f;
//numbers[4] = 98.56f;
//numbers[5] = 76.33f;
//        sum  += numbers[0]+ numbers[1] + numbers[2]+ numbers[3] + numbers[4];
//        for(float i = 0; i<marks.length; i++){
//            System.out.println(i);
//        }
//for(float  element:marks){
//    sum = sum + element;
//        }
//        System.out.println(sum);
//Practice problem 2
//        int[] marks = new int[5];
//        marks[0] = 99;
//        marks[1] = 90;
//        marks[2] = 45;
//        marks[3] = 98;
//        marks[4] = 67;
//        System.out.println(marks[3]);
        float[] marks  = {90.4f, 99f, 88, 99.4f, 33.7f, };
        float num = 33.7f;
        boolean isInArray = false;
        for (float element: marks) {
            if (num == element) {
isInArray = true;
break;
            }
//        } if (isInArrya) {
            System.out.println("the value is true" + isInArray);
        }else{
            System.out.println("the value is false");
        }


    }
}

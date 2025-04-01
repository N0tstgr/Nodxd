package com.company;
import java.util.Random;
import java.util.Scanner;


public class Not_rockpaperscissor {
    public static void main(String[] args) {
        //Rock paper Scissor??
        Scanner sc = new Scanner(System.in);   //>>>>>>>>>>>>> computer program
Random rand = new Random();                            //>>>>>>>>>>>>>computer program
        System.out.println("what is your choice");
        String choose = sc.nextLine();
//        System.out.println(choose);

        int choice = rand.nextInt(3);            //>>>>>>>>>>>>>computer program

        String[] options = {"Rock" , "Paper", "Scissor"};        //>>>>>>>>>>>>>computer program
        System.out.println("Computer choice : " + options[choice]);            //>>>>>>>>>>>>> computer program


    }
}

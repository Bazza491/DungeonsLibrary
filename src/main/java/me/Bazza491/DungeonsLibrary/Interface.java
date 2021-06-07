package me.Bazza491.DungeonsLibrary;

import java.util.Scanner;
public class Interface {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        do {
            //interface/program begins

            input = scan.nextLine().toLowerCase();
            if (input.equals("new")) {
                System.out.println("Creating New: \n - me.Bazza491.DungeonsLibrary.Attack \n - PC \n - me.Bazza491.DungeonsLibrary.Monster");
                String objectType = scan.nextLine().toLowerCase();

                switch(objectType) {
                    //TODO - add all object types
                    case "attack":
                        IFNew.attack();
                    case "end":
                        break;
                    default:
                        System.out.println("Unexpected input at new object stage, please try again");
                        break;
                }
            }
            else {
                System.out.println("Unexpected input, please try again. ");
            }



        } while (!input.equals("end"));
    }
}

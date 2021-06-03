package me.Bazza491.DungeonsLibrary;

public class Solution {
    public static void main(String[] args) {
        int numberSize = 32401;
        int digits = 0;
        int lines = 0;
        int cubes = 0;
        for (int j = 0; j < numberSize; j++)  {
            digits++;
            System.out.print((int) (Math.random()*9));
            if (digits % 180 == 0) {
                System.out.print("\n");
                lines++;
            }
            if (lines % 180 == 0 && digits % 180 == 0) {
                System.out.print("\n");
                cubes++;
            }

        }
        System.out.println("\nNumber of digits = " + Methods.humanFormat(digits));
        System.out.println("Number of lines = " +  Methods.humanFormat(lines));
        System.out.println("Number of cubes = " +  Methods.humanFormat(cubes));
    }

}

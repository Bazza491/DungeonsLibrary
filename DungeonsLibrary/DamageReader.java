package me.Bazza491.DungeonsLibrary;

import java.util.Scanner;

public class DamageReader {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String test = scan.nextLine().toLowerCase();
        int dPos = 0;
        String letter = "Temp";

        while (!letter.equals("d")) {
            dPos++;
            letter = test.substring(dPos, dPos + 1);

            if (dPos >= test.length()) {
                break;
            }
        }
        String theDieVolume = test.substring(0, dPos);
        int dieVolume = Integer.parseInt(theDieVolume);

        String theDieType = test.substring(dPos + 1);
        int dieType = Integer.parseInt(theDieType);

        System.out.println("me.Bazza491.DungeonsLibrary.Die Volume: " + dieVolume + "\nme.Bazza491.DungeonsLibrary.Die me.Bazza491.DungeonsLibrary.Type: " + dieType);
    }
}

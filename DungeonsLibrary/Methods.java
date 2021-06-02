package me.Bazza491.DungeonsLibrary;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.IOException;

public abstract class Methods {
    public Methods() {
    }

    public static DamageType stringToDT(String damageType) {
        String input = damageType.toLowerCase();
        byte var4 = -1;
        switch(input.hashCode()) {
            case -1929420024:
                if (input.equals("POISON")) {
                    var4 = 8;
                }
                break;
            case -821927254:
                if (input.equals("LIGHTNING")) {
                    var4 = 5;
                }
                break;
            case -705062587:
                if (input.equals("SLASHING")) {
                    var4 = 11;
                }
                break;
            case -616912700:
                if (input.equals("THUNDER")) {
                    var4 = 12;
                }
                break;
            case -513600276:
                if (input.equals("BLUDGEONING")) {
                    var4 = 1;
                }
                break;
            case 2483:
                if (input.equals("NA")) {
                    var4 = 13;
                }
                break;
            case 2003133:
                if (input.equals("ACID")) {
                    var4 = 0;
                }
                break;
            case 2074340:
                if (input.equals("COLD")) {
                    var4 = 2;
                }
                break;
            case 2158134:
                if (input.equals("FIRE")) {
                    var4 = 3;
                }
                break;
            case 67080907:
                if (input.equals("FORCE")) {
                    var4 = 4;
                }
                break;
            case 107374085:
                if (input.equals("PIERCING")) {
                    var4 = 7;
                }
                break;
            case 446330869:
                if (input.equals("PSYCHIC")) {
                    var4 = 9;
                }
                break;
            case 1604782885:
                if (input.equals("NECROTIC")) {
                    var4 = 6;
                }
                break;
            case 1686791763:
                if (input.equals("RADIANT")) {
                    var4 = 10;
                }
        }

        DamageType output;
        switch(var4) {
            case 0:
                output = DamageType.ACID;
                break;
            case 1:
                output = DamageType.BLUDGEONING;
                break;
            case 2:
                output = DamageType.COLD;
                break;
            case 3:
                output = DamageType.FIRE;
                break;
            case 4:
                output = DamageType.FORCE;
                break;
            case 5:
                output = DamageType.LIGHTNING;
                break;
            case 6:
                output = DamageType.NECROTIC;
                break;
            case 7:
                output = DamageType.PIERCING;
                break;
            case 8:
                output = DamageType.POISON;
                break;
            case 9:
                output = DamageType.PSYCHIC;
                break;
            case 10:
                output = DamageType.RADIANT;
                break;
            case 11:
                output = DamageType.SLASHING;
                break;
            case 12:
                output = DamageType.THUNDER;
                break;
            case 13:
                output = DamageType.NA;
                break;
            default:
                output = DamageType.NA;
        }

        return output;
    }

    public static String humanFormat(int x) {
        String humanNumber = "";
        String xString = Integer.toString(x);
        char[] theX = xString.toCharArray();

        for(int index = 0; index < theX.length; ++index) {
            humanNumber = humanNumber + theX[index];
            if ((theX.length - index) % 3 == 1 && index != theX.length - 1) {
                humanNumber = humanNumber + ",";
            }
        }

        return humanNumber;
    }

    public static void createFile(String filename) {
        try {
            File myObj = new File(filename + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException var2) {
            System.out.println("An error occurred.");
            var2.printStackTrace();
        }

    }
}

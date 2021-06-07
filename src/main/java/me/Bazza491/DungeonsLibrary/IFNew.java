package me.Bazza491.DungeonsLibrary;

import java.util.Scanner;
public class IFNew {
    public static void attack() {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("Creating new me.Bazza491.DungeonsLibrary.Attack object. \nName: ");
        String attackName = scan.nextLine();
        System.out.print("me.Bazza491.DungeonsLibrary.Type: ");
        input = scan.nextLine().toLowerCase();
        switch (input) {
            //TODO - add all attack types
            case "weapon":
                int dieType = 0;
                System.out.print("me.Bazza491.DungeonsLibrary.Weapon me.Bazza491.DungeonsLibrary.Type: ");
                String weaponType = scan.nextLine().toLowerCase();
                switch (weaponType) {
                    //TODO - add all weapon types
                    case "greataxe":
                        dieType = 12;
                        break;
                    default:
                        System.out.println("Unexpected input at weapon type stage, please try again");
                        break;
                }
                if (weaponType.equals("end")) {
                    input = "end";
                    break;
                }
                if (dieType == 0)
                    break;
                System.out.print("Number of attacks: ");
                int numOfAttacks = scan.nextInt();
                //TODO - user inputs scores rather than direct damage bonus and attack modifier
                System.out.print("Damage bonus (as integer): ");
                int dmgBonus = scan.nextInt();
                System.out.print("me.Bazza491.DungeonsLibrary.Attack bonus: ");
                int attackBonus = scan.nextInt();
                System.out.println("Damage type: ");
                String damageTypeS = scan.nextLine();
                DamageType damageType = Methods.stringToDT(damageTypeS);


                Attack attack1 = new Attack(attackName, numOfAttacks, dieType, dmgBonus, attackBonus, damageType);
                attack1.roll();
                break;
            case "end":
                break;
            default:
                System.out.println("Unexpected input at attack type stage, please try again");
                break;

        }
    }
}

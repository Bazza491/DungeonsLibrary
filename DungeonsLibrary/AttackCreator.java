package me.Bazza491.DungeonsLibrary;

public class AttackCreator {
    public static void main(String[] args) {

        Monster me = new Monster("Bob", Size.LARGE, Type.BEAST, Alignment.NEUTRAL_GOOD,
                14, 100, 40, "Fly 60ft", 16, 14, 18, 8, 10, 9,
                SaveThrow.STRENGTH, null, 5, DamageType.ACID, DamageType.ACID, DamageType.SLASHING,
                "Blindsight 20ft", Language.COMMON, 13);

        Attack longsword = new Attack("Longsword slash", 3, 12, 5, 8, DamageType.SLASHING);

        System.out.println("Damage = " + longsword.damage());

        System.out.println("my hp = " + me.getHp());
        longsword.attackMonster(me);
        System.out.println("my hp = " + me.getHp());


        

    }
}

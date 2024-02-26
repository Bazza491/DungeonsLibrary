package me.Bazza491.DungeonsLibrary;

public class WeaponAttack extends NewAttack {
    protected int dmgBonus;
    protected int attackBonus;
    protected int numOfAttacks;

    public WeaponAttack(String attackName, int dieType, DamageType damageType, String otherEffects,
                        int dmgBonus, int attackBonus, int numOfAttacks) {
        super (attackName, dieType, damageType, otherEffects);
        this.numOfAttacks = numOfAttacks;
        this.dmgBonus = dmgBonus;
        this.attackBonus = attackBonus;
    }

    public WeaponAttack(String attackName, int numOfAttacks, Weapon weapon, StatBlock stats) {
        super (attackName, weapon.getDieType(), weapon.getDamageType(), "N/A");

        int dmgBonus;
        if (weapon.getPropertiesList().contains(WeaponProperty.FINESSE)) {
            dmgBonus = stats.getDex()/2-10;
        } else {
            dmgBonus = stats.getStr()/2-10;
        }

        int attackBonus;
        if (weapon.getPropertiesList().contains(WeaponProperty.FINESSE)) {
            attackBonus = stats.getProfBonus() + (stats.getDex()/2-10);
        } else {
            attackBonus = stats.getProfBonus() + (stats.getStr()/2-10);
        }

        this.numOfAttacks = numOfAttacks;
        this.dmgBonus = dmgBonus;
        this.attackBonus = attackBonus;
    }
    public void print() {

    }

    public void roll(int targetAC) {
        Die d20 = new Die(20);
        int totalDmg = 0;
        String rolls = "";
        int theRollToHit = d20.roll() + this.attackBonus;
        String rollResults;
        int saveThrow;
        int roll;
        for(saveThrow = this.numOfAttacks; saveThrow > 0; --saveThrow) {
            if (theRollToHit > targetAC) {
                roll = (int)(Math.random() * (double)this.dieType) + 1;
                rolls = rolls + theRollToHit + " hits for " + (roll + this.dmgBonus) + " damage ";
                totalDmg = totalDmg + roll + this.dmgBonus;
            } else {
                rolls = rolls + theRollToHit + " misses ";
            }

            theRollToHit = d20.roll() + this.attackBonus;
        }
        rollResults = "Rolling... \nYour rolls: " + rolls + " \nTotal damage: " + totalDmg + " damage\n" + this.otherEffects;
        System.out.println(rollResults);
    }

    public int damage(int targetAC) {
        Die d20 = new Die(20);
        int totalDmg = 0;
        String rolls = "";
        int theRollToHit = d20.roll() + this.attackBonus;
        String rollResults;
        int saveThrow;
        int roll;
        for(saveThrow = this.numOfAttacks; saveThrow > 0; --saveThrow) {
            if (theRollToHit > targetAC) {
                roll = (int)(Math.random() * (double)this.dieType) + 1;
                rolls = rolls + theRollToHit + " hits for " + (roll + this.dmgBonus) + " damage ";
                totalDmg = totalDmg + roll + this.dmgBonus;
            } else {
                rolls = rolls + theRollToHit + " misses ";
            }

            theRollToHit = d20.roll() + this.attackBonus;
        }
        rollResults = "Rolling... \nYour rolls: " + rolls + " \nTotal damage: " + totalDmg + " damage\n" + this.otherEffects;
        System.out.println(rollResults);
        return totalDmg;
    }

    public void attackMonster(Monster target) {
        System.out.println("Rolling to hit " + target.getName());
        int targetAC = target.getAC();
        target.dealDamage(this.damage(targetAC), this.damageType);
    }
}

package me.Bazza491.DungeonsLibrary;


public class Attack {
    private String attackName;
    private int dieType;
    private int dieVolume;
    private int dmgBonus;
    private int attackBonus;
    private int spellSaveDC;
    private DamageType damageType;
    private String otherEffects;
    private AttackType attackType;
    private int numOfAttacks;
    private static int targetAC;
    private static int saveProficiency;
    private Die d20 = new Die(20);

    public Attack() {
        this.attackName = "N/A";
        this.dieType = 6;
        this.dieVolume = 1;
        this.dmgBonus = 0;
        this.attackBonus = 0;
        this.spellSaveDC = 10;
        this.damageType = DamageType.NA;
        this.otherEffects = "N/A";
        this.attackType = AttackType.RANGED_SPELL;
        saveProficiency = 0;
    }

    public Attack(String attackName, int numOfAttacks, int dieType, int dmgBonus, int attackBonus, DamageType damageType) {
        this.attackName = attackName;
        this.numOfAttacks = numOfAttacks;
        this.dieType = dieType;
        this.dmgBonus = dmgBonus;
        this.attackBonus = attackBonus;
        this.damageType = damageType;
        this.attackType = AttackType.WEAPON;
    }

    public Attack(String attackName, int dieVolume, int dieType, int attackBonus, DamageType damageType, String otherEffects) {
        this.attackName = attackName;
        this.dieVolume = dieVolume;
        this.dieType = dieType;
        this.attackBonus = attackBonus;
        this.otherEffects = otherEffects;
        this.damageType = damageType;
        this.attackType = AttackType.RANGED_SPELL;
    }

    public Attack(String attackName, int dieVolume, int dieType, int spellSaveDC, int saveProficiency, DamageType damageType, String otherEffects) {
        this.attackName = attackName;
        this.dieVolume = dieVolume;
        this.dieType = dieType;
        this.spellSaveDC = spellSaveDC;
        Attack.saveProficiency = saveProficiency;
        this.damageType = damageType;
        this.otherEffects = otherEffects;
        this.attackType = AttackType.SAVE_SPELL;
    }

    public void roll() {
        int totalDmg = 0;
        String rolls = "";
        boolean attackHits = false;
        int timesToRoll = this.dieVolume;
        int theRollToHit = this.d20.roll() + this.attackBonus;
        String rollResults;
        int saveThrow;
        int roll;
        switch(this.attackType) {
            case WEAPON:
                for(saveThrow = this.numOfAttacks; saveThrow > 0; --saveThrow) {
                    if (theRollToHit > targetAC) {
                        roll = (int)(Math.random() * (double)this.dieType) + 1;
                        rolls = rolls + theRollToHit + " hits for " + (roll + this.dmgBonus) + " damage ";
                        totalDmg = totalDmg + roll + this.dmgBonus;
                    } else {
                        rolls = rolls + theRollToHit + " misses ";
                    }

                    theRollToHit = this.d20.roll() + this.attackBonus;
                }

                rollResults = "Rolling... \nYour rolls: " + rolls + " \nTotal damage: " + totalDmg + " damage\n" + this.otherEffects;
                System.out.println(rollResults);
                break;
            case RANGED_SPELL:
                theRollToHit = this.d20.roll();
                if (theRollToHit > targetAC) {
                    attackHits = true;
                }

                if (attackHits) {
                    while(timesToRoll > 0) {
                        roll = (int)(Math.random() * (double)this.dieType) + 1;
                        totalDmg += roll;
                        rolls = rolls + roll + " ";
                        --timesToRoll;
                    }
                }

                if (!attackHits) {
                    rollResults = "Rolling to hit..." + theRollToHit + " Misses";
                } else {
                    rollResults = "Rolling to hit... " + theRollToHit + " Hits! \nYou rolled: " + rolls + "\nTotal damage: " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                }

                System.out.print(rollResults);
                break;
            case SAVE_SPELL:
                saveThrow = this.d20.roll() + saveProficiency;
                if (saveThrow < this.spellSaveDC) {
                    attackHits = true;
                }

                while(timesToRoll > 0) {
                    roll = (int)(Math.random() * (double)this.dieType) + 1;
                    totalDmg += roll;
                    rolls = rolls + roll + " ";
                    --timesToRoll;
                }

                if (!attackHits) {
                    int Dmg = totalDmg;
                    totalDmg /= 2;
                    rollResults = "Rolling save..." + saveThrow + " succeeds \nYou rolled: " + rolls + "\nTotal damage: " + Dmg + " / 2 = " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                } else {
                    rollResults = "Rolling save..." + saveThrow + " fails! \nYou rolled: " + rolls + "\nTotal damage: " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                }

                System.out.print(rollResults);
                break;
            default:
                rollResults = "me.Bazza491.DungeonsLibrary.Attack type not valid";
                System.out.println(rollResults);
        }

    }

    public int damage() {
        int totalDmg = 0;
        String rolls = "";
        boolean attackHits = false;
        int timesToRoll = this.dieVolume;
        int theRollToHit = this.d20.roll() + this.attackBonus;
        String rollResults;
        int saveThrow;
        int roll;
        switch(this.attackType) {
            case WEAPON:
                for(saveThrow = this.numOfAttacks; saveThrow > 0; --saveThrow) {
                    if (theRollToHit > targetAC) {
                        roll = (int)(Math.random() * (double)this.dieType) + 1;
                        rolls = rolls + theRollToHit + " hits for " + (roll + this.dmgBonus) + " damage ";
                        totalDmg = totalDmg + roll + this.dmgBonus;
                    } else {
                        rolls = rolls + theRollToHit + " misses ";
                    }

                    theRollToHit = this.d20.roll() + this.attackBonus;
                }

                rollResults = "Rolling... \nYour rolls: " + rolls + " \nTotal damage: " + totalDmg + " damage\n" + this.otherEffects;
                System.out.println(rollResults);
                return totalDmg;
            case RANGED_SPELL:
                theRollToHit = this.d20.roll();
                if (theRollToHit > targetAC) {
                    attackHits = true;
                }

                if (attackHits) {
                    while(timesToRoll > 0) {
                        roll = (int)(Math.random() * (double)this.dieType) + 1;
                        totalDmg += roll;
                        rolls = rolls + roll + " ";
                        --timesToRoll;
                    }
                }

                if (!attackHits) {
                    rollResults = "Rolling to hit..." + theRollToHit + " Misses";
                } else {
                    rollResults = "Rolling to hit... " + theRollToHit + " Hits! \nYou rolled: " + rolls + "\nTotal damage: " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                }

                System.out.print(rollResults);
                return totalDmg;
            case SAVE_SPELL:
                saveThrow = this.d20.roll() + saveProficiency;
                if (saveThrow < this.spellSaveDC) {
                    attackHits = true;
                }

                while(timesToRoll > 0) {
                    roll = (int)(Math.random() * (double)this.dieType) + 1;
                    totalDmg += roll;
                    rolls = rolls + roll + " ";
                    --timesToRoll;
                }

                if (!attackHits) {
                    int Dmg = totalDmg;
                    totalDmg /= 2;
                    rollResults = "Rolling save..." + saveThrow + " succeeds \nYou rolled: " + rolls + "\nTotal damage: " + Dmg + " / 2 = " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                } else {
                    rollResults = "Rolling save..." + saveThrow + " fails! \nYou rolled: " + rolls + "\nTotal damage: " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                }

                System.out.print(rollResults);
                return totalDmg;
            default:
                rollResults = "me.Bazza491.DungeonsLibrary.Attack type not valid";
                System.out.println(rollResults);
                return 0;
        }
    }

    public void attackMonster(Monster monster) {
        System.out.println("Rolling to hit " + monster.getName());
        targetAC = monster.getAC();
        saveProficiency = monster.getProfMod();
        monster.dealDamage(this.damage(), this.damageType);
    }

    public void attackMonster(Monster target, int removeLater) {
        int totalDmg = 0;
        String rolls = "";
        boolean attackHits = false;
        int timesToRoll = this.dieVolume;
        int roll;
        String rollResults;
        int theRollToHit;
        int saveThrow;
        switch(this.attackType) {
            case WEAPON:
                for(saveThrow = this.numOfAttacks; saveThrow > 0; --saveThrow) {
                    theRollToHit = this.d20.roll() + this.attackBonus;
                    if (theRollToHit > target.getAC()) {
                        roll = (int)(Math.random() * (double)this.dieType) + 1;
                        rolls = rolls + theRollToHit + " hits for " + (roll + this.dmgBonus) + " damage ";
                        totalDmg = totalDmg + roll + this.dmgBonus;
                    } else {
                        rolls = rolls + theRollToHit + " misses ";
                    }
                }

                rollResults = "Rolling... \nYour rolls: " + rolls + " \nTotal damage: " + totalDmg + " damage\n" + this.otherEffects;
                System.out.println(rollResults);
                break;
            case RANGED_SPELL:
                theRollToHit = this.d20.roll();
                if (theRollToHit > targetAC) {
                    attackHits = true;
                }

                if (attackHits) {
                    while(timesToRoll > 0) {
                        roll = (int)(Math.random() * (double)this.dieType) + 1;
                        totalDmg += roll;
                        rolls = rolls + roll + " ";
                        --timesToRoll;
                    }
                }

                if (!attackHits) {
                    rollResults = "Rolling to hit..." + theRollToHit + " Misses";
                } else {
                    rollResults = "Rolling to hit... " + theRollToHit + " Hits! \nYou rolled: " + rolls + "\nTotal damage: " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                }

                System.out.print(rollResults);
                break;
            case SAVE_SPELL:
                saveThrow = this.d20.roll() + saveProficiency;
                if (saveThrow < this.spellSaveDC) {
                    attackHits = true;
                }

                while(timesToRoll > 0) {
                    roll = (int)(Math.random() * (double)this.dieType) + 1;
                    totalDmg += roll;
                    rolls = rolls + roll + " ";
                    --timesToRoll;
                }

                if (!attackHits) {
                    int Dmg = totalDmg;
                    totalDmg /= 2;
                    rollResults = "Rolling save..." + saveThrow + " succeeds \nYou rolled: " + rolls + "\nTotal damage: " + Dmg + " / 2 = " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                } else {
                    rollResults = "Rolling save..." + saveThrow + " fails! \nYou rolled: " + rolls + "\nTotal damage: " + totalDmg + this.damageType + " damage\n" + this.otherEffects;
                }

                System.out.print(rollResults);
                break;
            default:
                rollResults = "me.Bazza491.DungeonsLibrary.Attack type not valid";
                System.out.println(rollResults);
        }

    }

    public void print() {
        switch(this.attackType) {
            case HIT:
                System.out.println("Name: " + this.attackName + "\nDamage: " + this.dieVolume + "D" + this.dieType + " + " + this.dmgBonus + "\nTo hit: +" + this.attackBonus + "\nDamage type: " + this.damageType + "\nOther Effects: " + this.otherEffects);
            case SAVE:
                System.out.println("Name: " + this.attackName + "\nDamage: " + this.dieVolume + "D" + this.dieType + "\nSpell save DC: " + this.spellSaveDC + "\nDamage type: " + this.damageType + "\nOther Effects: " + this.otherEffects);
            default:
                System.out.println("me.Bazza491.DungeonsLibrary.Attack me.Bazza491.DungeonsLibrary.Type not valid");
        }
    }

    public static void setTargetAC(int targetAC) {
        Attack.targetAC = targetAC;
    }

    public static int getTargetAC() {
        return targetAC;
    }

    public static void setSaveProficiency(int saveProficiency) {
        Attack.saveProficiency = saveProficiency;
    }

    public static int getSaveProficiency() {
        return saveProficiency;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public String getAttackName() {
        return this.attackName;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() {
        return this.attackBonus;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public AttackType getAttackType() {
        return this.attackType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public DamageType getDamageType() {
        return this.damageType;
    }

    public void setDieType(int dieType) {
        this.dieType = dieType;
    }

    public int getDieType() {
        return this.dieType;
    }

    public void setDieVolume(int dieVolume) {
        this.dieVolume = dieVolume;
    }

    public int getDieVolume() {
        return this.dieVolume;
    }

    public void setDmgBonus(int dmgBonus) {
        this.dmgBonus = dmgBonus;
    }

    public int getDmgBonus() {
        return this.dmgBonus;
    }

    public void setNumOfAttacks(int numOfAttacks) {
        this.numOfAttacks = numOfAttacks;
    }

    public int getNumOfAttacks() {
        return this.numOfAttacks;
    }

    public void setOtherEffects(String otherEffects) {
        this.otherEffects = otherEffects;
    }

    public String getOtherEffects() {
        return this.otherEffects;
    }

    public void setSpellSaveDC(int spellSaveDC) {
        this.spellSaveDC = spellSaveDC;
    }

    public int getSpellSaveDC() {
        return this.spellSaveDC;
    }
}



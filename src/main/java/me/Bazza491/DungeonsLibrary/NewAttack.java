package me.Bazza491.DungeonsLibrary;

public abstract class NewAttack {
    protected String attackName;
    protected int dieType;
    protected DamageType damageType;
    protected String otherEffects;

    protected NewAttack (String attackName, int dieType, DamageType damageType, String otherEffects) {
        this.attackName = attackName;
        this.dieType = dieType;
        this.damageType = damageType;
        this.otherEffects = otherEffects;
    }
}

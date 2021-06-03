package me.Bazza491.DungeonsLibrary;



public interface CombatEntity {

    /**
     * Returns the current HP of the Entity
     */
    int getHp();

    /**
     * Sets the HP of the Entity
     * This should check that the Entity is not dead or unconscious and (optionally) Should not be able to set HP above
     * maxHP
     *
     * This should not be used to deal damage to the Entity, this is solely for specific abilities/spells that set an
     * Entities HP to a specific value, such as returning to 1 hit points after regaining consciousness.
     */

    void setHp(int hp);
    /**
     * Subtracts hp from this.hp and checks that the Entity is not dead or unconscious.
     *
     * if entity is dead, HP should equal 0 or null, and isDead should be set to false.
     */
    void dealDamage(int damage);
    /**
     * Checks if the Entities list of vulnerabilities, resistances or immunities contains the DamageType then subtracts
     * hp from the entities HP. Then, it finally checks that the Entity is not dead or unconscious.
     * TODO add death & unconsciousness rules
     * if entity is dead, HP should equal 0 or null, and isDead should be set to true. If entity is unconscious the
     * isUnconscious should be set to true and HP should equal 0.
     */
    void dealDamage(int damage, DamageType damageType);
    /**
     * Resets the entities relevant resources etc. to their default amounts. HP is set to the max HP, spell slots are
     * re-filled, etc.
     */
    void reset();


    /*
    TODO - complete interface
    Interface must include methods that get all stats used
     */


}

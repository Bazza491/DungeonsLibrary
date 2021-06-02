package me.Bazza491.DungeonsLibrary;

import java.util.ArrayList;
import java.util.List;

enum AbilityScore {
    STRENGTH("strength"),
    DEXTERITY("dexterity"),
    CONSTITUTION("constitution"),
    INTELLIGENCE("intelligence"),
    WISDOM("wisdom"),
    CHARISMA("charisma"),
    NA("N/A");

    private final String string;

    private AbilityScore(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
enum Alignment {
    LAWFUL_GOOD,
    NEUTRAL_GOOD,
    CHAOTIC_GOOD,
    LAWFUL_NEUTRAL,
    TRUE_NEUTRAL,
    CHAOTIC_NEUTRAL,
    LAWFUL_EVIL,
    NEUTRAL_EVIL,
    CHAOTIC_EVIL,
    NA;

    private Alignment() {
    }
}
enum AttackType {
    HIT,
    SAVE,
    WEAPON,
    RANGED_SPELL,
    SAVE_SPELL,
    NA;

    private AttackType() {
    }
}
enum Coin {
    PP("platinum pieces"),
    GP("gold pieces"),
    EP("electrum pieces"),
    SP("silver pieces"),
    CP("copper pieces");

    private final String string;

    private Coin(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
enum DamageType {
    ACID("acid"),
    BLUDGEONING("bludgeoning"),
    COLD("cold"),
    FIRE("fire"),
    FORCE("force"),
    LIGHTNING("lightning"),
    NECROTIC("necrotic"),
    PIERCING("piercing"),
    POISON("poison"),
    PSYCHIC("psychic"),
    RADIANT("radiant"),
    SLASHING("slashing"),
    THUNDER("thunder"),
    NA("N/A");

    private final String string;

    private DamageType(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
enum Language {
    COMMON,
    DWARVISH,
    ELVISH,
    GIANT,
    GNOMISH,
    GOBLIN,
    HALFLING,
    ORC,
    ABYSSAL,
    CELESTIAL,
    DRACONIC,
    DEEP_SPEECH,
    INFERNAL,
    PRIMORDIAL,
    SYLVAN,
    UNDERCOMMON,
    NA;

    private Language() {
    }
}
enum SaveThrow {
    STRENGTH("strength"),
    DEXTERITY("dexterity"),
    CONSTITUTION("constitution"),
    INTELLIGENCE("intelligence"),
    WISDOM("wisdom"),
    CHARISMA("charisma"),
    DEATH("death"),
    NA("N/A");

    private final String string;

    private SaveThrow(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
enum Size {
    TINY,
    SMALL,
    MEDIUM,
    LARGE,
    HUGE,
    GARGANTUAN,
    NA;

    private Size() {
    }
}
enum Type {
    ABERRATION,
    BEAST,
    CELESTIAL,
    CONSTRUCT,
    DRAGON,
    ELEMENTAL,
    FEY,
    FIEND,
    GIANT,
    HUMANOID,
    MONSTROSITY,
    OOZE,
    PLANT,
    UNDEAD,
    NA;

    private Type() {
    }
}

enum Weapon {
    CLUB("club", 1, Coin.SP, 4, DamageType.BLUDGEONING, 2.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.LIGHT}),
    DAGGER("dagger", 2, Coin.GP, 4, DamageType.PIERCING, 1.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.FINESSE, WeaponProperty.LIGHT, WeaponProperty.THROWN, WeaponProperty.RANGE}),
    GREATCLUB("greatclub", 2, Coin.SP, 8, DamageType.BLUDGEONING, 10.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.TWO_HANDED}),
    HANDAXE("handaxe", 5, Coin.GP, 2, DamageType.SLASHING, 6.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.LIGHT, WeaponProperty.THROWN, WeaponProperty.RANGE}),
    JAVELIN("javelin", 5, Coin.SP, 6, DamageType.PIERCING, 2.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.THROWN, WeaponProperty.RANGE}),
    LIGHT_HAMMER("", 2, Coin.GP, 4, DamageType.BLUDGEONING, 2.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.LIGHT, WeaponProperty.THROWN, WeaponProperty.RANGE}),
    MACE("mace", 5, Coin.GP, 6, DamageType.BLUDGEONING, 4.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.NA}),
    QUARTERSTAFF("quarterstaff", 2, Coin.SP, 6, DamageType.BLUDGEONING, 4.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.VERSATILE}),
    SICKLE("sickle", 1, Coin.GP, 4, DamageType.SLASHING, 2.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.LIGHT}),
    SPEAR("spear", 1, Coin.GP, 6, DamageType.PIERCING, 3.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.THROWN, WeaponProperty.VERSATILE}),
    CROSSBOW_LIGHT("crossbow_light", 25, Coin.GP, 8, DamageType.PIERCING, 5.0F, WeaponType.SIMPLE_RANGED, false, new WeaponProperty[]{WeaponProperty.AMMUNITION, WeaponProperty.LOADING, WeaponProperty.TWO_HANDED}),
    DART("dart", 5, Coin.CP, 4, DamageType.PIERCING, 0.25F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.FINESSE, WeaponProperty.THROWN, WeaponProperty.RANGE}),
    SHORTBOW("shortbow", 25, Coin.GP, 6, DamageType.PIERCING, 2.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.AMMUNITION, WeaponProperty.RANGE, WeaponProperty.TWO_HANDED}),
    SLING("sling", 1, Coin.SP, 4, DamageType.BLUDGEONING, 0.0F, WeaponType.SIMPLE_MELEE, false, new WeaponProperty[]{WeaponProperty.AMMUNITION, WeaponProperty.RANGE}),
    BATTLEAXE("battleaxe", 10, Coin.GP, 8, DamageType.SLASHING, 4.0F, WeaponType.MARTIAL_MELEE, false, new WeaponProperty[]{WeaponProperty.VERSATILE}),
    FLAIL("flail", 10, Coin.GP, 8, DamageType.BLUDGEONING, 2.0F, WeaponType.MARTIAL_MELEE, false, new WeaponProperty[]{WeaponProperty.NA}),
    GLAIVE("glaive", 20, Coin.GP, 10, DamageType.SLASHING, 6.0F, WeaponType.MARTIAL_MELEE, false, new WeaponProperty[]{WeaponProperty.HEAVY, WeaponProperty.REACH, WeaponProperty.TWO_HANDED}),
    GREATAXE("greataxe", 30, Coin.GP, 12, DamageType.SLASHING, 7.0F, WeaponType.MARTIAL_MELEE, false, new WeaponProperty[]{WeaponProperty.HEAVY, WeaponProperty.TWO_HANDED}),
    GREATSWORD("greatsword", 50, Coin.GP, 6, DamageType.SLASHING, 6.0F, WeaponType.MARTIAL_MELEE, true, new WeaponProperty[]{WeaponProperty.HEAVY, WeaponProperty.TWO_HANDED}),
    HALBERD("halberd", 20, Coin.GP, 10, DamageType.SLASHING, 6.0F, WeaponType.MARTIAL_MELEE, false, new WeaponProperty[]{WeaponProperty.TWO_HANDED, WeaponProperty.HEAVY, WeaponProperty.REACH}),
    LANCE("lance", 10, Coin.GP, 12, DamageType.PIERCING, 6.0F, WeaponType.MARTIAL_MELEE, false, new WeaponProperty[]{WeaponProperty.REACH, WeaponProperty.SPECIAL}),
    LONGSWORD("longsword", 15, Coin.GP, 8, DamageType.SLASHING, 3.0F, WeaponType.MARTIAL_MELEE, false, new WeaponProperty[]{WeaponProperty.VERSATILE}),
    MAUL("maul", 10, Coin.GP, 6, DamageType.BLUDGEONING, 10.0F, WeaponType.MARTIAL_MELEE, true, new WeaponProperty[]{WeaponProperty.TWO_HANDED, WeaponProperty.HEAVY});

    private final String name;
    private final int cost;
    private final Coin coin;
    private final int dieType;
    private final float weight;
    private final DamageType damageType;
    private final WeaponType weaponType;
    private final boolean is2d6;
    final List<WeaponProperty> propertiesList;

    private Weapon(String name, int cost, Coin coin, int dieType, DamageType damageType, float weight, WeaponType weaponType, boolean is2d6, WeaponProperty... property) {
        this.name = name;
        this.cost = cost;
        this.coin = coin;
        this.dieType = dieType;
        this.weight = weight;
        this.damageType = damageType;
        this.weaponType = weaponType;
        this.is2d6 = is2d6;
        this.propertiesList = new ArrayList(1);

        for(int index = 0; index < property.length; ++index) {
            this.propertiesList.add(property[index]);
        }

    }
}
enum WeaponProperty {
    AMMUNITION("ammunition"),
    FINESSE("finesse"),
    HEAVY("heavy"),
    LIGHT("light"),
    LOADING("loading"),
    RANGE("range"),
    REACH("reach"),
    SPECIAL("special"),
    THROWN("thrown"),
    TWO_HANDED("two-handed"),
    VERSATILE("versatile"),
    NA("N/A");

    private final String string;

    private WeaponProperty(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
enum WeaponType {
    SIMPLE_MELEE("simple melee weapon"),
    SIMPLE_RANGED("simple ranged weapon"),
    MARTIAL_MELEE("martial melee weapon"),
    MARTIAL_RANGED("martial ranged weapon");

    private final String string;

    private WeaponType(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}

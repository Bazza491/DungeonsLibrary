package me.Bazza491.DungeonsLibrary;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private String name;
    private Size size;
    private Type type;
    private Alignment alignment;
    private int ac;
    private int maxHP;
    private int hp;
    private int tempHP;
    private int speed;
    private ArrayList otherSpeeds = new ArrayList();
    private StatBlock stats;
    private List<SaveThrow> saveThrowProfs = new ArrayList(7);
    private ArrayList skills = new ArrayList();
    private int profMod;
    private List<DamageType> vulnerable = new ArrayList(13);
    private List<DamageType> immune = new ArrayList(13);
    private List<DamageType> resist = new ArrayList(13);
    private ArrayList senses = new ArrayList();
    private List<Language> languages = new ArrayList(16);
    private int challenge;
    private boolean isAlive;
    private Attack[] attacks;
    private int amountOfAttacks = 0;

    public Monster(String name, Size size, Type type, Alignment alignment, int ac, int maxHP, int speed, String otherSpeeds, int str, int dex, int con, int intel, int wis, int cha, SaveThrow saveThrowProfs, String skills, int proficiencyModifier, DamageType vulnerable, DamageType immune, DamageType resist, String senses, Language languages, int challenge) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.alignment = alignment;
        this.ac = ac;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.speed = speed;
        this.otherSpeeds.add(otherSpeeds);
        this.stats = new StatBlock(str, dex, con, intel, wis, cha);
        this.saveThrowProfs.add(saveThrowProfs);
        this.skills.add(skills);
        this.profMod = proficiencyModifier;
        this.vulnerable.add(vulnerable);
        this.immune.add(immune);
        this.resist.add(resist);
        this.senses.add(senses);
        this.languages.add(languages);
        this.challenge = challenge;
        this.isAlive = true;
    }

    public Monster(String name, int ac, int maxHP, int str, int dex, int con, int intel, int wis, int cha, SaveThrow saveThrowProfs, DamageType vulnerable, DamageType immune, DamageType resist, int challenge) {
        this.name = name;
        this.ac = ac;
        this.maxHP = maxHP;
        this.stats = new StatBlock(str, dex, con, intel, wis, cha);
        this.saveThrowProfs.add(saveThrowProfs);
        this.vulnerable.add(vulnerable);
        this.immune.add(immune);
        this.resist.add(resist);
        this.challenge = challenge;
        this.isAlive = true;
    }

    public void dealDamage(int damageDealt) {
        if (this.tempHP > 0) {
            damageDealt -= this.tempHP;
            if (damageDealt < 0) {
                this.tempHP = -damageDealt;
                damageDealt = 0;
            }
        }

        this.hp -= damageDealt;
        if (this.hp <= 0) {
            this.isAlive = false;
        }

    }

    public void dealDamage(int damageDealt, DamageType damageType) {
        if (this.vulnerable.contains(damageType)) {
            damageDealt *= 2;
        }

        if (this.resist.contains(damageType)) {
            damageDealt /= 2;
        }

        if (this.immune.contains(damageType)) {
            damageDealt = 0;
        }

        if (this.tempHP > 0) {
            damageDealt -= this.tempHP;
            if (damageDealt < 0) {
                this.tempHP = -damageDealt;
                damageDealt = 0;
            }
        }

        this.hp -= damageDealt;
        if (this.hp <= 0) {
            this.isAlive = false;
        }

    }

    public void healDamage(int damageHealed) {
        this.hp += damageHealed;
        if (this.hp > this.maxHP) {
            this.hp = this.maxHP;
        }

    }

    public void GiveTempHP(int tempHP) {
        this.tempHP += tempHP;
    }

    public void addAttack(Attack attack) {
        if (this.amountOfAttacks == 0) {
            this.attacks = new Attack[5];
        }

        this.attacks[this.amountOfAttacks] = attack;
        ++this.amountOfAttacks;
    }

    public int getProfMod() {
        return this.profMod;
    }

    public void setProfMod(int profMod) {
        this.profMod = profMod;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public int getAC() {
        return this.ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getTempHP() {
        return this.tempHP;
    }

    public void setTempHP(int tempHP) {
        this.tempHP = tempHP;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStr() {
        return this.stats.getStr();
    }

    public void setStr(int str) {
        this.stats.setStr(str);
    }

    public int getDex() {
        return this.stats.getDex();
    }

    public void setDex(int dex) {
        this.stats.setDex(dex);
    }

    public int getCon() {
        return this.stats.getCon();
    }

    public void setCon(int con) {
        this.stats.setCon(con);
    }

    public int getIntel() {
        return this.stats.getIntel();
    }

    public void setIntel(int intel) {
        this.stats.setIntel(intel);
    }

    public int getWis() {
        return this.stats.getWis();
    }

    public void setWis(int wis) {
        this.stats.setWis(wis);
    }

    public int getCha() {
        return this.stats.getCha();
    }

    public void setCha(int cha) {
        this.stats.setCha(cha);
    }

    public int getChallenge() {
        return this.challenge;
    }

    public void setChallenge(int challenge) {
        this.challenge = challenge;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void addOtherSpeed(String otherSpeed) {
        this.otherSpeeds.add(otherSpeed);
    }

    public void addSaveThrowProf(SaveThrow saveThrowProf) {
        this.saveThrowProfs.add(saveThrowProf);
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public void addVulnerability(DamageType vulnerability) {
        this.vulnerable.add(vulnerability);
    }

    public void addImmunity(DamageType immunity) {
        this.immune.add(immunity);
    }

    public void addResistance(DamageType resistance) {
        this.resist.add(resistance);
    }

    public void addSense(String sense) {
        this.senses.add(sense);
    }

    public void addLanguage(Language language) {
        this.languages.add(language);
    }
}


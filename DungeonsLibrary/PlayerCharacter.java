package me.Bazza491.DungeonsLibrary;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter {
    private String name;
    private String race;
    private String theClass;
    private String alignment1;
    private String alignment2;
    private int ac;
    private int maxHP;
    private int hp;
    private int tempHP;
    private int speed;
    private ArrayList otherSpeeds = new ArrayList();
    private int str;
    private int dex;
    private int con;
    private int intel;
    private int wis;
    private int cha;
    private List<SaveThrow> saveThrowProfs = new ArrayList();
    private ArrayList skills = new ArrayList();
    private int profMod;
    private ArrayList senses = new ArrayList();
    private List<Language> languages = new ArrayList(16);
    private int level;
    private boolean isUnconscious;
    private boolean isAlive;
    private Attack[] attacks = new Attack[50];
    private int amountOfAttacks = 0;

    public PlayerCharacter(String name, String race, String theClass, String alignment1, String alignment2, int ac,
                           int maxHP, int hp, int tempHP, int speed, String otherSpeeds, int str, int dex, int con,
                           int intel, int wis, int cha, SaveThrow saveThrowProfs, String skills,
                           int proficiencyModifier, String senses, Language languages, int level) {
        this.name = name;
        this.race = race;
        this.theClass = theClass;
        this.alignment1 = alignment1;
        this.alignment2 = alignment2;
        this.ac = ac;
        this.maxHP = maxHP;
        this.hp = hp;
        this.tempHP = tempHP;
        this.speed = speed;
        this.otherSpeeds.add(otherSpeeds);
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intel = intel;
        this.wis = wis;
        this.cha = cha;
        this.saveThrowProfs.add(saveThrowProfs);
        this.skills.add(skills);
        this.profMod = proficiencyModifier;
        this.senses.add(senses);
        this.languages.add(languages);
        this.level = level;
    }
}


package me.Bazza491.DungeonsLibrary;

public class Die {
    private int faces;
    private int timesRolled;
    private static int diceRolled = 0;

    public Die(int faces) {
        this.faces = faces;
    }

    public int r() {
        ++diceRolled;
        ++this.timesRolled;
        return (int)(Math.random() * (double)this.faces) + 1;
    }
}

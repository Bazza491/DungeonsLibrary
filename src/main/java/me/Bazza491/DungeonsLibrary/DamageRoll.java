package me.Bazza491.DungeonsLibrary;

public class DamageRoll {
    private int dieType;
    private int dieVolume;

    public DamageRoll () {

    }
    public void setDamageRoll (String damageRoll) {
        int dPos = 0;
        String letter = "Temp";

        while (!letter.equals("d")) {
            dPos++;
            letter = damageRoll.substring(dPos, dPos + 1);

            if (dPos >= damageRoll.length()) {
                break;
            }
        }
        String theDieVolume = damageRoll.substring(0, dPos);
        dieVolume = Integer.parseInt(theDieVolume);

        String theDieType = damageRoll.substring(dPos + 1);
        dieType = Integer.parseInt(theDieType);
    }

    public int getDieType() {
        return dieType;
    }

    public int getDieVolume() {
        return dieVolume;
    }
    public static int dt (String damageRoll) {
        int dPos = 0;
        String letter = "Temp";

        while (!letter.equals("d")) {
            dPos++;
            letter = damageRoll.substring(dPos, dPos + 1);

            if (dPos >= damageRoll.length()) {
                break;
            }
        }

        String theDieType = damageRoll.substring(dPos + 1);

        return Integer.parseInt(theDieType);
    }
    public static int dv (String damageRoll) {
        int dPos = 0;
        String letter = "Temp";

        while (!letter.equals("d")) {
            dPos++;
            letter = damageRoll.substring(dPos, dPos + 1);

            if (dPos >= damageRoll.length()) {
                break;
            }
        }
        String theDieVolume = damageRoll.substring(0, dPos);

        return Integer.parseInt(theDieVolume);
    }
}

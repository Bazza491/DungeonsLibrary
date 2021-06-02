package me.Bazza491.DungeonsLibrary;

public class Wallet {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


        private int pp;
        private int gp;
        private int ep;
        private int sp;
        private int cp;

        public Wallet() {
            this.pp = 0;
            this.gp = 0;
            this.ep = 0;
            this.sp = 0;
            this.cp = 0;
        }

        public Wallet(int pp, int gp, int ep, int sp, int cp) {
            this.pp = pp;
            this.gp = gp;
            this.ep = ep;
            this.sp = sp;
            this.cp = cp;
        }

        public Wallet(int[] coins) {
            if (coins.length == 5) {
                this.pp = coins[0];
                this.gp = coins[1];
                this.ep = coins[2];
                this.sp = coins[3];
                this.cp = coins[4];
            }
        }

        public Wallet(int startingGP) {
            this.pp = 0;
            this.gp = startingGP;
            this.ep = 0;
            this.sp = 0;
            this.cp = 0;
        }

        public void earn(int amount, Coin type) {
            System.out.println("--Earning " + amount + " " + type.getString() + "-- \n");
            switch(type) {
                case PP:
                    this.pp += amount;
                    break;
                case GP:
                    this.gp += amount;
                    break;
                case EP:
                    this.ep += amount;
                    break;
                case SP:
                    this.sp += amount;
                    break;
                case CP:
                    this.cp += amount;
            }

        }

        public void lose(int amount, Coin type) {
            System.out.println("--losing " + amount + " " + type.getString() + "-- \n");
            int tempPP = this.pp;
            int tempGP = this.gp;
            int tempEP = this.ep;
            int tempSP = this.sp;
            int tempCP = this.cp;
            switch(type) {
                case PP:
                    tempPP = this.pp - amount;
                    break;
                case GP:
                    tempGP = this.gp - amount;
                    break;
                case EP:
                    tempEP = this.ep - amount;
                    break;
                case SP:
                    tempSP = this.sp - amount;
                    break;
                case CP:
                    tempCP = this.cp - amount;
            }

            if (tempCP < 0) {
                tempSP += tempCP / 10 - 1;
                tempCP = 10 - Math.abs(tempCP % 10);
            }

            if (tempSP < 0) {
                tempGP += tempSP / 10 - 1;
                tempSP = 10 - Math.abs(tempSP % 10);
            }

            if (tempEP < 0) {
                tempGP += tempEP / 2 - 1;
                tempEP = 5 - Math.abs(tempEP % 5);
            }

            if (tempGP < 0) {
                tempPP += tempGP / 10 - 1;
                tempGP = 10 - Math.abs(tempGP % 10);
            }

            if (tempPP < 0) {
                System.out.println("Funds insufficient in " + this.toString() + "'s transaction, withdrawal could not be completed.");
            } else {
                this.pp = tempPP;
                this.gp = tempGP;
                this.ep = tempEP;
                this.sp = tempSP;
                this.cp = tempCP;
            }

            this.clean();
        }

        public void print() {
            System.out.println("me.Bazza491.DungeonsLibrary.Wallet Contents: ");
            System.out.println("Platinum pieces: " + this.pp);
            System.out.println("Gold pieces: " + this.gp);
            System.out.println("Electrum pieces: " + this.ep);
            System.out.println("Silver pieces: " + this.sp);
            System.out.println("Copper pieces: " + this.cp + "\n");
        }

        public void breakCoin(Coin type, int amount) {
            System.out.println("Breaking " + amount + " " + type.getString() + " into smaller coins");
            switch(type) {
                case PP:
                    if (this.pp >= amount) {
                        this.pp -= amount;
                        this.gp += amount * 10;
                    }
                    break;
                case GP:
                    if (this.gp >= amount) {
                        this.gp -= amount;
                        this.sp += amount * 10;
                    }
                    break;
                case EP:
                    if (this.ep >= amount) {
                        this.ep -= amount;
                        this.sp += amount * 5;
                    }
                    break;
                case SP:
                    if (this.sp >= amount) {
                        this.sp -= amount;
                        this.cp += amount * 10;
                    }
                    break;
                case CP:
                    System.out.println("Failed - Copper coins cannot be broken \n");
                    return;
                default:
                    System.out.println("Failed - Invalid coin type \n");
                    return;
            }

            System.out.println("Success! \n");
        }

        public void clean() {
            if (this.cp == 10) {
                this.cp = 0;
                ++this.sp;
            }

            if (this.sp == 10) {
                this.sp = 0;
                ++this.gp;
            }

            if (this.ep == 5) {
                this.ep = 0;
                ++this.gp;
            }

            if (this.gp == 10) {
                this.gp = 0;
                ++this.pp;
            }

        }

        public int getPP() {
            return this.pp;
        }

        public int getGP() {
            return this.gp;
        }

        public int getEP() {
            return this.ep;
        }

        public int getSP() {
            return this.sp;
        }

        public int getCP() {
            return this.cp;
        }


}

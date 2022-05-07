package gruppe8.backend;

import java.util.ArrayList;

public class Vagt {
    public static enum Tider { //0=morgen=8-12 -> 1=eftermiddag=12-16 -> 2=aften=16-20
        morgen,
        middag,
        aften;

        // n must be 0, 1 or 2.
        protected static Tider getTid(int n) {
            switch (n) {
                case 0:
                    return morgen;
                case 1:
                    return middag;
                default:
                    return aften;
            }
        }
    }

    public static enum Dage {
        mandag, //0
        tirsdag, //1
        onsdag, //2
        torsdag, //3
        fredag, //4
        lørdag, //5
        søndag; //6

        public static Dage getDag(int i) {
            if (0 <= i && i < 7) {
                if (i == 0) {
                    return mandag;
                } else if (i == 1) {
                    return tirsdag;
                } else if (i == 2) {
                    return onsdag;
                } else if (i == 3) {
                    return torsdag;
                } else if (i == 4) {
                    return fredag;
                } else if (i == 5) {
                    return lørdag;
                } else {
                    return søndag;
                }
            } else {
                return null;
            }
        }
    }

    public Tider tidsrum;
    public Dage dag;
    ArrayList<Integer> personIdList = new ArrayList<>();

    public Vagt(Tider tidspunkt, Dage dag) {
        this.tidsrum = tidspunkt;
        this.dag = dag;
    }

    @Override
    public String toString(){
        return  dag +" "+ tidsrum;
    }
}
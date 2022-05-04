package gruppe8.backend;

public class Vagt {
    int[] tidsArray = {0,1,2}; //0=morgen=8-12 -> 1=eftermiddag=12-16 -> 2=aften=16-20

    int tidsrum;
    Bod bod;
    Frivillig frivillig;

    public Vagt(Frivillig person, Bod bod, int tidspunkt) {
        try {
            this.tidsrum = tidspunkt;
            this.bod = bod;
            this.frivillig = person;
        } catch (ArrayIndexOutOfBoundsException){


        }
    }
}

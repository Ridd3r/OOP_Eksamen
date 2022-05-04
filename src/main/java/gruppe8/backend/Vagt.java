package gruppe8.backend;

public class Vagt {
    public static enum Tider { //0=morgen=8-12 -> 1=eftermiddag=12-16 -> 2=aften=16-20
        morgen,
        middag,
        aften};
    public static enum Dage {
        mandag, //0
        tirsdag, //1
        onsdag, //2
        torsdag, //3
        fredag, //4
        lørdag, //5
        søndag; //6
    }

    Tider tidsrum;
    Dage dag;
    Bod bod;
    Frivillig frivillig;

    public Vagt(Frivillig person, Bod bod, Tider tidspunkt, Dage dag) {
            this.tidsrum = tidspunkt;
            this.bod = bod;
            this.frivillig = person;
            this.dag = dag;
    }


    @Override
    public String toString() {
        String s = "Beskrivelse af vagt\n\n" +
                "Person: " + frivillig.getFirstName() + " " + frivillig.getLastName() + "\n" +
                "Bod: " + bod.getNavn() + "\n";

        if(dag == Dage.mandag) {
            s = s + "Dag: mandag\n";
        } else if (dag == Dage.tirsdag) {
            s = s + "Dag: tirsdag\n";
        } else if(dag == Dage.onsdag) {
            s = s + "Dag: onsdag\n";
        } else if(dag == Dage.torsdag) {
            s = s + "Dag: torsdag\n";
        } else if (dag == Dage.fredag) {
            s = s + "Dag: fredag\n";
        } else if (dag == Dage.lørdag) {
            s = s + "Dag: lørdag\n";
        } else {
            s = s + "Dag: søndag\n";
        }

        if(tidsrum == Tider.morgen) {
            s = s + "Tidspunkt: 8 - 12 \n";
        } else if (tidsrum == Tider.middag) {
            s = s + "Tidspunkt: 12 - 16\n";
        } else {
            s = s + "Tidspunkt: 16 - 20\n";
        }
        return s;
    }
}

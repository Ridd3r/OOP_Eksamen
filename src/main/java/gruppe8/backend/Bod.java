package gruppe8.backend;

import java.util.ArrayList;

public class Bod {
    //---------- constructor ------------------------
    public Bod(String navn) {
        this.navn = navn;
        fillArray();
    }

    //---------- fields -------------------
    private String navn;
    public ArrayList<Vagt> vagtArray = new ArrayList<>();
    public static DataHandlerFrivillig frivillig;




    // ----------- Methods -----------------

    public void fillArray() {
        for (int i = 0; i < Vagt.Dage.values().length; i++) {
            for (int n = 0; n < Vagt.Tider.values().length; n++) {
                Vagt vagt = new Vagt(Vagt.Tider.getTid(n), Vagt.Dage.getDag(i));
                vagtArray.add(vagt);
            }
        }
    }

    public void addFrivilligToVagt(int vagtNr, int id) {
        vagtArray.get(vagtNr).personIdList.add(id);
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public static void setFrivillig(DataHandlerFrivillig writerF) {
        frivillig = writerF;
    }

    public ArrayList<Integer> getVagter(int id) {
        ArrayList<Integer> vagtnr = new ArrayList<>();
        for (int n = 0; n < vagtArray.size(); n++) {
            for (int c = 0; c < vagtArray.get(n).personIdList.size(); c++) {
                if (vagtArray.get(n).personIdList.get(c) == id) {
                    vagtnr.add(n);
                }
            }
        }
        return vagtnr;
    }

    @Override
    public String toString() {
        String s = "Navn: " + navn + "\n";
        for (int i = 0; i < vagtArray.size(); i++) {
            s = s + "\n  " + vagtArray.get(i).toString() + " ";
            for (int n = 0; n < vagtArray.get(i).personIdList.size(); n++) {
                int id = vagtArray.get(i).personIdList.get(n);
                s = s + "\n    " + frivillig.getFrivillig(id).toString();
            }

        }
        return s;
    }

}

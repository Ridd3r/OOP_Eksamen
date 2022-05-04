package gruppe8.backend;

public class Bod {

    private String navn;
    private int alderskrav = 0;
    private String beskrivelse = "Ingen beskrivelse angivet";

    public Bod (String navn) {
        this.navn = navn;
    }
    public Bod (String navn, int alder) { this.navn = navn; this.alderskrav = alder;}
    public Bod (String navn, int alder, String beskrivelse) {
        this.navn = navn;
        this.alderskrav = alder;
        this.beskrivelse = beskrivelse;
    }

    public void setAlderskrav(int alder) {
        this.alderskrav = alder;
    }
    public int getAlderskrav() {
        return alderskrav;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    public String getNavn() {
        return navn;
    }

    public void setBeskrivelse(String nyBeskrivelse) {
        this.beskrivelse = nyBeskrivelse;
    }
    public String getBeskrivelse(){return beskrivelse; }

    @Override
    public String toString() {
        String bod = "Navn: " + navn + "\n" +
                "Alderskrav: " + "aar" + "\n" +
                "Beskrivelse: " + beskrivelse;
                return bod;
    }

}

package gruppe8.backend;

import java.io.*;
import java.util.ArrayList;

public class DataHandlerBod {
    BufferedWriter out;
    BufferedReader in;
    static String filePath = "src/main/java/gruppe8/Boder.txt";
    private final ArrayList<Bod> dataArrayBod = new ArrayList<>();


    //opens default file "Boder" and stores the data in dataArray
    public void openFile() {
        try {
            in = new BufferedReader(new FileReader(filePath));
            makeDataArray(); //dataArray SKAL laves før new FileWriter bliver opretter, fordi fileWriter overskriver filen med en ny og tom fil
            out = new BufferedWriter(new FileWriter(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Will write dataArray to text file before closing. Adding Test Admin to the end of the list.

    public void closeFile() {
        try {
            for (int i = 0; i < dataArrayBod.size(); i++) {
                String s = "";
                s = s + dataArrayBod.get(i).getNavn();
                for (int n = 0; n < dataArrayBod.get(i).vagtArray.size(); n++) {
                    s = s + ",";
                    for (int c = 0; c < dataArrayBod.get(i).vagtArray.get(n).personIdList.size(); c++) {
                        if (c > 0) s += " ";
                        s = s + dataArrayBod.get(i).vagtArray.get(n).personIdList.get(c);
                    }
                }
                s = s + "\n";
                out.write(s);
            }

            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*Reads the text file into the arrayList of boder
    Får en mærkelig fejl hvis den sidste frivillige i arrayListen har en alder som slutter på 0. fx 20 eller 30
     */
    private void makeDataArray() {
        try {
            String line;
            line = in.readLine();
            while (line != null) {
                String[] lines = line.split(",");
                Bod bod = new Bod(lines[0]);
                for (int i = 1; i < lines.length; i++) { //i starter på 1 for at springe navnet over så står på plads 0.
                    String[] dataFrivillig = lines[i].split(" ");
                    for (int n = 0; n < dataFrivillig.length; n++) {
                        if (!dataFrivillig[n].equals("")) {
                            int id = Integer.parseInt(dataFrivillig[n]);
                            bod.addFrivilligToVagt(i-1, id); //Fordi i startede på 1 og ikke 0, er i højere end den skal være til dette formål
                        }
                    }
                }
                dataArrayBod.add(bod);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataArrayBod.sort((f1, f2) -> {
            return f1.getNavn().compareToIgnoreCase(f2.getNavn()); //Den her sammenligning skal gerne give en int som er >=< end 0.
        });

    }

    //Add bod to dataArray - not file.
    public void addBod(String name) {
        Bod bod = new Bod(name);
        dataArrayBod.add(bod);
    }

    //Sletter match. Ignorere kun store/små bogstaver
    public void sletBod(String name) {
        int slettet = 0;
        for (int i = 0; i < dataArrayBod.size(); ) {
            if (dataArrayBod.get(i).getNavn().equalsIgnoreCase(name)) {
                dataArrayBod.remove(i);
                ++slettet;
            } else {
                i++;
            }
        }
        System.out.println("Slettet antal boder: " + slettet);
    }

    //return a string describing Frivillige who's first or lastname matches name
    //Søg efter "signe" eller "olsen" ikke "signe olsen"
    public String findBod(String name) {
        String names = "";
        ArrayList<Bod> personArray = searchArray(name);
        for (Bod bod : personArray) {
            names = names + bod.toString() + "\n";
        }
        if (names.equals("")) {
            return "Intet match";
        } else {
            return "Personer som matcher søgeord: \n\n" + names;
        }
    }

    //Printer alle frivillige i dataArray
    public String visAlleBoder() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < dataArrayBod.size(); i++) {
            list.append(dataArrayBod.get(i).getNavn()+"\n");
        }
        if (list.toString().equals("")) {
            return "Ingen frivillige blev fundet.";
        } else {
            return "Frivillige: \n\n" + list;
        }
    }

    //changes the first bod matching "bodToChange"
    public void changeBod(String bodToChange, String name) {
        int index = 0;
        for (int i = 0; i < dataArrayBod.size(); i++) {
            if (dataArrayBod.get(i).getNavn().equalsIgnoreCase(bodToChange)) {
                index = i;
                Bod bod = new Bod(name);
                bod.setNavn(name);
                dataArrayBod.set(index, bod);
                break; //Kun den første -> så break
            }
        }

    }

    public Bod getBod(int index) {
        return dataArrayBod.get(index);
    }

    /*Returns ArrayList containing all boder which name includes the searchWord or letter.
    It is possible to search with spaces ex; "kebab hut". */
    private ArrayList<Bod> searchArray(String name) {
        ArrayList<Bod> nameList = new ArrayList<>();
        String[] parts = name.split(" "); //Hvis name fx er "Pizza bod" så oprettes string[] pizza og bod
        for (int i = 0; i < dataArrayBod.size(); i++) {
            boolean b = true; //Som udgangspunkt antager vi at der er søgt rigtigt
            for (int j = 0; j < parts.length; j++) {
                if (!parts[j].equals("")) { //Er det et mellemrum så søger vi ikke længere
                    if (!dataArrayBod.get(i).getNavn().toLowerCase().contains(parts[j].toLowerCase())) { //findes det i navnet så tilføjes bod
                        b = false;
                    }
                }
            }
            if (b) nameList.add(dataArrayBod.get(i));
        }
        return nameList;
    }

    public String getVagt(int id, int vagtnr) {
        String vagt = "";
        for (int b = 0; b < dataArrayBod.size(); b++) {{
                if(!dataArrayBod.get(b).vagtArray.get(vagtnr).personIdList.isEmpty()){
                    vagt = vagt + dataArrayBod.get(b).getNavn();
                }
            }
        }

        return vagt;
    }
}

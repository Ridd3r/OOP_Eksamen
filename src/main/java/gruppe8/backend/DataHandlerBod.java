package gruppe8.backend;

import java.io.*;
import java.util.ArrayList;

public class DataHandlerBod {
    BufferedWriter out;
    BufferedReader in;
    static String filePath = "src/main/java/gruppe8/Boder.txt";
    private final ArrayList<Bod> dataArray = new ArrayList<>();

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
            for (int i = 0; i < dataArray.size(); i++) {
                if (!dataArray.get(i).getNavn().equals("Test")) { //Spring Test over så den ikke bliver dubleret
                    out.write(dataArray.get(i).getNavn() +
                            "," + dataArray.get(i).getAlderskrav() +
                            "," + dataArray.get(i).getBeskrivelse() +
                            "\n"); // start næste bod på næste linje
                }
            }
            out.write("Test,666,Denne bod er en test >:D"); //Tilføj Test som sidste i listen.
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
            do {
                line = in.readLine();
                if (line != null) {
                    String[] lines = line.split(",");
                    int alderskrav = Integer.parseInt(lines[1]);
                    Bod bod = new Bod(lines[0]);
                    bod.setAlderskrav(alderskrav);
                    bod.setBeskrivelse(lines[2]);
                    dataArray.add(bod);
                }
            }
            while (line != null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        dataArray.sort((f1, f2) -> {
                return f1.getNavn().compareToIgnoreCase(f2.getNavn()); //Den her sammenligning skal gerne give en int som er >=< end 0.
        });

    }

    //Add bod to dataArray - not file.
    public void addBod(String name) {
        Bod bod = new Bod(name);
        dataArray.add(bod);
    }
    public void addBod(String name, int alder) {
        Bod bod = new Bod(name);
        bod.setAlderskrav(alder);
        dataArray.add(bod);
    }
    public void addBod(String name, int alder, String beskrivelse) {
        Bod bod = new Bod(name);
        bod.setAlderskrav(alder);
        bod.setBeskrivelse(beskrivelse);
    }

   //Sletter match. Ignorere kun store/små bogstaver
    public void sletBod(String name) {
        int slettet = 0;
        for(int i = 0; i < dataArray.size();) {
            if(dataArray.get(i).getNavn().equalsIgnoreCase(name)) {
                dataArray.remove(i);
                ++slettet;
            } else {
                i++;
            }
        }
        System.out.println("Slettet antal boder: "+ slettet);
    }

    //return a string describing Frivillige who's first or lastname matches name
    //Søg efter "signe" eller "olsen" ikke "signe olsen"
    public String findBod(String name) {
        String names = "";
        ArrayList<Bod> personArray = searchArray(name);
        for (Bod bod : personArray) {
            names = names + bod.toString() + "\n\n";
        }
        if (names.equals("")) {
            return "Intet match";
        } else {
            return "Personer som matcher søgeord: \n\n" + names;
        }
    }

    //Printer alle frivillige i dataArray
    public String visAlle() {
        StringBuilder list = new StringBuilder();
        for (Bod bod : dataArray) {
            list.append(bod.toString()).append("\n\n");
        }
        if (list.toString().equals("")) {
            return "Ingen frivillige blev fundet.";
        } else {
            return "Frivillige: \n\n" + list;
        }
    }

    //changes the first bod matching "bodToChange"
   public void changeBod(String bodToChange, String name, int alder, String beskrivelse) {
       int index = 0;
       for(int i = 0; i < dataArray.size(); i++) {
           if(dataArray.get(i).getNavn().equalsIgnoreCase(bodToChange)) {
               index = i;
               Bod bod = new Bod(name);
               bod.setBeskrivelse(beskrivelse);
               bod.setNavn(name);
               bod.setAlderskrav(alder);
               dataArray.set(index, bod);
               break; //Kun den første -> så break
           }
       }

    }

    public Bod getBod(int index){
        return dataArray.get(index);
    }

    /*Returns ArrayList containing all boder which name includes the searchWord or letter.
    It is possible to search with spaces ex; "kebab hut". */
    private ArrayList<Bod> searchArray(String name) {
        ArrayList<Bod> nameList = new ArrayList<>();
        String[] parts = name.split(" "); //Hvis name fx er "Pizza bod" så oprettes string[] pizza og bod
        for (int i = 0; i < dataArray.size(); i++) {
            boolean b = true; //Som udgangspunkt antager vi at der er søgt rigtigt
            for (int j = 0; j < parts.length; j++) {
                if (!parts[j].equals("")) { //Er det et mellemrum så søger vi ikke længere
                    if (!dataArray.get(i).getNavn().toLowerCase().contains(parts[j].toLowerCase())) { //findes det i navnet så tilføjes bod
                            b = false;
                    }
                }
            }
            if (b) nameList.add(dataArray.get(i));
        }
        return nameList;
    }

}

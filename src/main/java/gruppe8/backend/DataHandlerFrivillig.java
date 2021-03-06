package gruppe8.backend;

import java.io.*;
import java.util.ArrayList;

/* Ideen er, at DataHandler skal instantieres og bruges for at kunne læse/tilføje/ændre på de frivillige.
Der for er ArrayList private, så jeg vi er sikre på at kun funktionerne herinde kan påvirke listen.
Det er pænt vigtigt at listen kun bliver påvirket på måder vi har kontrolleret, da "databasen" i praksis er = listen
 */
public class DataHandlerFrivillig {
    BufferedWriter out;
    BufferedReader in;
    static String filePath = "src/main/java/gruppe8/Frivillige.txt";
    public final ArrayList<Frivillig> dataArray = new ArrayList<>();
    public String tempFirstName = "";
    public String tempLastName = "";
    public Integer tempId;


    //opens default file "Frivillige" and stores the data in dataArray
    public void openFile() {
        try {
            in = new BufferedReader(new FileReader(filePath));
            makeDataArray(); //dataArray SKAL laves før new FileWriter bliver opretter, fordi fileWriter overskriver filen med en ny og tom fil
            out = new BufferedWriter(new FileWriter(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Will write dataArray to text file before closing.
     */
    public void closeFile() {
        try {
            for (int i = 0; i < dataArray.size(); i++) {
                    out.write(dataArray.get(i).getID() +
                            "," + dataArray.get(i).getFirstName() +
                            "," + dataArray.get(i).getLastName() +
                            "," + dataArray.get(i).getAge() +
                            "," + dataArray.get(i).getPhoneNumber() +
                            "," + dataArray.get(i).getEmail() + "\n");
                }

            out.flush();
            out.close();
            dataArray.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*Reads the text file into the arrayList of Frivillige
    Får en mærkelig fejl hvis den sidste frivillige i arrayListen har en alder som slutter på 0. fx 20 eller 30
     */
    private void makeDataArray() {
        try {
            String line;
            do {
                line = in.readLine();
                if (line != null) {
                    String[] lines = line.split(",");
                    int id = Integer.parseInt(lines[0]);
                    int age = Integer.parseInt(lines[3]);
                    int number = Integer.parseInt(lines[4]);
                    Frivillig person = new Frivillig(id, lines[1], lines[2], age, number, lines[5]);
                    dataArray.add(person);
                }
            }
            while (line != null);

        } catch (IOException e) {
            e.printStackTrace();
        }


        dataArray.sort((f1, f2) -> {
            int c = f1.getFirstName().compareToIgnoreCase(f2.getFirstName());
            if (c == 0) {
                return f1.getLastName().compareToIgnoreCase(f2.getLastName());
            } else {
                return c;
            }
        });
    }

    //kunne måske return boolean value, så man har mulighed for at tjekke om en person blev tilføjet.
    //Add a person to dataArray - not file.
    //Jacob edit -> Tilføjet handler så der kan skrives til filen også
    public void addFrivillig(String firstName, String lastName, int age, int number, String mail) {
        int id = 0;
        for(int i = 0; i < dataArray.size(); i++){
            if(dataArray.get(i).getID() > id) id = dataArray.get(i).getID();
        }
        id++;
        Frivillig person = new Frivillig(id, firstName, lastName, age, number, mail);
        dataArray.add(person);
    }

    public void sletFrivillig(String firstName, String lastName) { //Funktionalitet ikke indført - Virker i consol men ikke GUI
        int slettet = 0;
        for (int i = 0; i < dataArray.size(); ) {
            if (dataArray.get(i).getFirstName().equalsIgnoreCase(firstName) && dataArray.get(i).getLastName().equalsIgnoreCase(lastName)) {
                dataArray.remove(i);
                ++slettet;
            } else {
                i++;
            }
        }
    }

    public Frivillig getFrivillig(int id) {
        for (int i = 0; i < dataArray.size(); i++) {
            if (dataArray.get(i).getID() == id) {
                return dataArray.get(i);
            }
        }
        return dataArray.get(0);
    }

    //return a string describing Frivillige who's first or lastname matches name
    //Søg efter "signe" eller "olsen" ikke "signe olsen"
    public String findFrivillig(String name) {
        String names = "";
        ArrayList<Frivillig> personArray = searchArrayAlternativ(name);
        for (Frivillig person : personArray) {
            names = names + person.toString() + "\n\n";
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
        for (Frivillig person : dataArray) {
            list.append(person.toString()).append("\n");
        }
        if (list.toString().equals("")) {
            return "Ingen frivillige blev fundet.";
        } else {
            return "Frivillige: \n" + list;
        }
    }

    public StringBuilder visAlleNavne() {
        StringBuilder list = new StringBuilder();
        for (Frivillig person : dataArray) {
            list.append(person.getFirstName() + " ").append(person.getLastName()).append(",");
        }
        return list;
    }

    public void changeFrivillig(int index, String firstName, String lastName, int age, int number, String mail) {
        Frivillig person = new Frivillig(firstName, lastName, age, number, mail);
        dataArray.set(index, person);
    }

    /*Returns ArrayList containing all frivillige who's first or lastName includes the searchword or letter.
    It is possible to search with spaces ex; "Lars larsen" as the name, og "Signe L".
     */

    private ArrayList<Frivillig> searchArrayAlternativ(String name) {
        ArrayList<Frivillig> nameList = new ArrayList<>();
        String[] parts = name.split(" "); //Hvis name fx er "Signe Larsen" så oprettes string[] Signe og Larsen.
        for (int i = 0; i < dataArray.size(); i++) {
            boolean b = true; //Som udgangspunkt antager vi at der er søgt rigtigt
            for (int j = 0; j < parts.length; j++) {
                if (!parts[j].equals("")) { //Er det et mellemrum så søger vi ikke længere
                    if (!dataArray.get(i).getFirstName().toLowerCase().contains(parts[j].toLowerCase())) { //findes det i fornavn så tilføjes frivillig
                        if (!dataArray.get(i).getLastName().toLowerCase().contains(parts[j].toLowerCase())) { //Findes det hverken i for eller efternavn, tilføjes frivillig ikke
                            b = false;
                        }
                    }
                }
            }
            if (b) nameList.add(dataArray.get(i));
        }
        return nameList;
    }

    public void setTempFirstName(String a) {
        tempFirstName = a;
    }

    public void setTempLastName(String b) {
        tempLastName = b;
    }

    public String getTempFirstName(String a) {
        return tempFirstName;
    }

    public String getTempLastName(String b) {
        return tempLastName;
    }

    public void setTempId(Integer a){
        tempId = a;
    }

}
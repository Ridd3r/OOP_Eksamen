package gruppe8.backend;

public class Main {
    public static void main(String[] args) {
        // write your code here
        DataHandlerBod writerB = new DataHandlerBod();
        DataHandlerFrivillig writerF = new DataHandlerFrivillig();
        writerF.openFile();
        writerB.openFile();

        //writerB.setCurrentBod();

        System.out.println(writerF.visAlleNavne());
        //System.out.println(writerF.getFrivillig(9).getFirstName());

        //System.out.println(writerB.getVagt(9, 0) + "\n");
        //System.out.println(writerB.getVagt(9, 1) + "\n");
        //System.out.println(writerB.getVagt(9, 2) + "\n");

        //Vagt test = new Vagt(morgen, Vagt.Dage.onsdag);

        //Frivillig firstElement = writerF.dataArray.get(4);
        //System.out.println(firstElement);


        //Bod.setFrivillig(writerF);
        //System.out.println(writerB.getVagt(1,1));

        //Dette kald tilføjer korrekt med ID - Fejl ligger i GUI Kald
        //writerF.addFrivillig("Mickey", "Mouse", 46, 85374961, "Mickey@Mouse.dk");

        //Dette kald fungerer også her - men ikke i GUI kaldet
        //writerF.sletFrivillig("Mickey", "Mouse");
        //System.out.println(writerF.dataArray + "\n");

        //writerF.addFrivillig("Mickey", "Mouse", 46, 85374961, "Mickey@Mouse.dk");

        writerB.closeFile();
        writerF.closeFile();
    }
}

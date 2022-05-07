package gruppe8.backend;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // write your code here
        DataHandlerBod writerB = new DataHandlerBod();
        DataHandlerFrivillig writerF = new DataHandlerFrivillig();
        writerF.openFile();
        writerB.openFile();

        Bod.setFrivillig(writerF);
        //System.out.println(writerB.getBod(0)));
        System.out.println("hej :)))");

        System.out.println();



        writerB.closeFile();
        writerF.closeFile();


    }
}

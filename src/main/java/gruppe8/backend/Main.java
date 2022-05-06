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

        System.out.println(writerF.visAlle());

        writerB.closeFile();
        writerF.closeFile();


    }
}

package gruppe8.backend;

public class Main {
    public static void main(String[] args) {
        // write your code here
        DataHandlerBod writerB = new DataHandlerBod();
        DataHandlerFrivillig writerF = new DataHandlerFrivillig();
        writerF.openFile();
        writerB.openFile();
        Vagt vagt = new Vagt(writerF.getFrivillig(1),writerB.getBod(0), Vagt.Tider.middag, Vagt.Dage.fredag);
        System.out.println(vagt.toString());

        writerB.closeFile();
        writerF.closeFile();


    }
}

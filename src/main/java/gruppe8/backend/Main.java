package gruppe8.backend;

public class Main {
    public static void main(String[] args) {
        // write your code here
        DataHandlerFrivillig writer = new DataHandlerFrivillig();
        writer.openFile();

        //writer.addFrivillig("Sebastian","Ladegaard",29,27852291,"ladefod@gmail.com");
        System.out.println(writer.findFrivillig("lade"));
        writer.closeFile();

    }
}

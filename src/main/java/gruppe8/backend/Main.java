package gruppe8.backend;

public class Main {
    public static void main(String[] args) {
        // write your code here
        DataHandlerBod writer = new DataHandlerBod();
        writer.openFile();

        //writer.addFrivillig("Sebastian","Ladegaard",29,27852291,"ladefod@gmail.com");
        //writer.sletBod("test");
        System.out.println(writer.findBod("Test"));
        writer.changeBod("Test","Andersens Pølser",0,"Vi sælger det bedste pølser");
        System.out.println(writer.findBod("test"));
        writer.closeFile();


    }
}

package gruppe8.backend;

public class Frivillig {

    private int ID;
    private int age;
    private int phoneNumber;
    private String firstName;
    private String lastName;
    private String email;

    public Frivillig(String firstName, String lastName, int age, int number, String email) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = number;

    }

    protected Frivillig(int ID, String firstName, String lastName, int age, int number, String email) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = number;
        this.ID = ID;

    }


    public void setFirstName(String name) {
        this.firstName = name;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String name){
        this.firstName = name;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setPhoneNumber(int number) {this.phoneNumber = number;}
    public int getPhoneNumber() {return this.phoneNumber;}

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() { return this.email;}

    @Override
    public String toString() {
        String string = this.firstName + " " + this.lastName +
                ", Alder: " + this.age +
                ", tlf: " + this.phoneNumber +
                ", Email: " + this.email +
                ", ID: " + this.ID;
        return string;
    }

    public String getFrivilligString(){
        String s = "";
        s = s + firstName +
                " " + lastName +
                " " + age +
                " " + phoneNumber +
                " " + email;
        return s;
    }

    public int getID() {
        return ID;
    }
}
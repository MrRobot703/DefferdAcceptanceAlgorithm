package models;

public class Hospital extends Participant{

    public Hospital() {}

    public Hospital(String name) {
        super(name);
    }

    public Hospital(String name, int number) {
        super(name, number);
    }
}
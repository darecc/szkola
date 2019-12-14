package school;

public class Person {
    private String firstName;
    private  String lastName;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

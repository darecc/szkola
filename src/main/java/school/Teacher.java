package school;

import java.util.HashSet;

public class Teacher extends Person{
    public HashSet<String> getSubjectList() {
        return subjectList;
    }
    private HashSet<String> subjectList;
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        subjectList = new HashSet<String>();
    }
    public void addSubject(String subjectName) {
        subjectList.add(subjectName);
    }
    public boolean removeSubject(String subjectName) {
        boolean udaloSie = subjectList.remove(subjectName);
        return  udaloSie;
    }
    public boolean checkSubject(String subjectName) {
        return subjectList.contains(subjectName);
    }
}

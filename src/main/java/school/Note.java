package school;

public class Note {
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public double getNote() {
        return note;
    }

    private double note;
    public Note(String subjectName, double note) {
        this.subjectName = subjectName;
        this.note = note;
    }
}

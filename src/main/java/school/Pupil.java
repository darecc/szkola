package school;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pupil extends Person {
    private LocalDate birthDate;
    private List<Note> noteList;

    public List<Note> getNoteList() {
        return noteList;
    }
    public Pupil(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName);
        this.birthDate = birthDate;
        noteList = new ArrayList<>();
    }
    public String getFirstName() {
        return super.getFirstName();
    }
    public String getLastName() {
        return super.getLastName();
    }
    public void addNote(Note note) {
        noteList.add(note);
    }
    public void addNote(String subjectName, double note) {
        Note newNote = new Note(subjectName, note);
        noteList.add(newNote);
    }
}

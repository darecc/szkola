package school;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
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
    public double countAverageNote() {
        double suma = 0.0;
        for(Note note : noteList)
            suma += note.getNote();
        return suma/noteList.size();
    }
    public double countAverageNote(String subjectName)  {
        double suma = 0.0;
        double count = 0.0;
        for(Note note : noteList)
            if (note.getSubjectName().compareTo(subjectName) == 0) {
                suma += note.getNote();
                count++;
            }
        if (count == 0)
            return 0;
        return suma/count;
    }
    public HashSet<String> dajZbiorPrzedmiotowZKtorychMamOcene() {
        HashSet<String> set = new HashSet<>();
        for(Note note : noteList)
            set.add(note.getSubjectName());
        return set;
    }
    public boolean hasAnyNote(String subjectName) {
        for(Note note : noteList)
            if (note.getSubjectName().compareTo(subjectName) == 0)
                return true;
        return false;
    }
    public Pair<Pupil, Double> getPair(String subjectName) {
        Pair para = new Pair(this, this.countAverageNote(subjectName));
        return para;
    }
    public double getFirstNoteFromSubject(String subjectName) {
        for(Note note : noteList)
            if (note.getSubjectName().compareTo(subjectName) == 0)
                return note.getNote();
        return 0;
    }
}

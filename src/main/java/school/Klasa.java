package school;

import java.util.ArrayList;
import java.util.List;

public class Klasa {
    private static Klasa instancja = null;
    private List<Teacher> teachers;
    private List<Pupil> pupils;
    private List<Subject> subjects;
    private String className;
    private Klasa(String className) {
        this.className = className;
        teachers = new ArrayList<>();
        pupils = new ArrayList<>();
        subjects = new ArrayList<>();
    }
    public static Klasa getInstance(String className) {
        if (instancja == null)
            instancja = new Klasa(className);
        return instancja;
    }
    public void addPupil(Pupil pupil) {
        pupils.add(pupil);
    }
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
    public void addNote(Pupil pupil, String subjectName, double note) throws ClassException {
        boolean jest = false;
        for(Subject subject : subjects)
            if (subject.getSubjectName().compareTo(subjectName) == 0) {
                jest = true;
                break;
            }
        if (jest)
            pupil.addNote(subjectName, note);
        else
            throw  new ClassException("nie ma przedmiotu:" + subjectName);
    }
    public void addSubject(String subjectName) {
        subjects.add(new Subject(subjectName));
    }
    public void addSubject(String subjectName, Teacher teacher) {
        subjects.add(new Subject(subjectName, teacher));
    }
    public void addTeacherToSubjects() throws ClassException {
        for(Subject subject : subjects)
            if (subject.getTeacher() == null) {
                String nazwaPrzedmiotu = subject.getSubjectName();
                List<Teacher> kandydacieDOPrzedmiotu = new ArrayList<>();
                for(Teacher teacher : teachers)
                    if (teacher.checkSubject(nazwaPrzedmiotu))
                        kandydacieDOPrzedmiotu.add(teacher);
                if (kandydacieDOPrzedmiotu.size() == 0)
                    throw new ClassException("Nie ma nauczyciela dla :" + nazwaPrzedmiotu);
                int los = (int)(Math.random()*kandydacieDOPrzedmiotu.size());
                Teacher wybranyNauczyciel = kandydacieDOPrzedmiotu.get(los);
                subject.setTeacher(wybranyNauczyciel);
            }
    }
    public void showSubjects() {
        for(Subject subject : subjects)
            System.out.format("%12s nauczyciel: %-20s %n", subject.getSubjectName(), subject.getTeacher().toString());
    }
}

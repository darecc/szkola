package school;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
    public void addNote(Pupil pupil, Note note) throws ClassException {
        boolean jest = false;
        for(Subject subject : subjects)
            if (subject.getSubjectName().compareTo(note.getSubjectName()) == 0) {
                jest = true;
                break;
            }
        if (jest)
            pupil.addNote(note);
        else
            throw  new ClassException("nie ma przedmiotu:" + note.getSubjectName());
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
    public double calculateAverageNote(Pupil pupil) {
        return pupil.countAverageNote();
    }
    public double calculateAverageNote(String subjectName) throws  ClassException {
        double sum = 0;
        double count = 0;
        for(Pupil pupil : pupils)
            for(Note note : pupil.getNoteList())
                if (note.getSubjectName().compareTo(subjectName) == 0) {
                    sum += note.getNote();
                    count++;
                }
        if (count == 0)
            throw new ClassException("nie ma ocen z: " + subjectName);
        return sum/count;
    }
    /*
    public double calculateAverageNote(String subjectName, Type typ ) {
        if (typ == Type.stream) {
            try {
                double aver =
                        pupils
                                .stream()
                                .mapToDouble(p -> {
                                    OptionalDouble res = OptionalDouble.of(0);
                                    try {
                                        res =  OptionalDouble.of(p.countAverageNote(subjectName));
                                    }
                                    catch(Exception ex) {
                                        ex.printStackTrace();
                                    }
                                    return res;
                                })
                                .average();
                  .
            }
            catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    */
    public HashSet<String> getSubjectSet() {
        HashSet<String> set = new HashSet<>();
        for(Subject sub : subjects)
            set.add(sub.getSubjectName());
        return set;
    }
    public void showAbsentNotes(Pupil pupil) {
        HashSet<String> przedmiotyZOcenami = pupil.dajZbiorPrzedmiotowZKtorychMamOcene();
        HashSet<String> zbiorPrzedmiotow = this.getSubjectSet();
        zbiorPrzedmiotow.removeAll(przedmiotyZOcenami);
        if (zbiorPrzedmiotow.size() > 0) {
            System.out.println("=== PRZEDMIOTY Z KTÓRYCH UCZEŃ " + pupil.toString() + " NIE MA OCEN ===");
            for(String przedmiot : zbiorPrzedmiotow)
            System.out.println(przedmiot);
        }
    }
    public void showBestPupils(String subjectName) {
        List<Pupil> najlepsi =
                pupils
                .stream()
                .sorted((p1,p2) -> (int)(p2.countAverageNote(subjectName) - p1.countAverageNote(subjectName)))
                .limit(3)
                .collect(Collectors.toList());
                for(Pupil pupil : najlepsi)
                    System.out.format("%20s średnia: %.2f %n", pupil.toString(), pupil.countAverageNote(subjectName));

    }
}

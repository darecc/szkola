package school;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Klasa klasa = Klasa.getInstance("klasa przyrodnicza");

        //region wklepanie danych
        Pupil p0 = new Pupil("Janek", "Wiśniewski", LocalDate.of(2005, 2, 23));
        Teacher t0 = new Teacher("Tomasz", "Batko");
        t0.addSubject("matematyka");
        t0.addSubject("fizyka");
        Pupil p1 = new Pupil("Jan", "Nowak", LocalDate.of(2005, 5, 21));
        Pupil p2 = new Pupil("Anna", "Mucha", LocalDate.of(2003, 6, 11));
        Pupil p3 = new Pupil("Leon", "Czyżyk", LocalDate.of(2006, 7, 12));
        Pupil p4 = new Pupil("Olga", "Praska", LocalDate.of(2005, 8, 2));
        Pupil p5 = new Pupil("Sylwia", "Piątek", LocalDate.of(2005, 1, 22));
        List<Pupil> pupils = (List<Pupil>) Arrays.asList(new Pupil[] {p0, p1,p2,p3,p4,p5});

        klasa.addPupil(p1);
        klasa.addPupil(p2);
        klasa.addPupil(p3);
        klasa.addPupil(p4);
        klasa.addPupil(p5);
        klasa.addPupil(p0);
        Teacher t1 = new Teacher("Zenon", "Żyto");
        Teacher t2 = new Teacher("Dorota", "Nowakowska");
        Teacher t3 = new Teacher("Cecylia", "Ciesielska");
        Teacher t4 = new Teacher("Roman", "Dmowczyk");
        t1.addSubject("matematyka");
        t1.addSubject("fizyka");
        t1.addSubject("chemia");
        t1.addSubject("chemia");
        t1.addSubject("chemia");
        t1.addSubject("WF");
        t2.addSubject("język polski");
        t2.addSubject("język angielski");
        t2.addSubject("język niemiecki");
        t2.addSubject("historia");
        t3.addSubject("geografia");
        t3.addSubject("chemia");
        t3.addSubject("historia");
        t3.addSubject("religia");
        t4.addSubject("matematyka");
        t4.addSubject("fizyka");
        t4.addSubject("religia");
        t4.addSubject("język angielski");

        klasa.addTeacher(t1);
        klasa.addTeacher(t2);
        klasa.addTeacher(t3);
        klasa.addTeacher(t4);
        klasa.addSubject("język polski");
        klasa.addSubject("język angielski");
        klasa.addSubject("historia");
        klasa.addSubject("geografia");
        klasa.addSubject("matematyka");
        klasa.addSubject("fizyka");
        klasa.addSubject("chemia");
        klasa.addSubject("język francuski", t4);
        try {
            klasa.addNote(p1, new Note("matematyka", 4.5));
            klasa.addNote(p1, new Note("fizyka", 4.0));
            klasa.addNote(p1, new Note("chemia", 3.5));
            klasa.addNote(p1, new Note("geografia", 5.0));
            klasa.addNote(p1, new Note("historia", 3.0));
            klasa.addNote(p1, new Note("język polski", 2.0));
            klasa.addNote(p1, new Note("język angielski", 2.0));
            //klasa.addNote(p2, new Note("psychologia", 3.5));
            klasa.addNote(p2, new Note("fizyka", 3.0));
            klasa.addNote(p2, new Note("chemia", 2.5));
            klasa.addNote(p2, new Note("geografia", 3.0));
            klasa.addNote(p2, new Note("historia", 3.5));
            klasa.addNote(p2, new Note("język polski", 3.0));
            klasa.addNote(p2, new Note("język angielski", 4.0));
            klasa.addNote(p3, new Note("matematyka", 3.5));
            klasa.addNote(p3, new Note("fizyka", 3.0));
            klasa.addNote(p3, new Note("chemia", 3.5));
            klasa.addNote(p3, new Note("geografia", 2.0));
            klasa.addNote(p3, new Note("historia", 2.0));
            klasa.addNote(p3, new Note("język polski", 3.5));
            klasa.addNote(p3, new Note("język francuski", 3.5));
            klasa.addNote(p4, new Note("matematyka", 3.5));
            klasa.addNote(p4, new Note("fizyka", 4.5));
            klasa.addNote(p4, new Note("chemia", 4.5));
            klasa.addNote(p4, new Note("geografia", 4.0));
            klasa.addNote(p4, new Note("historia", 4.0));
            klasa.addNote(p4, new Note("język polski", 3.5));
            klasa.addNote(p4, new Note("język angielski", 4.0));
            klasa.addNote(p5, new Note("matematyka", 4.5));
            klasa.addNote(p5, new Note("fizyka", 5.0));
            klasa.addNote(p5, new Note("chemia", 4.5));
            klasa.addNote(p5, new Note("geografia", 4.5));
            klasa.addNote(p5, new Note("historia", 5.0));
            klasa.addNote(p5, new Note("język polski", 3.5));
            klasa.addNote(p5, new Note("język angielski", 4.0));
            klasa.addNote(p0, new Note("matematyka", 4.0));
        }
        catch(ClassException ce) {
            System.out.println(ce.getMessage());
        }
        //endregion

        try {
            klasa.addTeacherToSubjects();
            klasa.showSubjects();
        }
        catch(ClassException ce) {
            System.out.println(ce.getMessage());
        }
        klasa.showAbsentNotes(p1);
        klasa.showAbsentNotes(p0);
        System.out.println("Oceny z matematyki:");
        for(Pupil pupil : pupils)
            System.out.println(pupil.toString() + " " + pupil.countAverageNote("historia"));
        klasa.calculateAverageNote(p1);
        //klasa.showBestPupils("matematyka");
        HashSet<String> listaPrzedmiotów = klasa.getSubjectSet();
        for(String przedmiot : listaPrzedmiotów)
            klasa.showBestPupils(przedmiot);
        System.out.println("best 2");
        for(String przedmiot : listaPrzedmiotów)
            klasa.showBestPupils2(przedmiot);
    }
}

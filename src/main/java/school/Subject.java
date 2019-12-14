package school;

public class Subject {
    private String subjectName;
    private Teacher teacher;

    public String getSubjectName() {
        return subjectName;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.teacher = null;
    }
    public Subject(String subjectName, Teacher teacher) {
        this.subjectName = subjectName;
        this.teacher = teacher;
    }
}

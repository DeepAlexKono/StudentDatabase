package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
    private static final long serialVersionUID = -6156803196017856785L;
    private ArrayList<Student> studentList = new ArrayList<>();
    private int number;

    public Group() {
    }

    public Group(int number) {
        this.number = number;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addStudentToGroup(Student student) {
        studentList.add(student);
    }
}

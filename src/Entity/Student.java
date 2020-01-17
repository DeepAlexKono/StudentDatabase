package Entity;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 4476139245911547361L;
    private String name;
    private String lastName;
    private String patronymic;
    private String faculty;

    private int group;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object obj) {
        Student st = (Student) obj;
        return this.getName().equals(st.getName()) &&
                this.getLastName().equals(st.getLastName()) &&
                this.getPatronymic().equals(st.getPatronymic()) &&
                this.getFaculty().equals(st.getFaculty()) &&
                this.getGroup() == st.getGroup();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", faculty='" + faculty + '\'' +
                ", group=" + group +
                '}';
    }

    public Student(String name, String lastName, String patronymic, String faculty, int group) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.faculty = faculty;
        this.group = group;
    }
}

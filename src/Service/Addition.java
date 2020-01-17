package Service;

import Action.ConsoleApplication;
import Entity.Database;
import Entity.Faculty;
import Entity.Group;
import Entity.Student;
import Utility.ConsoleFileReader;
import Utility.ConsoleFileWriter;
import Utility.ConsoleWriter;

public class Addition {

    // The case when the Student is absolutely new (new Group, new Faculty).
    public static void addStudent(Student student) {
        Faculty faculty = Validation.checkFacultyExistence(student.getFaculty(), ConsoleApplication.getDatabase().getFacultyList());
        Group group;
        if (faculty != null) {
            group = Validation.checkGroupExistence(student.getGroup(), faculty);

            if (group != null) { // Если такой факультет и такая группа уже существует,
                // то просто добавить нового студента в существующую группу.
                group.addStudentToGroup(student);
            }
            else { // Если такой факультет уже существует, но группа новая,
                // то добавить на факультет новую группу и в неё записать нового студента
                group = new Group(student.getGroup());
                group.addStudentToGroup(student);

                faculty.addGroupToFaculty(group);
            }
        }
        else { // Если и факультет, и группа - новые,
            // то создать такие факультет и группу, записать в группу нового студента
            // и добавить полученную группу в новый факультет. Потом добавить новый факультет в бд
            group = new Group(student.getGroup());
            group.addStudentToGroup(student);

            faculty = new Faculty();
            faculty.addGroupToFaculty(group);

            ConsoleApplication.getDatabase().getFacultyList().add(faculty);
        }
        ConsoleFileWriter.writeObject(ConsoleApplication.getDatabase(), ConsoleApplication.getDatabaseFileName());
        ConsoleWriter.writeln("Successful write");
    }
}

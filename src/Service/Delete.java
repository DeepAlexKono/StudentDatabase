package Service;

import Action.ConsoleApplication;
import Entity.Faculty;
import Entity.Group;
import Entity.Student;
import Utility.ConsoleFileWriter;

import java.util.ArrayList;

public class Delete {
    public static boolean deleteStudent(Student student) {
        Faculty currentFaculty;
        Group currentGroup;
        Student currentStudent;
        ArrayList<Faculty> facultyList = ConsoleApplication.getDatabase().getFacultyList();

        for (int i = 0; i < facultyList.size(); i++) {
            currentFaculty = facultyList.get(i);
            for (int k = 0; k < currentFaculty.getGroupList().size(); k++) {
                currentGroup = currentFaculty.getGroupList().get(k);
                for (int j = 0; j < currentGroup.getStudentList().size(); j++) {
                    currentStudent = currentGroup.getStudentList().get(j);
                    if (student.equals(currentStudent))
                    {
                        currentGroup.getStudentList().remove(student);
                        if (currentGroup.getStudentList().size() == 0) currentFaculty.getGroupList().remove(currentGroup);
                        if (currentFaculty.getGroupList().size() == 0) ConsoleApplication.getDatabase().getFacultyList().remove(currentFaculty);
                        ConsoleFileWriter.writeObject(ConsoleApplication.getDatabase(), ConsoleApplication.getDatabaseFileName());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

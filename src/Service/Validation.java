package Service;

import Action.ConsoleApplication;
import Entity.Faculty;
import Entity.Group;
import Entity.Student;

import java.util.ArrayList;

public class Validation {
    public static int validate(Student student) {
        if(Validation.checkStudentDataErrors(student)) return 2;
        if (Validation.checkStudentExistance(student)) return 1;
        else return 0;
    }

    private static boolean checkStudentDataErrors(Student student) {
        if (student.getName().equals("") || student.getName() == null) return true;
        if (student.getLastName().equals("") || student.getLastName() == null) return true;
        if (student.getPatronymic().equals("") || student.getPatronymic() == null) return true;
        if (student.getFaculty().equals("") || student.getFaculty() == null) return true;
        if (student.getGroup() <= 0) return true;
        return false;
    }
    public static boolean checkStudentDataErrors(String name, String lastName, String patronymic) {
        if (name.equals("")) return true;
        if (lastName.equals("")) return true;
        if (patronymic.equals("")) return true;
        return false;
    }
    public static boolean checkStudentDataErrors(String faculty) {
        return faculty.equals("");
    }
    public static boolean checkStudentDataErrors(int group) {
        return group <= 0;
    }


    private static boolean checkStudentExistance(Student student) {
        ArrayList<Faculty> facultyList = ConsoleApplication.getDatabase().getFacultyList();
        Faculty existingFaculty = Validation.checkFacultyExistence(student.getFaculty(), facultyList);
        Group existingGroup;

        if (ConsoleApplication.getDatabase().getFacultyList().size() == 0) return false;

        if (existingFaculty != null) {
            existingGroup = Validation.checkGroupExistence(student.getGroup(), existingFaculty);
        }
        else return false;
        if (existingGroup != null) {
            String currentName;
            String currentLastName;
            String currentPatronymic;
            for (int i = 0; i < existingGroup.getStudentList().size(); i++) {
                currentName = existingGroup.getStudentList().get(i).getName();
                currentLastName = existingGroup.getStudentList().get(i).getLastName();
                currentPatronymic = existingGroup.getStudentList().get(i).getPatronymic();

                if (student.getName().equals(currentName) &&
                    student.getLastName().equals(currentLastName) &&
                    student.getPatronymic().equals(currentPatronymic) ) {

                    return true;
                }
            }
        }
        return false;
    }

    public static Faculty checkFacultyExistence(String faculty, ArrayList<Faculty> facultyList) {
        String currentFaculty;
        for (int i = 0; i < facultyList.size(); i++) {
            currentFaculty = facultyList.get(i).getGroupList().get(0).getStudentList().get(0).getFaculty();
            if (faculty.equals(currentFaculty)) {
                return facultyList.get(i);
            }
        }
        return null;
    }

    public static Group checkGroupExistence(int group, Faculty existingFaculty) {
        int currentGroup;
        for (int i = 0; i < existingFaculty.getGroupList().size(); i++) {
            currentGroup = existingFaculty.getGroupList().get(i).getNumber();
            if (group == currentGroup) {
                return existingFaculty.getGroupList().get(i);
            }
        }
        return null;
    }
}

package Service;

import Action.ConsoleApplication;
import Entity.Faculty;
import Entity.Group;
import Entity.Student;

import java.util.ArrayList;

public class Search {
    public static String search(String[] criteria) {
        return Search.searhBasis(criteria);
    }
    private static String searhBasis(String[] criteria) {
        Faculty currentFaculty;
        Group currentGroup;
        Student currentStudent;
        ArrayList<Faculty> facultyList = ConsoleApplication.getDatabase().getFacultyList();
        ArrayList<Student> studentList = new ArrayList<>();
        String returnedString = "";

        for (int i = 0; i < facultyList.size(); i++) {
            currentFaculty = facultyList.get(i);
            for (int k = 0; k < currentFaculty.getGroupList().size(); k++) {
                currentGroup = currentFaculty.getGroupList().get(k);
                for (int j = 0; j < currentGroup.getStudentList().size(); j++) {
                    currentStudent = currentGroup.getStudentList().get(j);
                    if (criteria.length > 1 && Search.searchByFIO(criteria[0], criteria[1], criteria[2], currentStudent))
                    {
                        studentList.add(currentStudent);
                    }
                    else try {
                        int groupNumber = Integer.parseInt(criteria[0]);
                        if (Search.searchByGroup(criteria[0], currentStudent)) studentList.add(currentStudent);
                    }
                    catch (Exception e) {
                        if (Search.searchByFaculty(criteria[0], currentStudent)) studentList.add(currentStudent);
                    }
                }
            }
        }
        for (int i = 0; i < studentList.size(); i++) {
            returnedString += studentList.get(i).toString() + "\n";
        }
        if (studentList.size() == 0) return null;
        return returnedString;
    }
    private static boolean searchByFIO(String name, String lastName, String patronymic, Student currentStudent) {
        if(name.equals(currentStudent.getName()) &&
                lastName.equals(currentStudent.getLastName()) &&
                patronymic.equals(currentStudent.getPatronymic())) return  true;
        return false;
    }

    private static boolean searchByFaculty(String faculty, Student currentStudent) {
        if(faculty.equals(currentStudent.getFaculty())) return true;
        return false;
    }

    private static boolean searchByGroup(String group, Student currentStudent) {
        int groupNumber = Integer.parseInt(group);
        if(groupNumber == currentStudent.getGroup()) return true;
        return false;
    }
}

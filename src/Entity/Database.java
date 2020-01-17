package Entity;

import Action.ConsoleApplication;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    private static final long serialVersionUID = -5752410365181030610L;

    private ArrayList<Faculty> facultyList = new ArrayList<>();

    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }

    @Override
    public String toString() {
        String databaseString = "";
        for (int i = 0; i < facultyList.size(); i++) {
            for (int j = 0; j < facultyList.get(i).getGroupList().size(); j++) {
                for (int k = 0; k < facultyList.get(i).getGroupList().get(j).getStudentList().size(); k++) {
                    databaseString += facultyList.get(i).getGroupList().get(j).getStudentList().get(k).toString();
                    databaseString += "\n";
                }
            }
        }
        return "Database{\n" +
                databaseString +
                '}';
    }
}
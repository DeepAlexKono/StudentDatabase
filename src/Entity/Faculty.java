package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Faculty implements Serializable {
    private static final long serialVersionUID = -860624472005873988L;
    private ArrayList<Group> groupList = new ArrayList<>();

    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void addGroupToFaculty(Group group) {
        groupList.add(group);
    }
}

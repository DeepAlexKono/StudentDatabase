package Service;

import Action.ConsoleApplication;
import Entity.Database;
import Utility.ConsoleFileReader;

public class ShowInfo {
    public static String showDatabase() {
        Database db = ConsoleFileReader.read(ConsoleApplication.getDatabaseFileName());
        return db.toString();
    }
}

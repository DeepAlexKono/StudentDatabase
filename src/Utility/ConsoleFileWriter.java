package Utility;

import Action.ConsoleApplication;
import Entity.Database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ConsoleFileWriter {
    public static void writeObject(Database database, String databaseFileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(databaseFileName));
            oos.writeObject(database);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

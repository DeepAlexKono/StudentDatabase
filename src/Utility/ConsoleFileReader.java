package Utility;

import Entity.Database;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ConsoleFileReader {

    public static Database read(String databaseFileName) {
        Database db = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(databaseFileName)))
        {
            db=(Database)ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return db;
    }
}

package Service;

import Action.ConsoleApplication;
import Utility.ConsoleFileReader;

import java.io.*;

public class Creation {
    public static void createFile() {
        File file = new File("./", ConsoleApplication.getDatabaseFileName());

        if(!file.exists()) {
            try {
                boolean created = file.createNewFile();
//                if (!created) System.out.println("File has not been created :(");
//                else System.out.println("File has been created :)");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
//            System.out.println("File already exists! :)");
            ConsoleApplication.setDatabase( ConsoleFileReader.read(ConsoleApplication.getDatabaseFileName()) );
        }
    }
}

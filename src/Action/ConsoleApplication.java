package Action;

import Entity.Database;
import Utility.ConsoleFileReader;
import Utility.ConsoleReader;
import Utility.Messages;

public class ConsoleApplication implements Application {
    boolean workFlag = true;
    private static Database database = new Database();
    private static final String databaseFileName = "database.txt";

    public static Database getDatabase() {
        return database;
    }
    public static String getDatabaseFileName() {
        return databaseFileName;
    }

    public static void setDatabase(Database database) {
        ConsoleApplication.database = database;
    }

    // Actions registration
    DatabaseAction databaseAction = new ConsoleDatabaseAction();

    public void run() {
        databaseAction.createDatabaseAction();

        Messages.showStartAppMessage();
        Messages.showGreetingMainMessage();
        String answer = "";
        while (workFlag) {
                Messages.showMainMenuMessage();
                Messages.showMainCommandsMessage();
                answer = ConsoleReader.readString();
                try {
                    CheckMenuAnswer(answer);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
        }

    }

    private void CheckMenuAnswer(String answer) throws Exception {
            if (answer.toLowerCase().equals("add")) {
                databaseAction.addStudentAction();
            }
            else if (answer.toLowerCase().equals("find")) {
                databaseAction.findStudentAction(); //
            }
            else if (answer.toLowerCase().equals("find fio")) {
                databaseAction.findStudentAction("fio");
            }
            else if (answer.toLowerCase().equals("find faculty")) {
                databaseAction.findStudentAction("faculty");
            }
            else if (answer.toLowerCase().equals("find group")) {
                databaseAction.findStudentAction("group");
            }
            else if(answer.toLowerCase().equals("delete")) {
                databaseAction.deleteStudentAction();
            }
            else if(answer.toLowerCase().equals("show")) {
                databaseAction.showDatabaseAction();
            }
            else if (answer.toLowerCase().equals("exit") ) {
                workFlag = false;
            }
            else  {
                throw new Exception("Ошибка ввода. Попробуйте ещё раз...");
            }
    }

}

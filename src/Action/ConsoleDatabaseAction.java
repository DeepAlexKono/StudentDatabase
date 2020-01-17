package Action;

import Entity.Student;
import Service.*;
import Utility.ConsoleReader;
import Utility.ConsoleWriter;
import Utility.Messages;

public class ConsoleDatabaseAction implements DatabaseAction {
    @Override
    public void addStudentAction() {
        boolean workFlag = true;

        String name = "";
        String lastName = "";
        String patronymic = "";
        String faculty = "";
        int group = 0;


        while(workFlag) {
            Messages.showAddNameMessage();
            name = ConsoleReader.readString();

            Messages.showAddLastNameMessage();
            lastName = ConsoleReader.readString();

            Messages.showAddPatronymicMessage();
            patronymic = ConsoleReader.readString();

            Messages.showAddFacultyMessage();
            faculty = ConsoleReader.readString();

            Messages.showAddGroupMessage();
            group = ConsoleReader.readInt();



            Student student = new Student(name, lastName, patronymic, faculty, group);
            switch (Validation.validate(student)) {
                case 0:
                    Addition.addStudent(student);
                    workFlag = false;
                    break;
                case 1:
                    Messages.showAlreadyExistMessage();
                    break;
                case 2:
                    Messages.showErrorCommandMessage();
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public void findStudentAction() {
        boolean workFlag = true;

        String name = "";
        String lastName = "";
        String patronymic = "";
        String faculty = "";
        int group = 0;
        while(workFlag) {
            Messages.showAddNameMessage();
            name = ConsoleReader.readString();

            Messages.showAddLastNameMessage();
            lastName = ConsoleReader.readString();

            Messages.showAddPatronymicMessage();
            patronymic = ConsoleReader.readString();

            Messages.showAddFacultyMessage();
            faculty = ConsoleReader.readString();

            Messages.showAddGroupMessage();
            group = ConsoleReader.readInt();

            Student student = new Student(name, lastName, patronymic, faculty, group);
            switch (Validation.validate(student)) {
                case 0:
                    Messages.showNotExistMessage();
                    workFlag = false;
                    break;
                case 1:
                    Messages.showExistMessage();
                    workFlag = false;
                    break;
                case 2:
                    Messages.showErrorCommandMessage();
                    break;
            }
        }
    }

    @Override
    public void findStudentAction(String criteria) {
        boolean workFlag = true;

        String name = "";
        String lastName = "";
        String patronymic = "";
        String faculty = "";
        String group = "";
        switch (criteria) {
            case "fio": {
                while(workFlag) {
                    Messages.showAddNameMessage();
                    name = ConsoleReader.readString();

                    Messages.showAddLastNameMessage();
                    lastName = ConsoleReader.readString();

                    Messages.showAddPatronymicMessage();
                    patronymic = ConsoleReader.readString();
                    if (Validation.checkStudentDataErrors(name, lastName, patronymic)) Messages.showErrorCommandMessage();
                    else workFlag = false;
                }
                String result = Search.search(new String[]{name, lastName, patronymic});
                if (result == null) Messages.showResultNotExistMessage();
                else Messages.showResultExistMessage(result);
                break;
            }
            case "faculty": {
                while(workFlag) {
                    Messages.showAddFacultyMessage();
                    faculty = ConsoleReader.readString();

                    if (Validation.checkStudentDataErrors(faculty)) Messages.showErrorCommandMessage();
                    else workFlag = false;
                }
                String result = Search.search(new String[]{faculty});
                if (result == null) Messages.showResultNotExistMessage();
                else Messages.showResultExistMessage(result);
                break;
            }
            case "group": {
                int groupNumber;
                while(workFlag) {
                    Messages.showAddGroupMessage();
                    group = ConsoleReader.readString();

                    groupNumber = Integer.parseInt(group);
                    if (Validation.checkStudentDataErrors(groupNumber)) Messages.showErrorCommandMessage();
                    else workFlag = false;
                }
                String result = Search.search(new String[]{group});
                if (result == null) Messages.showResultNotExistMessage();
                else Messages.showResultExistMessage(result);
                break;
            }

        }
    }

    @Override
    public void deleteStudentAction() {
        boolean workFlag = true;

        String name = "";
        String lastName = "";
        String patronymic = "";
        String faculty = "";
        int group = 0;
        while(workFlag) {
            Messages.showAddNameMessage();
            name = ConsoleReader.readString();

            Messages.showAddLastNameMessage();
            lastName = ConsoleReader.readString();

            Messages.showAddPatronymicMessage();
            patronymic = ConsoleReader.readString();

            Messages.showAddFacultyMessage();
            faculty = ConsoleReader.readString();

            Messages.showAddGroupMessage();
            group = ConsoleReader.readInt();

            Student student = new Student(name, lastName, patronymic, faculty, group);
            switch (Validation.validate(student)) {
                case 0:
                    Messages.showNotExistMessage();
                    workFlag = false;
                    break;
                case 1:
                    if (Delete.deleteStudent(student)) Messages.showSucDeleteMessage();
                    else Messages.showUnsucDeleteMessage();
                    workFlag = false;
                    break;
                case 2:
                    Messages.showErrorCommandMessage();
                    break;
            }
        }
    }

    @Override
    public void createDatabaseAction() {
        Creation.createFile();
    }

    @Override
    public void showDatabaseAction() {
        ConsoleWriter.writeln(ShowInfo.showDatabase());
    }
}

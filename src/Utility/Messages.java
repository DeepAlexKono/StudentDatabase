package Utility;

public class Messages {
    // ------------------------------------
    // APP MESSAGES
    public static void showStartAppMessage() {
        ConsoleWriter.writeln("Приложение запущенно...");
    }
    public static void showEndAppMessage() {
        ConsoleWriter.writeln("Приложение завершило работу.");
    }
    public static void showGreetingMainMessage() {
        ConsoleWriter.writeln("Добро пожаловать в Student Database Application!");
    }
    // ------------------------------------
    // MAIN MENU MESSAGES
    public static void showMainMenuMessage() {
        Messages.showLine();
        ConsoleWriter.writeln("ГЛАВНОЕ МЕНЮ");
        Messages.showLine();
    }
    // ------------------------------------
    // COMMANDS MESSAGES
    public static void showMainCommandsMessage() {
        ConsoleWriter.writeln("Доступные команды:");
        ConsoleWriter.writeln("[add] - добавить студента в базу данных");
        ConsoleWriter.writeln("[find] - проверить наличие студента в базе данных по ФИО, факультету и номеру группы");
        ConsoleWriter.writeln("[find FIO] - найти студента  по ФИО");
        ConsoleWriter.writeln("[find Faculty] - найти всех студентов по факультету");
        ConsoleWriter.writeln("[find Group] - найти всех студентов по группе");
        ConsoleWriter.writeln("[delete] - удалить студента из базы данных");
        ConsoleWriter.writeln("[show] - вывести всю базу данных");
        ConsoleWriter.writeln("[exit] - выйти из приложения");
    }
    // ------------------------------------
    // ADD MESSAGES
    public static void showAddNameMessage() {
        ConsoleWriter.write("Введите имя: ");
    }
    public static void showAddLastNameMessage() {
        ConsoleWriter.write("Введите фамилию: ");
    }
    public static void showAddPatronymicMessage() {
        ConsoleWriter.write("Введите отчество: ");
    }
    public static void showAddFacultyMessage() {
        ConsoleWriter.write("Введите факультет: ");
    }
    public static void showAddGroupMessage() {
        ConsoleWriter.write("Введите группу: ");
    }
    public static void showAlreadyExistMessage() { ConsoleWriter.writeln("Такой студент уже существует. Попробуйте ещё раз..."); }
    //-------------------------------------
    // SEARCH MESSAGES
    public static void showNotExistMessage() { ConsoleWriter.writeln("Такого студента не существует. Попробуйте ещё раз...");
    }
    public static void showExistMessage() { ConsoleWriter.writeln("Есть совпадение. Такой студент существует.");
    }
    public static void showResultExistMessage(String result) {
        ConsoleWriter.write("Совпадения найдены.\n" + result);
    }
    public static void showResultNotExistMessage() {
        ConsoleWriter.writeln("Совпадения не найдены.");
    }
    // ------------------------------------
    // DELETE MESSAGES
    public static void showSucDeleteMessage() { ConsoleWriter.writeln("Студент был успешно удалён."); }
    public static void showUnsucDeleteMessage() { ConsoleWriter.writeln("Произошла ошибка. попробуйте ещё раз..."); }
    // ------------------------------------
    // ERROR MESSAGES
    public static void showErrorCommandMessage() {
        ConsoleWriter.writeln("Ошибка ввода. Попробуйте ещё раз...");
    }
    // ------------------------------------
    // SUB-MESSAGES
    public static void showLine() {
        ConsoleWriter.writeln("------------------------");
    }
}

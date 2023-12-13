package notebook.util;

import java.io.File;

public class DBConnector {

    // метод для задания пути к файлу
    public static final String DB_PATH = "db.txt";
    // метод создания файла
    public static void createDB() {
        try {
            File db = new File(DB_PATH);
            if (db.createNewFile()) {
                System.out.println("Файл базы данных создан");
            }
            else {
                System.out.println("Файл базы данных уже существует");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}

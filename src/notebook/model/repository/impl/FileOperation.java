package notebook.model.repository.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import notebook.model.repository.Operation;

// Класс для работы с файлом
public class FileOperation implements Operation {
    private final String fileName;

    // Конструктор
    public FileOperation(String fileName) {
        this.fileName = fileName;
        // Проверка существования файла
        try (FileWriter writer = new FileWriter(fileName, true)) {
            // Запись в файл
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод для считывания данных из файла
    @Override
    public List<String> readAll() {
        //создаем список для считанных строк
        List<String> lines = new ArrayList<>();
        try {
            // открываем поток для чтения
            File file = new File(fileName);
            // создаем FileReader с указанием пути к файлу
            FileReader fr = new FileReader(file);
            // создаем BufferedReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем первую строку
            String line = reader.readLine();
            // если строка не пустая, то добавляем ее в список
            if (line != null) {
                lines.add(line);
            }
            // считываем остальные строки в цикле
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            // закрываем FileReader и BufferedReader
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // возвращаем список считанных строк
        return lines;
    }

    // Метод для записи данных в файл
    @Override
    public void saveAll(List<String> data) {
        // создаем объект для записи в файл
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : data) {
                // запись одной строки
                writer.write(line);
                // перенос строки
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

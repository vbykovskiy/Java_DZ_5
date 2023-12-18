package notebook.util.mapper.impl;

import notebook.util.mapper.Mapper;
import notebook.entities.User;

// Маппер для пользователя
public class UserMapper implements Mapper {

    // Метод для преобразования объекта в массив строк
    @Override
    public String toInput(User user) {
        return String.format("%s,%s,%s,%s", user.getId(), user.getFirstName(), user.getLastName(), user.getPhone());
    }

    // Метод для преобразования введенных пользователем строк в объект
    @Override
    public User toOutput(String s) {
        // Разбиваем строку на массив строк по запятой
        String[] lines = s.split(",");
        // Переменная для хранения id пользователя
        long id;
        // Проверяем, является ли первый элемент массива числом методом isDigit
        if (isDigit(lines[0])) {
            // Если первый элемент является числом, то присваиваем его переменной id
            id = Long.parseLong(lines[0]);
            // Создаем объект класса User и возвращаем его
            return new User(id, lines[1], lines[2], lines[3]);
        }
        throw new NumberFormatException("ID должен быть числом");
    }

    // Метод для проверки, является ли строка числом
    private boolean isDigit(String s) throws NumberFormatException {
        try {
            // Пытаемся преобразовать строку в число
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package notebook.util.mapper;

import notebook.entities.User;

public interface Mapper {
    // Метод для преобразования объекта в строку
    String toInput(User e);
    // Метод для преобразования строки в объект
    User toOutput(String str);
}

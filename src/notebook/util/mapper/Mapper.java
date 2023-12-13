package notebook.util.mapper;

import notebook.model.User;

// Интерфейс маппера
public interface Mapper {
    // Метод для преобразования объекта в строку
    String toInput(User e);
    // Метод для преобразования строки в объект
    User toOutput(String str);
}

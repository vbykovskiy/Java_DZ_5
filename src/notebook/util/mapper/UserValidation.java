package notebook.util.mapper;

import notebook.entities.User;

public class UserValidation {

    // Метод для проверки валидности пользователя
    public boolean valid(User user) {
        user = prepare(user);
        return !user.getFirstName().isEmpty() && !user.getLastName().isEmpty();
    }

    // Метод для обработки пробелов в имени и фамилии
    private User prepare(User user) {
        user.setFirstName(user.getFirstName().replace(" ", ""));
        user.setLastName(user.getLastName().replace(" ", ""));
        return user;
    }

}

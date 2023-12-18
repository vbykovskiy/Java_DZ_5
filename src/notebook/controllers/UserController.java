package notebook.controllers;

import notebook.entities.User;
import notebook.services.UserService;
import java.util.List;
import java.util.Optional;

public class UserController {

    // Экземпляр класса UserService для работы с пользователями
    private final UserService userService;

    // Конструктор для инициализации экземпляра класса UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // метод для создания пользователя
    public void saveUser(User user) {
        userService.save(user);
    }

    // метод для поиска пользователя по id
    public Optional<User> findById(Long userId) {
        return userService.findById(userId);
    }

    // метод для обновления пользователя по id
    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId)); // 
        userService.update(Long.parseLong(userId), update);
    }

    // метод для удаления пользователя по id
    public boolean deleteUser(String userId) {
        return userService.delete(Long.parseLong(userId));
    }

    // метод для получения списка всех пользователей
    public List<User> readAll() {
        return userService.findAll();
    }
}

package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    // Экземпляр класса UserRepository для работы с репозиторием пользователей
    private final GBRepository repository;

    // конструктор для инициализации экземпляра класса UserRepository
    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    // метод для создания пользователя
    public void saveUser(User user) {
        repository.create(user);
    }

    // метод для поиска пользователя по id
    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }
        throw new RuntimeException("Пользователь не найден");
    }

    // метод для обновления пользователя по id
    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId)); // 
        repository.update(Long.parseLong(userId), update);
    }

    // метод для удаления пользователя по id
    public void deleteUser(String userId) {
        repository.delete(Long.parseLong(userId));
    }

    // метод для получения списка всех пользователей
    public List<User> readAll() {
        return repository.findAll();
    }
}

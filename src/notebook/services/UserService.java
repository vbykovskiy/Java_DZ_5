package notebook.services;

import notebook.entities.User;
import notebook.repositories.UserRepository;
import notebook.util.mapper.UserValidation;
import java.util.List;
import java.util.Optional;

// Класс UserService - сервис для работы с пользователями
public class UserService {

    private final UserRepository userRepository;
    private final UserValidation userValidation;

    public UserService(UserRepository userRepository, UserValidation userValidation) {
        this.userRepository = userRepository;
        this.userValidation = userValidation;
    }

    // Метод для получения списка всех пользователей
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Метод для сохранения пользователя
    public User save(User user) {

        if (!userValidation.valid(user)) {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
        return userRepository.save(user);
    }

    // Метод для поиска пользователя по id
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Метод для обновления пользователя по id
    public Optional<User> update(Long userId, User update) {
        return userRepository.update(userId, update);
    }

    // Метод для удаления пользователя по id
    public boolean delete(Long id) {
        return userRepository.delete(id);
    }



}

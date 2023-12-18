package notebook.repositories._impl;

import notebook.model.repository.impl.FileOperation;
import notebook.repositories.UserRepository;
import notebook.util.mapper.impl.UserMapper;
import notebook.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Класс реализации репозитория для работы с пользователями
public class UserRepositoryFileStorage implements UserRepository {


    // экземпляр для работы с файлом
    private final FileOperation operation;

    private final UserMapper mapper;

    // конструктор
    public UserRepositoryFileStorage(FileOperation operation, UserMapper mapper) {
        // инициализация экземпляра класса для работы с файлом
        this.operation = operation;

        // экземпляр маппера для преобразования строки в объект и обратно
        this.mapper = mapper;
    }

    // Метод для получения списка (объекта) всех пользователей из файла
    @Override
    public List<User> findAll() {
        // Ссылка на список строк считанных из файла
        List<String> lines = operation.readAll();
        // Cоздаем список для хранения пользователей
        List<User> users = new ArrayList<>();
        // Преобразование строк в объекты и добавление в список пользователей
        for (String line : lines) {
            users.add(mapper.toOutput(line));
        }
        return users;
    }

    // Метод для добавления нового пользователя в файл
    @Override
    public User save(User user) {
        // Ссылка на список строк считанных из файла
        List<User> users = findAll();
        // Поиск максимального id
        long max = 0L;
        for (User u : users) {
            long id = u.getId();
            if (max < id) {
                max = id;
            }
        }
        // Увеличение максимального id
        long next = max + 1;
        // Добавление нового id пользователя 
        user.setId(next);
        // Добавление пользователя в список
        users.add(user);
        // Запись списка пользователей в файл
        write(users);
        return user;
    }

    // Метод для поиска пользователя по id
    @Override
    public Optional<User> findById(Long id) {

        Optional<User> result = Optional.empty();

        List<User> users = findAll();
        for (User user : users) {
            if (user.getId().equals(id)) {
                result =  Optional.of(user);
                break;
            }
        }
        return result;
    }

    // Метод для обновления пользователя по id
    @Override
    public Optional<User> update(Long userId, User update) {
        // Ссылка на список строк считанных из файла
        List<User> users = findAll();

        // Поиск пользователя по id
        User editUser = users.stream()
                .filter(u -> u.getId()
                        .equals(userId))
                .findFirst().orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        editUser.setFirstName(update.getFirstName().isEmpty() ? editUser.getFirstName() : update.getFirstName());
        editUser.setLastName(update.getLastName().isEmpty() ? editUser.getLastName() : update.getLastName());
        editUser.setPhone(update.getPhone().isEmpty() ? editUser.getPhone() : update.getPhone());
        write(users);
        return Optional.of(update);
    }

    // Метод для удаления пользователя по id
    @Override
    public boolean delete(Long id) {
        boolean result = false;


        // Ссылка на список строк считанных из файла
        List<User> users = findAll();

        // Поиск пользователя по id
        int size = users.size();
        users.removeIf(u -> u.getId().equals(id));

        if(users.size() != size) {
            // Перезапись списка
            write(users);
            result = true;
        }
        return result;
    }

    // Метод для записи списка пользователей в файл
    private void write(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u: users) {
            // Преобразование объекта в строку
            lines.add(mapper.toInput(u));
        }
        operation.saveAll(lines);
    }

}

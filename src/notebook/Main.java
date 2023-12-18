package notebook;

import notebook.controllers.UserController;
import notebook.repositories.UserRepository;
import notebook.model.repository.impl.FileOperation;
import notebook.repositories._impl.UserRepositoryFileStorage;
import notebook.services.UserService;
import notebook.util.mapper.UserValidation;
import notebook.util.mapper.impl.UserMapper;
import notebook.view.UserView;

import static notebook.util.DBConnector.DB_PATH;
import static notebook.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {

        // вызов метода создания файла из класса DBConnector
        createDB();

        // экземпляры классов для работы с репозиториями
        FileOperation fileOperation = new FileOperation(DB_PATH);
        UserMapper mapper = new UserMapper();
        UserRepository repository = new UserRepositoryFileStorage(fileOperation, mapper);
        UserValidation userValidation = new UserValidation();
        UserService userService = new UserService(repository, userValidation);

        // создание экземпляра класса UserController для работы с интерфейсом GBRepository
        UserController controller = new UserController(userService);
        // создание экземпляра класса UserView для работы с интерфейсом UserController
        UserView view = new UserView(controller);
        // запуск интерфейса
        view.run();

    }
}

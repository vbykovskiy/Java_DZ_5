package notebook;

import notebook.controller.UserController;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.FileOperation;
import notebook.model.repository.impl.UserRepository;
import notebook.view.UserView;

import static notebook.util.DBConnector.DB_PATH;
import static notebook.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        
        // вызов метода создания файла из класса DBConnector
        createDB();
        // создание экземпляра класса FileOperation для работы с файлом
        FileOperation fileOperation = new FileOperation(DB_PATH);
        // cоздание экземпляра интерфейса GBRepository для работы с классом UserRepository
        // в качестве аргумента передается экземпляр FileOperation
        GBRepository repository = new UserRepository(fileOperation);
        // создание экземпляра класса UserController для работы с интерфейсом GBRepository
        UserController controller = new UserController(repository);
        // создание экземпляра класса UserView для работы с интерфейсом UserController
        UserView view = new UserView(controller);
        view.run();

    }
}

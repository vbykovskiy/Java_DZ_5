package notebook.view;
import notebook.controllers.UserController;
import notebook.entities.User;
import notebook.util.Commands;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserView {

    // создание экземпляра интерфейса UserController
    private final UserController userController;

    // инициализация экземпляра интерфейса UserController
    public UserView(UserController userController) {
        this.userController = userController;
    }

    // метод для запуска интерфейса для пользователя
    public void run(){
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    User u = createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                        Optional<User> opUser = userController.findById(Long.parseLong(id));
                        System.out.println(opUser.isPresent() ? opUser.get() : "Пользователь не найден");
                        System.out.println();
                    break;
                case READ_ALL:
                    List<User> users = userController.readAll();
                    users.forEach(System.out::println);
                    break;
                case UPDATE:
                    String userId = prompt("Введите идентификатор пользователя: ");
                    userController.updateUser(userId, createUser());
                case DELETE:
                    String deleteId = prompt("Введите идентификатор пользователя: ");
                    boolean res = userController.deleteUser(deleteId);
                    if (!res) {
                        System.out.println("Пользователь не найден");
                    }
                case EXIT:
                    return;
                case NONE:
                    break;
            }
        }
    }

    // метод для получения ввода пользователя
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    // метод для создания пользователя
    private User createUser() {
        User result;
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        result = new User(firstName, lastName, phone);        
        return result;
    }
}

package notebook.model;

// Класс для описания структуры пользователей
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;

    // Конструктор для создания нового пользователя
    public User(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    // Конструктор для создания нового пользователя с идентификатором
    public User(Long id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Переопределенный метод toString для вывода информации о пользователе
    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nИмя: %s,\nФамилия: %s,\nТелефон: %s", id, firstName, lastName, phone);
    }
}

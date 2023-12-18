package notebook.repositories;

import notebook.entities.User;
import java.util.List;
import java.util.Optional;

// интерфейс для репозитория (UserRepository)
public interface UserRepository {
    List<User> findAll();
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> update(Long userId, User update);
    boolean delete(Long id);
}

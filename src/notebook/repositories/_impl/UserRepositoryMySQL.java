package notebook.repositories._impl;

import notebook.entities.User;
import notebook.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

// для примера
public class UserRepositoryMySQL implements UserRepository {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(Long userId, User update) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

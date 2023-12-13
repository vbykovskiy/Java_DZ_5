package notebook.model.repository;

import java.util.List;

// интерфейс для класса FileOperation
public interface Operation {
    List<String> readAll();
    void saveAll(List<String> data);
}

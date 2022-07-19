package fa.training.repository;

import fa.training.model.Computer;

import java.util.List;
import java.util.Map;

public interface ComputerRepository {
    Map<String, Object> findAll(int pageNumber);
    Computer findById(String id);
    void save(Computer computer);
    void saveAll(List<Computer> computers);
    void delete(String id);
}

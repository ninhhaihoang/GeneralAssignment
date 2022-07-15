package fa.training.repository;

import fa.training.model.Computer;

import java.util.List;

public interface ComputerRepository {
    List<Computer> findAll();
    Computer findById(String id);
    void save(Computer computer);
    void saveAll(List<Computer> computers);
    void delete(String id);
}

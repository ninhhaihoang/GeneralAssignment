package fa.training.repository;

import fa.training.model.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> findAll();
    Service findById(String id);
    void save(Service service);
    void saveAll(List<Service> services);
    void delete(String id);
}

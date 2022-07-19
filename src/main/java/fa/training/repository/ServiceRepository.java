package fa.training.repository;

import fa.training.model.Service;

import java.util.List;
import java.util.Map;

public interface ServiceRepository {
    Map<String, Object> findAll(int pageNumber);
    Service findById(String id);
    void save(Service service);
    void saveAll(List<Service> services);
    void delete(String id);
}

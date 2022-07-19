package fa.training.repository;

import fa.training.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerRepository {
    Map<String, Object> findAll(int pageNumber);
    Customer findById(String id);
    void save(Customer customer);
    void saveAll(List<Customer> customers);
    void delete(String id);
}

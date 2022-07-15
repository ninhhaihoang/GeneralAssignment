package fa.training.repository;

import fa.training.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(String id);
    void save(Customer customer);
    void saveAll(List<Customer> customers);
    void delete(String id);
}

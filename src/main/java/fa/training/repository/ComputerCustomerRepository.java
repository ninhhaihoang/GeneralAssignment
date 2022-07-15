package fa.training.repository;

import fa.training.model.ComputerCustomer;
import fa.training.model.ComputerCustomerKey;

import java.util.List;

public interface ComputerCustomerRepository {
    List<ComputerCustomer> findAll();
    ComputerCustomer findById(ComputerCustomerKey id);
    void save(ComputerCustomer computerCustomer);
    void delete(ComputerCustomerKey id);
}

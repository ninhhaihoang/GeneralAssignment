package fa.training.repository;

import fa.training.model.ComputerCustomer;
import fa.training.model.ComputerCustomerKey;
import fa.training.model.ServiceCustomer;
import fa.training.model.ServiceCustomerKey;

import java.util.List;

public interface ServiceCustomerRepository {
    List<ServiceCustomer> findAll();
    ServiceCustomer findById(ServiceCustomerKey id);
    void save(ServiceCustomer serviceCustomer);
    void delete(ServiceCustomerKey id);
}

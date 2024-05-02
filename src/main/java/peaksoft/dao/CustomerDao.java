package peaksoft.dao;

import peaksoft.entities.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    String saveCustomer(Customer newCustomer);
    String saveCustomerWithRent(Customer newCustomer, Long houseId, Long agencyId,
                                LocalDate checkIn, LocalDate checkout);
    Optional<Customer> findCustomerById(Long customerId);
    List<Customer> findAllCustomers();
    String updateCustomerById(Long customerId, Customer newCustomer);
    String deleteCustomerById(Long customerId);
    String rentingHouseByCustomer(Long customerId, Long houseId, Long agencyId, LocalDate checkIn, LocalDate checkout);
}

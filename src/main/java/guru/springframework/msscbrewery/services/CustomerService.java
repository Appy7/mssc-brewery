package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerID);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateBeer(UUID customerID, CustomerDto customerDto);

    void deleteById(UUID customerId);
}

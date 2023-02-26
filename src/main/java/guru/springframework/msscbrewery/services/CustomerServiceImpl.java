package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerID) {
        return CustomerDto.builder().id(UUID.randomUUID()).customerName("sashank").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID customerID, CustomerDto customerDto) {

    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("deleted customer");

    }
}

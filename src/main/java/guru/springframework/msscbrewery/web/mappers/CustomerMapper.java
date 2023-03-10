package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.Domain.Customer;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

     CustomerDto customerToCustomerDto(Customer customer);
     Customer customerDtoToCustomer(CustomerDto customerDto);
}

package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerID)
    {
        return new ResponseEntity<>(customerService.getCustomerById(customerID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto)
    {
        CustomerDto savedCustomer=customerService.saveNewCustomer(customerDto);

        HttpHeaders httpHeaders=new HttpHeaders();
        //To add Hostname to URL
        httpHeaders.add("Location","/api/v1/customer"+ savedCustomer.getId().toString());

        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity handlePut(@PathVariable("customerId") UUID customerID, @RequestBody CustomerDto customerDto)
    {
        customerService.updateBeer(customerID,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);
    }

}

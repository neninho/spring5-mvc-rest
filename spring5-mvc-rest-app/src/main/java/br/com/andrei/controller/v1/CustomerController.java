package br.com.andrei.controller.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrei.model.CustomerDTO;
import br.com.andrei.model.CustomerListDTO;
//import br.com.andrei.api.v1.model.*;
import br.com.andrei.service.CustomerService;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

	static final String BASE_URL = "/api/v1/customers";
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public CustomerListDTO getAllCustomers() {
		CustomerListDTO customerListDTO = new CustomerListDTO();
		customerListDTO.getCustomers().addAll(customerService.getAllCustomers());
		return customerListDTO;
	}

	@GetMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO getCustomerById(@PathVariable Long id){
		return customerService.getCustomerById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO saveNewCustomer(@RequestBody CustomerDTO customerDTO){
		return customerService.createNewCustomer(customerDTO);
	}
	
	@PutMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
		return customerService.saveCustomerByDTO(id, customerDTO);
	}
	
	@PatchMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
		return customerService.patchCustomer(id, customerDTO);
	}
	
	@DeleteMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable Long id){
		customerService.deleteCustomerById(id);
	}

}

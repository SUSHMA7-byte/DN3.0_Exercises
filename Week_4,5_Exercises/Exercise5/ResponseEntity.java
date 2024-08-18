import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@PostMapping("/register")
public ResponseEntity<Customer> registerCustomer(
    @RequestParam("name") String name,
    @RequestParam("email") String email,
    @RequestParam("address") String address
) {
    Customer customer = new Customer(name, email, address);
    Customer createdCustomer = customerService.createCustomer(customer);

    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Custom-Header", "RegistrationSuccess");

    return new ResponseEntity<>(createdCustomer, headers, HttpStatus.CREATED);
}

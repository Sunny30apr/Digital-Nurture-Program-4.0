public class CustomerService {
    private final CustomerRepository customerRepository;
     public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository=customerRepository;
     }

     public String getCustomerById(String id) {
        return customerRepository.findCustomerById(id);
     }
}

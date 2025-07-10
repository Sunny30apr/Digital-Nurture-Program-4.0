public class Test {
    public static void main(String[] args) throws Exception {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        String customer = customerService.getCustomerById("1106");

        System.out.println(customer);
    }
}

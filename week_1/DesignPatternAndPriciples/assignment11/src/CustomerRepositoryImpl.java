public class CustomerRepositoryImpl implements CustomerRepository{
    public String findCustomerById(String id) {
        return "Found Customer with ID: " + id;
    }
}

class CustomerService{

    CustomerRepository repo;

    CustomerService(CustomerRepository repo){
        this.repo=repo;
    }

    void getCustomer(int id){
        System.out.println(repo.findCustomerById(id));
    }
}
package CaseStudy.file;

import CaseStudy.object.Customer;

import java.util.ArrayList;
import java.util.List;

public class FileCustomer {
    private final static String file = "customer.csv";

    public FileCustomer(){}
    public static List<Customer> fileData(){
        List<Customer> customers = new ArrayList<>();
        List<String> list = OperationFile.read(file);
        for (String read: list) {
            Customer customer = Customer.fileAll(read);
            customers.add(customer);
        }
        return customers;
    }


    public void add(Customer customer) {
        List<Customer> customers = fileData();
        customers.add(customer);
        OperationFile.writer(file, customers);
    }

    public static void  updateListCustomer(List<Customer> customers, List<String> strings) {
        for (Customer find : customers) {
            String update = find.getId() + "," + find.getName() + "," + find.getIdCard() + "," + find.getPhone() + "," + find.getRental_hours() + "," + find.getQuantity();
            strings.add(update);
        }
        OperationFile.writer(file, strings);
    }




}

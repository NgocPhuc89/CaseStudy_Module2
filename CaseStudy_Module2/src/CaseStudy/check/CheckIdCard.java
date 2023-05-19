package CaseStudy.check;

import CaseStudy.object.Customer;
import CaseStudy.file.FileCustomer;

import java.util.List;
import java.util.regex.Pattern;

public class CheckIdCard {
    public static final String ID_REGEX = "^0[1-9][0-9]{10}$";
    public static boolean isIdCardValid(String number) {
        return Pattern.compile(ID_REGEX).matcher(number).matches();
    }

    public static boolean findIdCard(String idCrad){
        List<Customer> find = FileCustomer.fileData();
        for (Customer customer: find ) {
            if(customer.getIdCard().equals(idCrad)){
                return true;
            }
        }
        return false;
    }
}

package CaseStudy.check;

import CaseStudy.object.Customer;
import CaseStudy.file.FileCustomer;

import java.util.List;
import java.util.regex.Pattern;

public class CheckPhone {
        public static final String PHONE_REGEX = "^0[1-9][0-9]{8}$";
        public static boolean isPhoneValid(String number) {
            return Pattern.compile(PHONE_REGEX).matcher(number).matches();
        }

    public static boolean findPhone(String phone){
        List<Customer> find = FileCustomer.fileData();
        for (Customer customer: find ) {
            if(customer.getPhone().equals(phone)){
                return true;
            }
        }
        return false;
    }

}

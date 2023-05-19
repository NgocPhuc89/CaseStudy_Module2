package CaseStudy.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class OperationFile {
    public OperationFile(){}
    public static List<String> read(String file){
        List<String> read = new ArrayList<>();
        try {
            File fi = new File(file);
            BufferedReader br = new BufferedReader(new FileReader(fi));
            String str;
                while ((str = br.readLine())!= null && !str.trim().isEmpty()){
                    read.add(str);
            }
        } catch (Exception e){
            System.out.println("An error occurred!");
        }
        return read;
    }


    public static <Customer> void writer(String nameFile, List<Customer> customers){
        try{
            PrintWriter printWriter = new PrintWriter(nameFile);
            for(Customer customer : customers ) {
                printWriter.println(customer.toString());
            }
            printWriter.flush();
            printWriter.close();
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }

}

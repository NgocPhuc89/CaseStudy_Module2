package CaseStudy.utils;

import CaseStudy.object.Bicycle;
import CaseStudy.file.FileBicycle;
import CaseStudy.check.CheckContinue;
import CaseStudy.check.CheckIdCard;
import CaseStudy.check.CheckPhone;
import CaseStudy.object.Customer;
import CaseStudy.file.FileCustomer;
import CaseStudy.file.OperationFile;
import CaseStudy.file.FileHistory;
import CaseStudy.object.History;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static CaseStudy.file.FileBicycle.updateListBicycle;
import static CaseStudy.check.CheckInput.checkInputId;
import static CaseStudy.check.CheckInput.checkInputMonth;
import static CaseStudy.file.FileCustomer.updateListCustomer;
import static CaseStudy.display.Show.*;

public class Function {
    static Scanner input = new Scanner(System.in);

    static List<String> strings = OperationFile.read("customer.csv");
    static List<Customer> customers = FileCustomer.fileData();
    static List<Bicycle> bicycles = FileBicycle.fileData();

    static List<History> histories = FileHistory.fileHistory();


    public static  String name(){
        do {
            System.out.print("Họ Và Tên: ");
            String name = input.nextLine();
            if (name.equals("")){
                System.out.println("Tên Không Được Để Trống");
                continue;
            }
            return name;
        }while (true);
    }

    public static String idCrad(){
        do {
            System.out.print("Số CCCD: ");
            String idCard = input.nextLine();
            if (!CheckIdCard.isIdCardValid(idCard) || CheckIdCard.findIdCard(idCard)) {
                System.out.println("Sai Định Dạng Hoặc Trùng ");
                continue;
            }
            return idCard;
        } while (true);
    }

    public static String phone(){
        do {
            System.out.print("Số Điện Thoại: ");
            String phone = input.nextLine();
            if (!CheckPhone.isPhoneValid(phone) || CheckPhone.findPhone(phone)) {
                System.out.println("Sai Định Dạng Hoặc Trùng ");
                continue;
            }
            return phone;
        } while (true);
    }

    public static int quantity(){
        while (true) {
            try {
                System.out.print("Nhập Số Lượng: ");
                int temp = Integer.parseInt(input.nextLine());
                for (Bicycle b: FileBicycle.fileData()) {
                    if(temp < b.getNotUse()) {
                        return temp;
                    }
                    System.out.println("Số Lượng Còn Lại: " + b.getNotUse() + ". Vui Lòng Nhập Lại");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Không Hợp Lệ, Vui Lòng Nhập Lại" );
            }
        }
    }


    public static int notUse(){
        Bicycle bicycle = new Bicycle();
        return bicycle.getNotUse();
    }


    public static void addInformation() {
        FileCustomer addFile = new FileCustomer();
        Customer customer = new Customer()
                .setId(System.currentTimeMillis())
                .setName(name())
                .setIdCard(idCrad())
                .setPhone(phone())
                .setRental_hours(LocalDateTime.now())
                .setQuantity(quantity());
        addFile.add(customer);

        FileBicycle addFileBicycle = new FileBicycle();
        Bicycle bicycle = new Bicycle()
                .setIdBi(customer.getId())
                .setUsing(customer.getQuantity())
                .setNotUse(notUse() - customer.getQuantity());
        addFileBicycle.add(bicycle);

        System.out.println();
        System.out.println("Thuê Xe Thành Công \n\n");

    }

    public static void deleteInformation() {
        customers = FileCustomer.fileData();
        List<String> newCustomer = new ArrayList<>();
        List<String> newBicycle = new ArrayList<>();
        showData(strings);
        long newId;
        newId = checkInputId();
        int count = 0;
        for (Customer find : customers) {
                if (find.getId() == newId) {
                    System.out.println();
                    System.out.println("Bạn Muốn Trả Xe \n");
                    if(CheckContinue.checkEdit(input)) {

                        FileHistory newFile = new FileHistory();
                        History history = new History()
                                .setId(find.getId())
                                .setName(find.getName())
                                .setIdCard(find.getIdCard())
                                .setPhone(find.getPhone())
                                .setPayment_time(find.getPayment_time())
                                .setQuantity(find.getQuantity())
                                .setTotal_money(find.getTotal());
                        newFile.add(history);

                    }
                        invoice_printing(newId);
                        customers.remove(find);
                        count++;
                        break;
                }
            }
        for (Bicycle bi:bicycles) {
            if(bi.getIdBi() == newId){
                bicycles.remove(bi);
                break;
            }
        }
        if(count == 0){
            System.out.println("Không Tìm Thấy ID Khách Hàng");
        return;
        }
        updateListCustomer(customers,newCustomer);
        updateListBicycle(bicycles,newBicycle);
        System.out.println("Trả Xe Thành Công\n");
    }

    public static void editInformation(){
        customers = FileCustomer.fileData();
        List<String> editList = new ArrayList<>();
        showData(strings);
        long newId = checkInputId();
        int count = 0 ;
        for (Customer edit : customers) {
            if (edit.getId() == newId) {
                System.out.println();
                System.out.println("Chỉnh Sửa Tên Khách Hàng \n");
                if(CheckContinue.checkEdit(input)) {
                    System.out.println();
                    edit.setName(name());
                }
                System.out.println();
                System.out.println("Chỉnh Sửa Số Điện Thoại  \n");
                if(CheckContinue.checkEdit(input)){
                    System.out.println();
                    edit.setPhone(phone());
                }
                System.out.println();
                System.out.println("Chỉnh Sửa Số Lượng   \n");
                if(CheckContinue.checkEdit(input)){
                    System.out.println();
                    edit.setQuantity(quantity());
                }
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Không Tìm Thấy ID Khách Hàng");
            return;
        }
        updateListCustomer(customers,editList);
        System.out.println("\n");
        System.out.println("Sửa Thông Tin Thành Công\n");
    }


    public static void monthly_revenue(){
        histories = FileHistory.fileHistory();
        showHistory();
        int months = checkInputMonth();
        int total = 0;
        for (History history: histories) {
            if((history.getPayment_time().getMonthValue()) == months)
                total += history.getTotal_money();
        }
        System.out.println("Doanh Thu Tháng " + months + " là : " + total + " VND");
    }



}

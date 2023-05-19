package CaseStudy.display;

import java.util.Scanner;

public class DisplayMenu {

    public static void printMenu(Information information) {
        System.out.println(information.getTitle().toUpperCase());
        for (Display detail : information.getInformationDetails()) {
            System.out.printf("                      %s. %s%n", detail.getNo(), detail.getDescription());
        }
    }

    public static int choice(Scanner input) {
        while (true){
            try {
                System.out.print("   Xin Mời Chọn : ");
                return Integer.parseInt(input.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ, Vui Lòng Nhập Lại\n");
            }
        }
    }


    public static void menuFirst() {
        Display[] menu = new Display[3];
        menu[0] = new Display(1, "Quản Lý Khách Hàng");
        menu[1] = new Display(2, "Quản Lý Cửa Hàng");
        menu[2] = new Display(0, "Thoát");
        Information information = new Information("=-=-=-=-=-=-=-=-=-=-=-=   Phuc Bycicle   =-=-=-=-=-=-=-=-=-=-=-=", menu);
        printMenu(information);
    }

    public static void bicycle() {
        Display[] bicycle = new Display[5];
        bicycle[0] = new Display(1, "Xem Thông Tin Xe Đạp");
        bicycle[1] = new Display(2, "Xem Lịch Sử");
        bicycle[2] = new Display(3, "Doanh Thu Tháng");
        bicycle[3] = new Display(4, "Quay Lại");
        bicycle[4] = new Display(0, "Thoát");
        Information information = new Information("=-=-=-=-=-=-=-=-=-=-=-=   Quản Lý Cửa Hàng   =-=-=-=-=-=-=-=-=-=-=-=", bicycle);
        printMenu(information);
    }


    public static void customer() {
        Display[] customer = new Display[6];
        customer[0] = new Display(1, "Xem Thông Tin");
        customer[1] = new Display(2, "Thuê Xe");
        customer[2] = new Display(3, "Sửa Thông Tin");
        customer[3] = new Display(4, "Trả Xe");
        customer[4] = new Display(5, "Quay Lại");
        customer[5] = new Display(0, "Thoát");
        Information information = new Information("=-=-=-=-=-=-=-=-=-=-=-=   Quản Lý Khách Hàng   =-=-=-=-=-=-=-=-=-=-=-=", customer);
        printMenu(information);

    }

    public static void note(){
        Display[] note = new Display[2];
        note[0] = new Display(1,"Quay Lại");
        note[1] = new Display(0,"Thoát");
        Information information = new Information("             =-=-=-=-=   Ghi Chú   =-=-=-=-=", note);
        printMenu(information);
    }
}

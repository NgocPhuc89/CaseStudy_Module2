package CaseStudy.check;

import java.util.Scanner;

public class CheckInput {
   static Scanner input = new Scanner(System.in);
    public static long checkInputId(){
        long id;
        while(true) {
            try {
                System.out.print("Nhập ID Khách Hàng: ");
                id = Long.parseLong(input.nextLine());
                if(id > 0) {
                    break;
                }
                System.out.println("ID Không Hợp Lệ, Vui Lòng Nhập Lại\n");
            } catch (Exception e) {
                System.out.println("ID Không Hợp Lệ, Vui Lòng Nhập Lại\n");
            }
        }
        return id;
    }

    public static int checkInputMonth(){
        int month;
        while (true){
            try {
                System.out.print("Nhập Tháng: ");
                month = Integer.parseInt(input.nextLine());
                if (month > 0 && month <= 12) {
                    return month;
                }
                System.out.println(" Không Hợp Lệ, Vui Lòng Nhập 1 -> 12\n");
            }catch (NumberFormatException e){
                System.out.println(" Không Hợp Lệ, Vui Lòng Nhập 1 -> 12\n");
            }
        }
    }




}

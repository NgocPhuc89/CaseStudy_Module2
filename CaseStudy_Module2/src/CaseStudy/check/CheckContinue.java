package CaseStudy.check;

import java.util.Scanner;

public class CheckContinue {
    public static boolean checkContinue(Scanner scanner) {
        System.out.print("Bạn có muốn tiếp tục không? Vui Lòng Chọn y hoặc n :    ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("y")) {
            return true;
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("Chúc Bạn 1 Ngày Tốt Lành !");
            System.exit(0);
        } else {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 'y, 'n'.");
            checkContinue(scanner);
        }
        return false;
    }

    public static boolean checkEdit(Scanner scanner){
        while (true){
                System.out.print("Bạn Có Muốn Tiếp Tục Không? Vui Lòng Nhập y hoặc n :   ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("y")){
                    return true;
                }
                 if(input.equalsIgnoreCase("n"))
                     return false;
                 else
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }


}


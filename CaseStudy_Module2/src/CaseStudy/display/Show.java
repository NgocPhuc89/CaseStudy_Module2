package CaseStudy.display;

import CaseStudy.object.Bicycle;
import CaseStudy.file.FileBicycle;
import CaseStudy.object.Customer;
import CaseStudy.file.OperationFile;
import CaseStudy.object.History;

import java.util.List;

import static CaseStudy.file.FileCustomer.fileData;
import static CaseStudy.file.FileHistory.fileHistory;

public class Show {
    public static void showData (List<String> file){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=   THÔNG TIN KHÁCH HÀNG   =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        System.out.printf("*   %-15s %-22s %-22s %-15s %-27s %s     *\n","ID Khách Hàng","Tên Khách Hàng","Số CCCD","Số Điện Thoại","Thời Gian Nhận Xe","Số Lượng");
        for (Customer customer1:fileData()) {
            System.out.printf("*   %-15s %-22s %-22s %-15s %-30s %s         *\n",
                    customer1.getId(),
                    customer1.getName(),
                    customer1.getIdCard(),
                    customer1.getPhone(),
                    customer1.getRental_hours(),
                    customer1.getQuantity());
        }
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
    }


    public static void showBicycle (){
        System.out.println("=-=-=-=-=-=-=-=   THÔNG TIN XE ĐẠP   =-=-=-=-=-=-=-=\n");
        System.out.printf("*   %-15s %-15s %s    *\n","ID Khách Hàng","Đang Sử Dụng","Chưa Sử Dụng");
        for (Bicycle bicycle: FileBicycle.fileData()) {
            System.out.printf("*   %-20s %-15s %s         *\n",
                    bicycle.getIdBi(),
                    bicycle.getUsing(),
                    bicycle.getNotUse());
        }
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=\n");
    }

    public static void showInformation(){
        List<String> data = OperationFile.read("customer.csv");
        showData(data);
    }

    public static void showHistory (){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=     LỊCH SỬ THUÊ XE    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        System.out.printf("*   %-15s %-25s %-15s %-15s %-25s %-14s %s       *\n","ID KHÁCH HÀNG","Tên KHÁCH HÀNG","Số CCCD","SỐ ĐIỆN THOẠI","THỜI GIAN TRẢ XE","SỐ LƯỢNG","TỔNG TIỀN");
        for (History history: fileHistory()) {
            System.out.printf("*   %-15s %-25s %-15s %-15s %-27s %-10s %-7s  VND      *\n",
                    history.getId(),
                    history.getName(),
                    history.getIdCard(),
                    history.getPhone(),
                    history.getPayment_time(),
                    history.getQuantity(),
                    history.getTotal_money());
        }
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
    }


    public static void invoice_printing (long id) {
        for (Customer find : fileData()) {
            if (find.getId() == id) {
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=   HÓA ĐƠN THUÊ XE   =-=-=-=-=-=-=-=-=-=-=-=-=-=\n ");
                System.out.printf("                  ID Xe : %s                                        \n " +
                                "                 Họ Và Tên : %s                                     \n " +
                                "                 Địa Chỉ : %s                                       \n " +
                                "                 Số Điện Thoại : %s                                 \n " +
                                "                 Thời Gian Nhận Xe : %s                             \n " +
                                "                 Thời Gian Trả Xe : %s                              \n " +
                                "                 Số Lượng Thuê : %s                                 \n " +
                                "                 Tổng Thời Gian Thuê : %s Phút                      \n " +
                                "                 Tổng Tiền : %s VND                                 \n ",
                        find.getId(),
                        find.getName(),
                        find.getIdCard(),
                        find.getPhone(),
                        find.getRental_hours(),
                        find.getPayment_time(),
                        find.getQuantity(),
                        find.getTotal_time(),
                        find.getTotal());
                System.out.println();
                System.out.println("                      Cảm Ơn Quý Khác. Hẹn Gặp Lại!");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n ");
            }
        }
    }
}

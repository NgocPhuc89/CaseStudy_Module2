package CaseStudy;

import CaseStudy.check.CheckContinue;
import CaseStudy.display.DisplayMenu;
import CaseStudy.utils.Function;

import java.io.IOException;
import java.util.Scanner;

import static CaseStudy.display.DisplayMenu.*;
import static CaseStudy.display.Show.*;
import static CaseStudy.utils.Function.*;


public class Menu {
    public static void menu () {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (true) {
            menuFirst();
            choice = DisplayMenu.choice(input);
            boolean check = true;
            switch (choice) {
                case 1:
                    while (check) {
                        customer();
                        choice = DisplayMenu.choice(input);
                        switch (choice) {
                            case 1:
                                while (check){
                                    showInformation();
                                    System.out.println();
                                    if(CheckContinue.checkContinue(input))
                                        break;
                                }
                                break;

                            case 2:
                                while (check) {
                                    addInformation();
                                    System.out.println();
                                    if (CheckContinue.checkContinue(input))
                                        break;
                                }
                                break;

                            case 3:
                                while (check) {
                                    editInformation();
                                    System.out.println();
                                    if (CheckContinue.checkContinue(input))
                                        break;
                                }
                                break;

                            case 4:
                                while (check) {
                                    deleteInformation();
                                    System.out.println();
                                    if (CheckContinue.checkContinue(input))
                                        break;
                                }
                                break;

                            case 5:
                                check = false;
                                break;

                            case 0:
                                System.exit(0);
                        }
                    }
                    break;
                case 2:
                    while (check) {
                        bicycle();
                        choice = DisplayMenu.choice(input);
                        switch (choice) {
                            case 1:
                                while (check) {
                                    showBicycle();
                                    System.out.println();
                                    if (CheckContinue.checkContinue(input))
                                        break;
                                }
                                break;
                            case 2:
                                while (check) {
                                    showHistory();
                                    System.out.println();
                                    if (CheckContinue.checkContinue(input))
                                        break;
                                }
                                break;
                            case 3:
                                while (check) {
                                    monthly_revenue();
                                    System.out.println();
                                    if (CheckContinue.checkContinue(input))
                                        break;
                                }
                                break;
                            case 4:
                                check=false;
                                break;
                            case 0:
                                System.exit(0);
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa Chọn Không Hợp Lệ, Vui Lòng Nhập Lại\n");
            }
        }
    }
}

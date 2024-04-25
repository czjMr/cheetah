package com.cheetah.design.code.question;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入桌号:");
        int tNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入项目名称:");
        String name = scanner.nextLine();
        System.out.println("请输入数量:");
        int quantity = scanner.nextInt();
        System.out.println("请输入单价:");
        BigDecimal unitPrice = scanner.nextBigDecimal();
        System.out.println("请输入单价:");
        scanner.nextLine();
        // 关闭
        scanner.close();
        System.out.println(new Item(tNumber,name,quantity,unitPrice).toString());
    }
}

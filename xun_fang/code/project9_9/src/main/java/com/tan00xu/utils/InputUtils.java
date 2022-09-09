package com.tan00xu.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 输入工具类
 *
 * @author TAN00XU
 * @date 2022/09/07
 */
public class InputUtils {


    /**
     * 得到整数
     *
     * @param messages 消息
     * @return int
     */
    public static int getInt(String messages) {
        System.out.println(messages);
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        try {
            i = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("输入错误，请重新输入！");
            i = getInt(messages);
        }
        return i;
    }

    /**
     * 获取输入的数字
     *
     * @param type    类型 int、float、double、long
     * @param message 消息
     * @return {@link Object}
     */
    public static Number getNumber(String type, String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        try {
            if ("int".equalsIgnoreCase(type)) {
                return scanner.nextInt();
            }
            if("float".equalsIgnoreCase(type)){
                return scanner.nextFloat();
            }
            if ("double".equalsIgnoreCase(type)) {
                return scanner.nextDouble();
            }
            if ("long".equalsIgnoreCase(type)) {
                return scanner.nextLong();
            }
        } catch (InputMismatchException e) {
            System.out.println("输入错误，请重新输入！");
            return getNumber(type, message);
        }
        return -1;
    }

    public static String getString(String messages) {
        CmdOutputInformationUtils.info(messages);
        Scanner scanner = new Scanner(System.in);
        String str = "";
        try {
            str = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("输入错误，请重新输入！");
            return getString(messages);
        }
        return str;
    }


}

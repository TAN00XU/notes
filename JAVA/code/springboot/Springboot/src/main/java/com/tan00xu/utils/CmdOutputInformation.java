package com.tan00xu.utils;


/**
 * @author TAN00XU
 * 用于控制命令行输出字体颜色
 */
public class CmdOutputInformation {

    /**
     * debug
     * @param debug 待输出的字符串
     */
    public static void debug(String debug) {
        System.out.println("\033[4;34m" + debug + "\033[0m");
    }

    /**
     * info
     * @param info 待输出的字符串
     */
    public static void info(String info) {
        System.out.println("\033[32m" + info + "\033[0m");
    }

    /**
     * warn
     * @param warn 待输出的字符串
     */
    public static void warn(String warn) {
        System.out.println("\033[33m" + warn + "\033[0m");
    }

    /**
     * error
     * @param error 待输出的字符串
     */
    public static void error(String error) {
        System.out.println("\033[7;31;40m" + error + "\033[0m");
    }


}

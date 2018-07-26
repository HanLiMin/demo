package com.moontwon.demo.temp;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/18
 */
public class ReTemp {
    public static void main(String[] args) {
        String re = "^(1|2)[0-9,A-F]{3}-[0-9,A-F]{6}\\d{6}[0-9,A-F]{3}$";
        String code = "1107-023002180770FFF";
        System.err.println(code.matches(re));
    }
}

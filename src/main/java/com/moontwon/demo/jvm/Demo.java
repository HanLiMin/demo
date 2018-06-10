package com.moontwon.demo.jvm;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-5-27
 */
public class Demo {
    static {
        System.err.println("static block");
    }
    {
        System.err.println("class block");
    }

    public Demo() {
        System.err.println("controctor block");
    }
    {
        System.err.println("class block2");
    }

    public static void main(String[] args) {
        String a="12";
        short b=Short.valueOf(a);
        short c=Short.valueOf(a);
        short d= b+c;
        long x=12L;
        long y=12L;
        long z=x+y;




        Demo demo = new Demo();
        Demo demo12 = new Demo();
        System.err.println(C.class.isAssignableFrom(D.class));
    }

}

package com.inspur.jvm.class_structure;

import java.io.*;
import java.net.ServerSocket;

/**
 *  本程序主要看Exception在字节码中的情况!
 *  1.在新版本JVM的规范中,异常的处理是通过exception table来处理的!
 *  2.如果存在多个catch代码块,在字节码层次会对每个catch后加上finally块中的字节码!
 *  3.针对当前程序来说:无论有多少个catch exception代码块,都会当做一个局部变量(这个局部变量就是异常)
 */
public class MyTest03 {

    public void test() throws NullPointerException, IOException, FileNotFoundException{
        try {
            InputStream inputStream = new FileInputStream("test.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (Exception ex) {

        } finally {
            System.out.println("finally");
        }


    }
}

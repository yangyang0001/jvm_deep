package com.inspur.jvm.classloader_02;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 重新复习自定义类加载器!
 */
public class MyClassLoader extends ClassLoader {

    private String classLoaderName;

    private String filePrefix;

    private static String fileExtension = ".class";

    public MyClassLoader(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public String getFilePrefix() {
        return filePrefix;
    }

    public void setFilePrefix(String filePrefix) {
        this.filePrefix = filePrefix;
    }

    /**
     * 以下两个方法就是对ClassLoader自定义过程的最主要的过程!
     * @param binaryName
     * @return
     */
    public Class<?> findClass(String binaryName) {
        System.out.println("binaryName -------------------:" + binaryName);
        System.out.println("classLoaderName --------------:" + classLoaderName);
        byte[] b = loadClassData(binaryName);
        return defineClass(binaryName, b, 0, b.length);
    }

    private byte[] loadClassData(String binaryName) {
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        byte[] data = null;

        try {
            String fileName = binaryName.replace(".", "\\");

            is = new FileInputStream(new File(filePrefix + fileName + fileExtension));
            baos = new ByteArrayOutputStream();

            int b = -1;
            while((b = is.read()) != -1){
                baos.write(b);
            }

            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.flush();
                baos.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return data;
    }


    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader("loader1");
        classLoader.setFilePrefix("C:\\Users\\Administrator\\Desktop\\study_jvm\\");
        Class<?> clazz = classLoader.loadClass("com.inspur.jvm.classloader_01.MyTest01");

        System.out.println("clazz.hashCode   ---------------------:" + clazz.hashCode());
        System.out.println("clazz.getClassLoader -----------------:" + clazz.getClassLoader());
    }

}

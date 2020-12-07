package com.deepblue.jvm.classloader_02;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 重写ClassLoader的要点重写findClass()方法!
 * -XX:+TraceClassUnloading 查看类卸载的jvm option
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String fileExtension = ".class";

//    private static final String filePrefix = "E:\\study_workspace\\jvm_deep\\out\\production\\jvm_deep\\";
    private String filePrefix = "C:\\Users\\Administrator\\Desktop\\study_jvm\\";

    public MyTest16(String classLoaderName) {
        super();            //将系统类或应用类加载器当做当前自定义类加载器的双亲!
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);      //指定传入的ClassLoader当做当前类加载器的双亲
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return classLoaderName.toString();
    }

    public String getFilePrefix() {
        return filePrefix;
    }

    public void setFilePrefix(String filePrefix) {
        this.filePrefix = filePrefix;
    }

    /**
     * JavaDoc中推荐自己重写的方法
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass invoked className -------:" + name);
        System.out.println("classLoader name --------:" + classLoaderName);
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    public byte[] loadClassData(String name) {

        InputStream inputStream = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {

            name = name.replace(".", "\\");

            inputStream = new FileInputStream(new File(filePrefix + name + fileExtension));
            baos = new ByteArrayOutputStream();
            int b = -1;

            while ((b = inputStream.read()) != -1) {
                baos.write(b);
            }
            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                baos.flush();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 本问的才是主要通过删除,ClassPath中的MyTest01.class文件来测试!或者重新编译后再进行测试!主要测试的是双亲委派和类的卸载!
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loder1");
        Class<?> clazz1 = loader1.loadClass("com.deepblue.jvm.classloader_01.MyTest01");
        Object object1 = clazz1.newInstance();
        System.out.println("clazz-------------------------:" + clazz1.hashCode());
        System.out.println("clazzLoader-------------------:" + clazz1.getClassLoader());

        System.out.println("------------------------------------------------------------------------------------------------");

        /**
         * 这一块主要测试类的卸载,只有通过自己的类加载器加载的类才能够进行卸载!
         */
//        loader1 = null;
//        clazz1 = null;
//        object1 = null;
//
//        System.gc();


        MyTest16 loader2 = new MyTest16("loader2");
        Class<?> clazz2 = loader2.loadClass("com.deepblue.jvm.classloader_01.MyTest01");
        Object object2 = clazz2.newInstance();
        System.out.println("clazz-------------------------:" + clazz2.hashCode());
        System.out.println("clazzLoader-------------------:" + clazz2.getClassLoader());

    }
}

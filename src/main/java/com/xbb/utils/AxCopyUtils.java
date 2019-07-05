package com.xbb.utils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shiex-薛
 * @title: AxCopyUtils
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\6\30 003018:48
 */
public class AxCopyUtils {

    /**
     * @description: 深拷贝，泛型须实现Serializable接口,耗时：117ms
     * @param t
     * @return: T
     */
    public static <T> T deepCopy(T t){
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try{
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(t);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream inputStream = new ObjectInputStream(byteIn);
            return (T)inputStream.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException ea){
            ea.printStackTrace();
        }
        return null;
    }

    /**
     * @description: 浅拷贝，泛型类须实现Cloneable接口并重写clone方法，耗时：42ms
     * @param list
     * @return: java.util.List<T>
     */
    public static <T> List<T> shallowCopy(List<T> list){
        List<Object> copyList = new ArrayList<>();
        for(T t : list){
            if(!(t instanceof Cloneable)) return null;
            try{
                Class clz = t.getClass();
                Method method = clz.getMethod("clone");
                Object rs = method.invoke(t);
                copyList.add(rs);
            }catch (NoSuchMethodException e){
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }catch (InvocationTargetException e){
                e.printStackTrace();
            }
        }
        return (List<T>) copyList;
    }
}

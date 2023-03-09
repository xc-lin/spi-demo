package org.example;

import com.lxc.interfaces.LogInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * Hello world!
 */
public class SelfImpl {
    Enumeration<URL> configs;
    public static void main(String[] args) throws Exception {
        SelfImpl self = new SelfImpl();
        List<LogInterface> load = self.load(LogInterface.class);
        for (LogInterface logInterface : load) {
            String s = logInterface.printLog();
            System.out.println(s);
            System.out.println("+++++++++++++++++++");
        }
    }

    public <T> List<T> load(Class clazz) throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        configs = classLoader.getResources("META-INF/services/" + clazz.getName());
        List<T> objects = new ArrayList<>();
        while (configs.hasMoreElements()){
            List<String> names = new ArrayList<>();
            URL url = configs.nextElement();
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String s = "";
            while ((s = bufferedReader.readLine())!=null){
                names.add(s);
            }
            for (String name : names) {
                Class<?> cls = Class.forName(name,false,classLoader);
                if (!clazz.isAssignableFrom(cls)){
                    throw new RuntimeException("类型不符合");
                }
                T object = (T) clazz.cast(cls.newInstance());
                objects.add(object);
            }
        }
        return objects;

    }

}

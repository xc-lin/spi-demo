package org.example;

import com.lxc.interfaces.LogInterface;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        ServiceLoader<LogInterface> load = ServiceLoader.load(LogInterface.class);
        Iterator<LogInterface> iterator = load.iterator();
        while (iterator.hasNext()){
            LogInterface logInterface = iterator.next();
            String s = logInterface.printLog();
            System.out.println("curr "+s);
            System.out.println("+++++++++++++++");
        }
        Enumeration<URL> systemResources = ClassLoader.getSystemResources("META-INF/services/" + LogInterface.class.getName());

    }
}

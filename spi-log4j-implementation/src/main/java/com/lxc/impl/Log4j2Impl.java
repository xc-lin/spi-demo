package com.lxc.impl;

import com.lxc.interfaces.LogInterface;

public class Log4j2Impl implements LogInterface {
    @Override
    public String printLog() {
        System.out.println("i am log4j2");
        return "log4j2";
    }
}

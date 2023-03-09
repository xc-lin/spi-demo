package com.lxc.impl;

import com.lxc.interfaces.LogInterface;

public class Log4jImpl implements LogInterface {
    @Override
    public String printLog() {
        System.out.println("i am log4j");
        return "log4j";
    }
}

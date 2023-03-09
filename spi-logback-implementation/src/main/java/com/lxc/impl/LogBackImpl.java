package com.lxc.impl;

import com.lxc.interfaces.LogInterface;

public class LogBackImpl implements LogInterface {
    @Override
    public String printLog() {
        System.out.println("i am logback");
        return "logBack";
    }
}

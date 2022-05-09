package com.youku.atm.busmodule.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtil {

    public static Log STD_OUT_LOG = LogFactory.getLog("STDOUTLOG");

    public static Log getLog() {
        return STD_OUT_LOG;
    }

}

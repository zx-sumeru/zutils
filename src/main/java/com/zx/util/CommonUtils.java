package com.zx.util;


import java.util.Arrays;

/**
 * Create by zx on 2018/9/27 8:22
 */
public class CommonUtils {
    public static String[] SWITCH_ON_EXP = new String[]{"ON", "TRUE", "on", "true"};

    public static String[] SWITCH_OFF_EXP = new String[]{"OFF", "FALSE", "off", "false"};

    public static boolean isOn(String swtch) {

        if (Arrays.asList(SWITCH_ON_EXP).contains(swtch)) {
            return true;
        }
            return false;
    }

    public static boolean isPropKeyOn(String key) {

        String prop = System.getProperty(key);

        if (Arrays.asList(SWITCH_ON_EXP).contains(prop)) {
            return true;
        }

        return false;
    }
}
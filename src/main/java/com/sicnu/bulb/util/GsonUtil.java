package com.sicnu.bulb.util;

import com.google.gson.Gson;

/**
 * Created by HY
 * 2019/5/14 14:11
 * <p>
 * GsonUtil  采用单例模式
 *
 * @see Gson
 */
public class GsonUtil {

    private static Gson instance;

    private GsonUtil() {

    }

    //双重检测锁
    public static Gson getInstance() {
        if (instance == null) {
            synchronized (GsonUtil.class) {
                if (instance == null) {
                    instance = new Gson();
                }
            }
        }
        return instance;
    }

}

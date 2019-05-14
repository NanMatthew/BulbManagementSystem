package com.sicnu.bulb.util;

import java.util.List;

/**
 * Created by HY
 * 2019/5/14 13:47
 */
public class ListUtil {

    /**
     * 判断list是否为空
     */
    public static <T> boolean isEmpty(List<T> list) {
        return list != null && list.size() != 0;
    }

}

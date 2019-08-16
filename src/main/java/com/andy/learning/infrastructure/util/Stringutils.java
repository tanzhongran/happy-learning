package com.andy.learning.infrastructure.util;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Stringutils {

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 将pojo转化string
     * @param obj
     * @return
     */
    public static String toString(Object obj){
        return ToStringBuilder.reflectionToString(obj);
    }

}

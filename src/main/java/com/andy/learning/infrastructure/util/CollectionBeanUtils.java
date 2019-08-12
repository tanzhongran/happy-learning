package com.andy.learning.infrastructure.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;


public class CollectionBeanUtils {
    /**
     * 从对象列表中提取出某个字段的字符串列表
     * @param objList
     * @param fieldName
     * @return
     */
    public static <T> List<String> copyStringList(List<T> objList,String fieldName){
        List<String> strList = new ArrayList<>();
        try{
            for(T obj:objList){
                String str = String.valueOf(obj.getClass().getMethod("get"+Stringutils.upperCase(fieldName)).invoke(obj));
                strList.add(str);
            }
        }catch(Exception e){

        }
        return strList;
    }

}

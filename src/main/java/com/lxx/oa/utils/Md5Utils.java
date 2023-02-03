package com.lxx.oa.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description 对数据加解密工具类
 */
public class Md5Utils {
    public static String md5Digest(String source){
        return DigestUtils.md5Hex(source);
    }

    public static String md5Digest(String source, Integer salt){
        char[] chars = source.toCharArray();
        for(int i = 0; i < chars.length; i++){
            chars[i] = (char)(chars[i] + salt);
        }
        String target = new String(chars);
        System.out.println(target);
        String md5 = DigestUtils.md5Hex(target);
        return md5;
    }
}

package com.lxx.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class Md5UtilsTest {

    @Test
    public void md5Digest1() {
        String md5 = Md5Utils.md5Digest("123456");
        System.out.println(md5);
    }

    @Test
    public void md5Digest2() {
        String md5 = Md5Utils.md5Digest("123456", 888);
        System.out.println(md5);
    }
}
package com.lxx.oa.mapper;

import com.lxx.oa.entity.Notice;
import com.lxx.oa.utils.MybatisUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class NoticeMapperTest {

    @Test
    public void insert() {
        MybatisUtils.executeUpdate(sqlSession -> {
            NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
            Notice notice = new Notice(2l,"测试消息");
            mapper.insert(notice);
            return null;
        });
    }
}
package com.lxx.oa.service;

import com.lxx.oa.entity.Notice;
import com.lxx.oa.mapper.NoticeMapper;
import com.lxx.oa.utils.MybatisUtils;

import java.util.List;

/**
 * @author 林修贤
 * @date 2023/2/4
 * @description
 */
public class NoticeService {
    public List<Notice> getNoticeList(Long receiverId){
        return (List<Notice>)MybatisUtils.executeQuery(sqlSession -> {
            NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
            return mapper.selectByReceiverId(receiverId);
        });
    }
}

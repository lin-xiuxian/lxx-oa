package com.lxx.oa.mapper;

import com.lxx.oa.entity.Notice;

import java.util.List;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public interface NoticeMapper {
    public void insert(Notice notice);
    public List<Notice> selectByReceiverId(Long receiverId);
}

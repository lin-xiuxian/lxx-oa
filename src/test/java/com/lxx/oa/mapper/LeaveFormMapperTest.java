package com.lxx.oa.mapper;

import com.lxx.oa.entity.LeaveForm;
import com.lxx.oa.utils.MybatisUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class LeaveFormMapperTest {

    @Test
    public void insert() {
        MybatisUtils.executeUpdate(sqlsession -> {
            LeaveFormMapper mapper = sqlsession.getMapper(LeaveFormMapper.class);
            LeaveForm form = new LeaveForm();
            form.setEmployeeId(4l);
            form.setFormType(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
            Date startTime = null;
            Date endTime = null;
            try {
                startTime = sdf.parse("2020-03-25 08:00:00");
                endTime = sdf.parse("2020-04-01 18:00:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            form.setStartTime(startTime);
            form.setEndTime(endTime);
            form.setReason("回家探亲");
            form.setCreateTime(new Date());
            form.setState("processing");
            mapper.insert(form);
            return null;
        });
    }

    @Test
    public void selectByParams() {
        MybatisUtils.executeQuery(sqlSession -> {
            LeaveFormMapper mapper = sqlSession.getMapper(LeaveFormMapper.class);
            List<Map> list = mapper.selectByParams("process", 2l);
            System.out.println(list);
            return list;
        });
    }
}
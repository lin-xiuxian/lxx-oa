package com.lxx.oa.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

/**
 * @author 林修贤
 * @date 2023/2/2
 * @description 工具类确保 SqlSessionFactory 对象的唯一性
 */
public class MybatisUtils {
    //利用static(静态)属于类不属于对象,且全局唯一
    private static SqlSessionFactory sqlSessionFactory = null;
    //利用静态块在初始化类时实例化sqlSessionFactory
    static{
        Reader reader = null;
        try{
            //读取 mybatis-config.xml
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建 SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch(IOException e){
            //初始化错误时，抛出异常 ExceptionInInitializerError 通知调用者
            throw new ExceptionInInitializerError(e);
        }

    }

    /**
     * 执行 select 语句 查询SQL
     * @param func 要执行查询语句的代码块
     * @return 查询结果
     */
    public static Object executeQuery(Function<SqlSession, Object> func){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Object obj = func.apply(sqlSession);
            return obj;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 执行数据插入语句
     * @param func 要插入的语句代码块
     * @return 执行结果
     */
    public static Object executeUpdate(Function<SqlSession, Object> func){
        //openSession() 传入 false 参数表示手动提交/回滚事务
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Object obj = func.apply(sqlSession);
            sqlSession.commit();
            return obj;
        } catch (Exception e){
            sqlSession.rollback();
            throw e;
        } finally {
            sqlSession.close();
        }
    }
}

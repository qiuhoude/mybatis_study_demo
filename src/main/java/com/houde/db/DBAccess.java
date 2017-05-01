package com.houde.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 访问数据库
 * Created by Administrator on 2017/4/30.
 */
public class DBAccess {
    public SqlSession getSqlSession(String resource) throws IOException {
        if (resource == null || resource.isEmpty())
            resource = "com/houde/config/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }
}

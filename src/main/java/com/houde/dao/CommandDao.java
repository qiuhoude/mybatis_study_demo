package com.houde.dao;

import com.houde.bean.Command;
import com.houde.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 与指令表对应的数据库操作类
 */
public class CommandDao {
    /**
     * 根据查询条件查询指令列表
     */
    public List<Command> queryCommandList(String name, String description) {

        List<Command> commandList = new ArrayList<Command>();
        SqlSession sqlSession = null;
        try {
            sqlSession = DBAccess.getSqlSessionFactory().openSession();
            Command command = new Command();
            command.setName(name);
            command.setDescription(description);
            // 通过sqlSession执行SQL语句
            commandList = sqlSession.selectList("Command.queryCommandList", command);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return commandList;
    }
}

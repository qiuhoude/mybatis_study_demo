package com.houde.dao;

import com.houde.bean.Message;
import com.houde.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public class MessageDao {

    public List<Message> queryMsgListMybatis() {
        List<Message> msgList = new ArrayList<Message>();
        SqlSession session = null;
        try {
            session = DBAccess.getSqlSessionFactory().openSession();
            msgList = session.selectList("Message.list");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return msgList;
    }

    public static void main(String[] args) {
        MessageDao dao = new MessageDao();
        List<Message> li = dao.queryMsgListMybatis();
        System.out.println(li);
    }

    /**
     * JDBC 的方式
     *
     * @return
     * @throws SQLException
     */
    public List<Message> queryMsgList() throws SQLException {
        List<Message> msgList = new ArrayList<Message>();
        Connection connection = DBConnection.mysqlConnection;
        String sql = "select ID,COMMAND,DESCRIPTION,CONTENT from message WHERE 1=1 ";
        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setString(1, studentName);
        ResultSet rs = ps.executeQuery();
        Message msg = null;
        while (rs.next()) {
            msg = new Message(rs.getInt("ID"),
                    rs.getString("COMMAND"),
                    rs.getString("DESCRIPTION"),
                    rs.getString("CONTENT"));
            msgList.add(msg);
        }
        ps.close();
        rs.close();
        return msgList;
    }


}

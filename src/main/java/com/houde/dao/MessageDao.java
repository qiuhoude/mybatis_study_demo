package com.houde.dao;

import com.houde.bean.Message;

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

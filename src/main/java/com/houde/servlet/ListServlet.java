package com.houde.servlet;

import com.houde.bean.Message;
import com.houde.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
        MessageDao dao = new MessageDao();
        try {
            List<Message> msgList = dao.queryMsgList();
            req.setAttribute("messageList", msgList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

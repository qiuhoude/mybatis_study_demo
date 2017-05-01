package com.houde.servlet;

import com.houde.bean.Message;
import com.houde.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);

        req.setCharacterEncoding("utf-8");
        List<Message> msgList =new ArrayList<>();
        msgList.add(new Message(1,"hehe","去你额","嘻嘻"));
        req.setAttribute("messageList", msgList);
//        MessageDao dao = new MessageDao();
//        try {
//            List<Message> msgList = dao.queryMsgList();
//            req.setAttribute("messageList", msgList);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        // 设置每隔5秒自动刷新
//        resp.setIntHeader("Refresh", 5);
//        // 获取当前时间
//        Calendar calendar = new GregorianCalendar();
//        String am_pm;
//        int hour = calendar.get(Calendar.HOUR);
//        int minute = calendar.get(Calendar.MINUTE);
//        int second = calendar.get(Calendar.SECOND);
//        if(calendar.get(Calendar.AM_PM) == 0)
//            am_pm = "AM";
//        else
//            am_pm = "PM";
//        String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
//        resp.getWriter().append("当前时间: " + CT + "\n");
//        resp.getWriter().print("当前时间: " + CT + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

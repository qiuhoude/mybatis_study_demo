package com.houde.servlet;

import com.houde.bean.Message;
import com.houde.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 接受页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");

        QueryService listService = new QueryService();
        List<Message> msgList = listService.queryMessageList(command, description);
        if (msgList != null)
            req.setAttribute("messageList", msgList);
        // 向页面传值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        // 向页面跳转
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);

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
